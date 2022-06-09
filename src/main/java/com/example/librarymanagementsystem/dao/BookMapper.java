package com.example.librarymanagementsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.librarymanagementsystem.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
