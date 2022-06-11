package com.example.librarymanagementsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.dao.BookMapper;
import com.example.librarymanagementsystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book getUserByWrapper(QueryWrapper<Book> wrapper) {
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        List<Book> books = bookMapper.selectList(qw);
        return books;
    }
}
