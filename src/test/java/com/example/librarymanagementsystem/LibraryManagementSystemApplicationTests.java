package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryManagementSystemApplicationTests {
    @Autowired
    UserServiceImp userServiceImp;

    @Test
    void testUserMapper1() {
        User user = userServiceImp.getUser(202012900750L, "123456");
        System.out.println(user);

    }

}
