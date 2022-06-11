package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.common.ErrorStatus;
import com.example.librarymanagementsystem.common.Result;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.BorrowRecord;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.model.UserDetail;
import com.example.librarymanagementsystem.service.Imp.BookServiceImp;
import com.example.librarymanagementsystem.service.Imp.BorrowBookRecordImp;
import com.example.librarymanagementsystem.service.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    BookServiceImp bookServiceImp;
    @Autowired
    BorrowBookRecordImp borrowBookRecordImp;

    @GetMapping("/login")
    public Result<User> login(@RequestParam Long userId, @RequestParam String password, HttpServletRequest request) {
        User user = userServiceImp.getUser(userId, password);
        if (user == null) {
            return new Result<User>(ErrorStatus.FORBIDDEN).fail();
        }
        Result<User> userResult = new Result<>(ErrorStatus.OK);
        userResult.setData(user);
        return userResult;
    }

    @GetMapping("/getUserDetail")
    public Result<UserDetail> getUserDetail(@RequestParam Long userId) {
        UserDetail userDetail = null;
        try {
            List<BorrowRecord> record = borrowBookRecordImp.getRecord(userId);
            if (record.size() > 0) {
                Book book = bookServiceImp.getBookById(record.get(0).getBorrowBookId());
                userDetail = new UserDetail(record, book);
            } else return new Result<>(ErrorStatus.OK);

        } catch (Exception e) {
            return new Result<>(ErrorStatus.SERVICE_UNAVAILABLE);
        }
        Result<UserDetail> userDetailResult = new Result<>(ErrorStatus.OK);
        userDetailResult.setData(userDetail);
        return userDetailResult;
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        System.out.println(user);
        userServiceImp.updateUser(user);
    }
}
