package com.blanat.blanatfront.utils;

public class JwtAuthenticationResponse {
    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    String token;

    public String getToken() {
        return token;
    }
}
