package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.common.ErrorStatus;
import com.example.librarymanagementsystem.common.Result;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.Imp.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookServiceImp bookServiceImp;

    @GetMapping("/getAllBooks")
    public Result<List<Book>> getAllBooks() {
        List<Book> allBook = bookServiceImp.getAllBook();
        Result<List<Book>> listResult = new Result<>(ErrorStatus.OK);
        listResult.setData(allBook);
        return listResult;
    }

    @DeleteMapping("/deleteBook")
    public Result<Book> deleteBook(@RequestParam Long bookId) {
        try {
            bookServiceImp.deleteBook(bookId);
        } catch (Exception e) {
            return new Result<>(ErrorStatus.SERVICE_UNAVAILABLE);
        }
        return new Result<>(ErrorStatus.OK);
    }
}
