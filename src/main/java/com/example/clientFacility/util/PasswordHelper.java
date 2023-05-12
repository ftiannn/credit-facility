package com.example.clientFacility.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordHelper {
    public static String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("SHA-256");

        byte[] digest = m.digest(password.getBytes(StandardCharsets.UTF_8));

        String s = Base64.getEncoder().encodeToString(digest);

        return s.toUpperCase();
    }

}
