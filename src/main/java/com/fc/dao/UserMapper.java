package com.fc.dao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
    User findById(String uname);
    int insert(User user);
}