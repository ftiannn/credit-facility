package com.example.clientFacility.service;

import com.example.clientFacility.model.Token;
import com.example.clientFacility.model.User;

public interface IAuthenticationService {
    public void saveConfirmationToken(Token authenticationToken);

    public Token getToken(User user);
}
