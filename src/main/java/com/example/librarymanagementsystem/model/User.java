package com.example.librarymanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("library_management_system.user")
public class User {
    Long userId;
    String userName;
    String userPassword;
    String role;
    String birthdate;
    String gender;
    String remark;
}
