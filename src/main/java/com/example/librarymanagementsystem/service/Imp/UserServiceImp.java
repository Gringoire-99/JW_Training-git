package com.example.librarymanagementsystem.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.dao.UserMapper;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    public User getUser(Long id, String password) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_id", id);
        qw.eq("user_password", password);
        return userMapper.selectOne(qw);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_id", user.getUserId());
        userMapper.update(user, qw);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User getUserByWrapper(QueryWrapper<User> wrapper) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        QueryWrapper<User> qw = new QueryWrapper<>();
        return userMapper.selectList(qw);
    }
}
