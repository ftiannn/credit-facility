package com.example.clientFacility.service;

import com.example.clientFacility.entity.request.SignInRequest;
import com.example.clientFacility.entity.response.SignInResponse;
import com.example.clientFacility.entity.response.SignUpResponse;
import com.example.clientFacility.entity.request.SignUpRequest;

public interface IUserService {
    public SignUpResponse signUp(SignUpRequest signUpRequest);

    public SignInResponse signIn(SignInRequest signInRequest);

}
