package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.BorrowRecord;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.service.BookServiceImp;
import com.example.librarymanagementsystem.service.BorrowBookRecordImp;
import com.example.librarymanagementsystem.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class LibraryManagementSystemApplicationTests {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    BookServiceImp bookServiceImp;
    @Autowired
    BorrowBookRecordImp borrowBookRecordImp;

    @Test
    void testUserMapper1() {
        User user = userServiceImp.getUser(202012900750L, "123456");
        System.out.println(user);
        for (User user1 : userServiceImp.getAllUser()) {
            System.out.println(user1);
        }

    }

    @Test
    void testBookMapper1() {
//        for (Book book : bookServiceImp.getAllBook()) {
//            System.out.println(book);
//        }
    }

    @Test
    void createBR() {
        Random rndYear = new Random();
        Random rndMonth = new Random();
        Random rndDay = new Random();
        List<User> allUser = userServiceImp.getAllUser();
        List<Book> allBook = bookServiceImp.getAllBook();
        List<BorrowRecord> records = new ArrayList<>();
        Random randomUser = new Random();
        Random randomBook = new Random();
        for (int i = 0; i < 100; i++) {
            int year = 2022;
            int month = rndMonth.nextInt(1, 12);
            int Day = rndDay.nextInt(1, 30);
            int returnDay = Day > 23 ? Day + 1 : Day + 7;
            Long userId = allUser.get(randomUser.nextInt(0, allUser.size() - 1)).getUserId();
            Long bookId = allBook.get(randomBook.nextInt(0, allBook.size() - 1)).getBookId();
            String borrowDate = "" + year + "-" + month + "-" + Day;
            String returnDate = "" + year + "-" + month + "-" + returnDay;
            borrowBookRecordImp.addRecord(new BorrowRecord(bookId, userId, borrowDate, returnDate));

        }
    }

}

