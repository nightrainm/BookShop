package com.fc.dao;

import com.fc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User row);


    User selectByPrimaryKey(Integer uId);
}