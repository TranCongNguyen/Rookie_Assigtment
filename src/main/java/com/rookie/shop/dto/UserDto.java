package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @NotNull
    private Long userId;

    @NotBlank
    @Length( min = 1, max = 30)
    private String username;

    @NotBlank
    @Length(min = 6, max = 20)
    private String password;

    @NotBlank
    private String fullName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    private Boolean gender;

    @NotNull
    private Short roleId;
}
