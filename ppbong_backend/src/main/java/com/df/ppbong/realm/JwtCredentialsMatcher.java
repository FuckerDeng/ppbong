package com.df.ppbong.realm;

import com.df.ppbong.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class JwtCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        try {
            JwtUtils.validateJwtToken((String) token.getPrincipal());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
