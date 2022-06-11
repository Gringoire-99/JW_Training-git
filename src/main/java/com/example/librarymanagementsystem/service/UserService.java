package com.example.librarymanagementsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.model.User;

import java.util.List;

public interface UserService {
    /**
     * 增删改查
     */

    User getUser(Long id, String password);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserByWrapper(QueryWrapper<User> wrapper);

    List<User> getAllUser();
}
