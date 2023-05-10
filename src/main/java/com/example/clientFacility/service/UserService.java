package com.example.clientFacility.service;

import com.example.clientFacility.DTO.ResponseDTO;
import com.example.clientFacility.DTO.SignUpDTO;
import com.example.clientFacility.exceptions.CustomException;
import com.example.clientFacility.DTO.Enums.Role;
import com.example.clientFacility.model.Token;
import com.example.clientFacility.model.User;
import com.example.clientFacility.repository.UserRepository;
import com.example.clientFacility.util.PasswordHelper;

import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;
    public ResponseDTO signUp(SignUpDTO signUpDTO) {
        String encryptedPassword = signUpDTO.getPassword();

        try {
            encryptedPassword = PasswordHelper.encrypt(signUpDTO.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }

        User user = new User(signUpDTO.getFirstName(), signUpDTO.getLastName(), signUpDTO.getEmail(), signUpDTO.getUserName(), encryptedPassword);

        user.setRole(Role.USER);

        try {
            User createdUser = userRepository.save(user);
            authenticationService.saveConfirmationToken(new Token(createdUser));

            return new ResponseDTO("success", "User created");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }

    }
}
