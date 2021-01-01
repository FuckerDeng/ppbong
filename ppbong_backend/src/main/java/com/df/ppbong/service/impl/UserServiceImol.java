package com.df.ppbong.service.impl;

import com.df.ppbong.dao.UserDao;
import com.df.ppbong.entity.User;
import com.df.ppbong.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class  UserServiceImol implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void register(User user) {
        //生成随机盐
        String salt = "123";
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),"123",1024);
        user.setPassword(md5Hash.toHex());
        userDao.save(user);
    }
    @Override
    public User findOneByUserName( String username){
        User oneByUserName = userDao.findOneByUserName(username);
        return oneByUserName;
    }

}
