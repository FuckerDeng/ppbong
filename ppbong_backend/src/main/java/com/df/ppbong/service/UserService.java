package com.df.ppbong.service;

import com.df.ppbong.entity.User;


public interface UserService {
    void register(User user);
    User findOneByUserName( String username);

}
