package com.example.clientFacility.service.impl;

import com.example.clientFacility.model.Token;
import com.example.clientFacility.model.User;
import com.example.clientFacility.repository.TokenRepository;
import com.example.clientFacility.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    TokenRepository tokenRepository;
    public void saveConfirmationToken(Token authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public Token retrieveToken(User user) {
        return tokenRepository.findTokenByUser(user);
    }
}
