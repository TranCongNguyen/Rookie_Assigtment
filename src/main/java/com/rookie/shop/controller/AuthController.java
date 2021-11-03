package com.rookie.shop.controller;

import com.rookie.shop.constant.ErrorCode;
import com.rookie.shop.constant.SuccessCode;
import com.rookie.shop.entity.Role;
import com.rookie.shop.entity.RoleName;
import com.rookie.shop.entity.User;
import com.rookie.shop.exception.ResponseMessageException;
import com.rookie.shop.payload.request.LoginRequest;
import com.rookie.shop.payload.request.SignupRequest;
import com.rookie.shop.payload.response.JwtResponse;
import com.rookie.shop.repository.RoleRepository;
import com.rookie.shop.repository.UserRepository;
import com.rookie.shop.security.jwt.JwtUtils;
import com.rookie.shop.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder pe;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles =  userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());

        return  ResponseEntity.ok(new JwtResponse(jwt,userDetails.getId(),userDetails.getUsername(),userDetails.getPassword(),roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
        if(userRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.badRequest().body(
                    new ResponseMessageException(ErrorCode.ERR_USERNAME_IS_TAKEN));
        }

        if(userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(
                    new ResponseMessageException(ErrorCode.ERR_EMAIL_IS_TAKEN));
        }

        // Create new user's account
        User user = new User(signupRequest.getUsername(),
                                signupRequest.getFullName(),
                                signupRequest.getEmail(),
                                signupRequest.getPhone(),
                                pe.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if(strRoles == null){
            Role userRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                    .orElseThrow(() -> new RuntimeException(ErrorCode.ERR_ROLE_NAME_ID_NOT_FOUND));
            roles.add(userRole);
        }else {
            strRoles.forEach(role -> {
                switch (role){
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(ErrorCode.ERR_ROLE_NAME_ID_NOT_FOUND));
                        roles.add(adminRole);
                        break;
                    case "manager":
                        Role manaRole = roleRepository.findByName(RoleName.ROLE_MANAGER)
                                .orElseThrow(() -> new RuntimeException(ErrorCode.ERR_ROLE_NAME_ID_NOT_FOUND));
                        roles.add(manaRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                                .orElseThrow(() -> new RuntimeException(ErrorCode.ERR_ROLE_NAME_ID_NOT_FOUND));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(SuccessCode.SUCCESS_USER_SIGN_UP);
    }
}
