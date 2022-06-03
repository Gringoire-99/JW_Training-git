package com.example.librarymanagementsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.librarymanagementsystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
interface UserMapper extends BaseMapper<User> {
}
