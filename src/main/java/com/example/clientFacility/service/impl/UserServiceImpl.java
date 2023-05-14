package com.example.clientFacility.service.impl;

import com.example.clientFacility.entity.request.SignInRequest;
import com.example.clientFacility.entity.response.SignInResponse;
import com.example.clientFacility.entity.response.SignUpResponse;
import com.example.clientFacility.entity.request.SignUpRequest;
import com.example.clientFacility.exceptions.CustomException;
import com.example.clientFacility.constants.Role;
import com.example.clientFacility.model.Token;
import com.example.clientFacility.model.User;
import com.example.clientFacility.repository.UserRepository;
import com.example.clientFacility.service.IAuthenticationService;
import com.example.clientFacility.service.IUserService;
import com.example.clientFacility.util.PasswordHelper;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    IAuthenticationService authenticationService;

    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.findByEmail(signUpRequest.getEmail()) != null) {
            throw new CustomException("User already exists");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = PasswordHelper.encrypt(signUpRequest.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }

        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(), encryptedPassword);

        user.setRole(Role.USER);

        try {
            User createdUser = userRepository.save(user);
            authenticationService.saveConfirmationToken(new Token(createdUser));

            return new SignUpResponse("success", "User created");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }

    }

    public SignInResponse signIn(SignInRequest signInRequest) {
        try {
            User user = userRepository.findByEmail(signInRequest.getEmail());

            if (user == null) {
                throw new CustomException("user not present");
            }

            if (!user.getPassword().equals(PasswordHelper.encrypt(signInRequest.getPassword()))) {
                throw new CustomException("Wrong password");
            }

            String token = (authenticationService.retrieveToken(user).getToken());

            return new SignInResponse("success", user.getFirstName(), token);

        } catch (NoSuchAlgorithmException e) {
            throw new CustomException(e.getMessage());
        }
    }

}
