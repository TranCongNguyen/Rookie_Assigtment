package com.rookie.shop.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserManagerController {

}
