package com.example.clientFacility.service;

import com.example.clientFacility.model.Token;
import com.example.clientFacility.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    TokenRepository tokenRepository;
    public void saveConfirmationToken(Token authenticationToken) {
        tokenRepository.save(authenticationToken);
    }
}
