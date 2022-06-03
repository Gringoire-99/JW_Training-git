package com.example.librarymanagementsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.model.User;

public interface UserService {
    /**
     * 增删改查
     */

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserByWrapper(QueryWrapper<User> wrapper);
}
