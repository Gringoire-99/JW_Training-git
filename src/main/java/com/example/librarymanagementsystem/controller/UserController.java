package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.common.ErrorStatus;
import com.example.librarymanagementsystem.common.Result;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping("/login")
    public Result<User> login(@RequestParam Long userId, @RequestParam String password, HttpServletRequest request) {
        User user = userServiceImp.getUser(userId, password);
        if (user == null) {
            return new Result<User>(ErrorStatus.FORBIDDEN).fail();
        }
        Result<User> userResult = new Result<>(ErrorStatus.OK);
        userResult.setData(user);
        return userResult;
    }
}
