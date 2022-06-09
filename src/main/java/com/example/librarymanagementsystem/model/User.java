package com.example.librarymanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("library_management_system.user")
public class User {
    Long userId;
    String userName;
    String userPassword;
    String role;
}
