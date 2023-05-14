package com.example.clientFacility.entity.response;

public class SignInResponse {
    private String status;
    private String token;

    private String name;

    public SignInResponse(String status, String name, String token) {
        this.status = status;
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
