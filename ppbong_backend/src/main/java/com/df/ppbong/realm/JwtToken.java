package com.df.ppbong.realm;

import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    public JwtToken(String token) {
        this.token = token;
    }

    private String token;
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
