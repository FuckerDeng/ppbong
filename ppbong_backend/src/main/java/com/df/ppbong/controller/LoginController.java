package com.df.ppbong.controller;


import com.df.ppbong.common.R;
import com.df.ppbong.entity.User;
import com.df.ppbong.service.UserService;
import com.df.ppbong.utils.JwtUtils;
import com.df.ppbong.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("user/login")
    public R login(@Validated @RequestBody UserVo user){
        Subject subject = SecurityUtils.getSubject();
//        subject.login();
        AuthenticationToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                User principal = (User) subject.getPrincipal();
                Map<String,String> map = new HashMap<>();
                map.put("username",principal.getUsername());
                String jwtToken = JwtUtils.createJwtToken(map);
                return R.OK().setMsg("登陆成功！").setData(jwtToken);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return R.ERROR().setMsg("登陆失败");
    }

    @RequestMapping("/test")
    @RequiresRoles("admin")
    public R shiroTest(){
        return R.OK().setMsg("测试成功！");

    }

    @RequestMapping("/user/register")
    public R register(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setSalt("123");
        userService.register(user);
        return R.OK().setMsg("注册成功");
    }
}
