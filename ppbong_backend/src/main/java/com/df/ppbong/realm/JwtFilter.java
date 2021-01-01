package com.df.ppbong.realm;

import com.df.ppbong.common.R;
import com.df.ppbong.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //TODO 检查请求是否是跨域的预检请求，是的话直接放行
        String token = request.getHeader("token");
        if(token==null){//token为空，禁止访问，需要重新登陆
            R r = R.ERROR("token is empty");
            String error = new ObjectMapper().writeValueAsString(r);
            servletResponse.setContentType("application/json; charset=utf-8");
            servletResponse.getWriter().write(error);
            return;
        }

        Subject subject = SecurityUtils.getSubject();
        JwtToken jwtToken = new JwtToken(token);

        try {
            //每次请求都认证
            subject.login(jwtToken);
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (AuthenticationException e) {
            //TODO 如果是过期异常，则刷新令牌（考虑是否要刷新，让用户强制登陆一次）
            e.printStackTrace();
            R r = R.ERROR("valide token");
            String error = new ObjectMapper().writeValueAsString(r);
            servletResponse.setContentType("application/json; charset=utf-8");
            servletResponse.getWriter().write(error);
        }
    }
}
