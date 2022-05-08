package com.fc.dao;

import com.fc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByUserName(@Param("uname") String uname);

    User findById(@Param("uid") Integer uid);

    int insert(User user);

    int update(User user);
}