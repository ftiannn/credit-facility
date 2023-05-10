package com.example.clientFacility.exceptions;

public class CustomException extends IllegalArgumentException {
    public CustomException(String msg) {
        super(msg);
    }
}
