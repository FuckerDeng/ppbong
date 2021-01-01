package com.df.ppbong.realm;

import com.df.ppbong.dao.UserDao;
import com.df.ppbong.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户名
        String principal = (String) authenticationToken.getPrincipal();
        User user = userDao.findOneByUserName(principal);
        //根据用户名从数据看查询用户数据（账号认证）
        //如果查到了，则返回一个AuthenticationInfo对象，进行下一步的密码认证
        if(ObjectUtils.isEmpty(user)){
            //认证失败
            return null;
        }
        //第一个为用户名，
        //第二个为数据库查到的密码,
        //第三个为盐
        //第四个为Realm的class名字
        return new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getSalt()),this.getName());

    }

}
