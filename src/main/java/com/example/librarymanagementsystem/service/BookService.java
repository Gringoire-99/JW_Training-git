package com.example.librarymanagementsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.model.Book;

public interface BookService {
    /**
     * 实现对book的增删改查
     */
    void addBook(Book book);

    void deleteBook(Long id);

    void updateBook(Book book);

    Book getBookById(Long id);

    Book getUserByWrapper(QueryWrapper<Book> wrapper);
}
