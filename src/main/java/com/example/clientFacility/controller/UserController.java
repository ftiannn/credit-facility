package com.example.clientFacility.controller;

import com.example.clientFacility.entity.request.SignInRequest;
import com.example.clientFacility.entity.response.SignInResponse;
import com.example.clientFacility.entity.response.SignUpResponse;
import com.example.clientFacility.entity.request.SignUpRequest;
import com.example.clientFacility.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/signup")
    public SignUpResponse Signup(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public SignInResponse SignIn(@RequestBody SignInRequest signInRequest) {
        return userService.signIn(signInRequest);
    }
}
