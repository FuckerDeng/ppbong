package com.df.ppbong;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class PpbongBackendApplicationTests {

	@Test
	void contextLoads() {
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken("dengfan","123456");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void jwtTest(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND,20);//20秒过期
		Map<String,Object> map = new HashMap<>();
		String token = JWT.create()
				.withHeader(map)//header,如果是默认值可以不写
				.withClaim("username", "dengfan")//payload
				.withClaim("headerImg", "imgUrl")
				.withExpiresAt(calendar.getTime())//过期时间
				.sign(Algorithm.HMAC256("my-secreate"));//签名
		System.out.println(token);
	}

}
