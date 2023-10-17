package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String accessToken;
    private String tokenType="Bearer ";

    public AuthResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponse() {
    }
}
