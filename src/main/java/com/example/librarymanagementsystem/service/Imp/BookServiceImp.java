package com.example.librarymanagementsystem.service.Imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.dao.BookMapper;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public void deleteBook(Long id) {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.eq("book_id", id);
        bookMapper.delete(qw);
    }

    @Override
    public void updateBook(Book book) {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.eq("book_id", book.getBookId());
        bookMapper.update(book, qw);

    }

    @Override
    public Book getBookById(Long id) {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.eq("book_id", id);
        return bookMapper.selectOne(qw);
    }

    @Override
    public Book getUserByWrapper(QueryWrapper<Book> wrapper) {
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        return bookMapper.selectList(null);
    }
}
