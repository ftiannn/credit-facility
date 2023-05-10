package com.example.clientFacility.service;

import com.example.clientFacility.model.Token;
import com.example.clientFacility.repository.TokenRepository;

public class AuthenticationService {
    TokenRepository tokenRepository;
    public void saveConfirmationToken(Token authenticationToken) {
        tokenRepository.save(authenticationToken);
    }
}
