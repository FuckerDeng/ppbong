package com.df.ppbong.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {
    private static final String SIGN = "my-secreate";

    public static String createJwtToken(Map<String,String> payload){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);//7天过期
        JWTCreator.Builder builder = JWT.create();
        payload.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(calendar.getTime())//过期时间
                .sign(Algorithm.HMAC256(SIGN));//签名
        return token;
    }

    public static DecodedJWT validateJwtToken(String token){
        DecodedJWT result = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return result;
    }
}
