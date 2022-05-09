package com.fc.dao;

import com.fc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User findByUserName(@Param("uname") String uname);

    User findById(@Param("uid") Integer uid);
    User selectByPrimaryKey(Integer uId);

    List<User> findAll();

    int delete(Integer uId);

    int update(User user);

    int updatePassword(@Param("uid") Integer uid, @Param("upwd") String upwd);

    int insert(User user);

}