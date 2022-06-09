package com.example.librarymanagementsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    public User getUserById(int id) {

        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getUserByWrapper(QueryWrapper<User> wrapper) {
        return null;
    }
}
