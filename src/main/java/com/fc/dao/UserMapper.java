package com.fc.dao;

import com.fc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(User user);

    int delete(Integer uId);

    int update(User user);

    User findByUserName(@Param("uname") String uname);

    User findById(@Param("uid") Integer uid);

    List<User> findAll();

}