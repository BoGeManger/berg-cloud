package com.berg.auth.system.auth;

import lombok.Data;

@Data
public class AuthenticationToken {
    private String token;

    private String exipreAt;

    public AuthenticationToken(String token) {
        this.token = token;
    }

    public AuthenticationToken(String token, String exipreAt) {
        this.token = token;
        this.exipreAt = exipreAt;
    }
}
