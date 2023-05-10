package com.example.clientFacility.controller;

import com.example.clientFacility.DTO.ResponseDTO;
import com.example.clientFacility.DTO.SignUpDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.clientFacility.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;
    @PostMapping("signup")
    public ResponseDTO Signup(@RequestBody SignUpDTO signUpDTO) {
        return userService.signUp(signUpDTO);
    }

    @PostMapping("/login")
    public String Login() {
        return "Hello";
    }

}
