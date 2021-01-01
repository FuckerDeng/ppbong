package com.df.ppbong.dao;

import com.df.ppbong.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {


    void save(@Param("user") User user);

    User findOneByUserName(@Param("username") String username);
}
