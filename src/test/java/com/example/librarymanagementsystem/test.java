package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.BorrowRecord;
import com.example.librarymanagementsystem.model.User;
import com.example.librarymanagementsystem.model.UserDetail;
import com.example.librarymanagementsystem.service.Imp.BookServiceImp;
import com.example.librarymanagementsystem.service.Imp.BorrowBookRecordImp;
import com.example.librarymanagementsystem.service.Imp.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

//    @Test
//    void createBR() {
//        //批量插入测试数据
//        Random rndMonth = new Random();
//        Random rndDay = new Random();
//        List<User> allUser = userServiceImp.getAllUser();
//        List<Book> allBook = bookServiceImp.getAllBook();
//        List<BorrowRecord> records = new ArrayList<>();
//        Random randomUser = new Random();
//        Random randomBook = new Random();
//        for (int i = 0; i < 100; i++) {
//            int year = 2022;
//            int month = rndMonth.nextInt(1, 12);
//            int Day = rndDay.nextInt(1, 27);
//            int returnDay = Day > 20 ? Day + 1 : Day + 7;
//            Long userId = allUser.get(randomUser.nextInt(0, allUser.size() - 1)).getUserId();
//            Long bookId = allBook.get(randomBook.nextInt(0, allBook.size() - 1)).getBookId();
//            String borrowDate = "" + year + "-" + month + "-" + Day;
//            String returnDate = "" + year + "-" + month + "-" + returnDay;
//            borrowBookRecordImp.addRecord(new BorrowRecord(bookId, userId, borrowDate, returnDate));
//
//        }
//    }

    @Test
    void testGetRecords() {
        UserDetail userDetail = null;
        List<BorrowRecord> record = borrowBookRecordImp.getRecord(202012900750L);
        Book book = bookServiceImp.getBookById(record.get(0).getBorrowBookId());
        userDetail = new UserDetail(record, book);

        System.out.println(userDetail);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setUserId(202012900755L);
        user.setUserName("LLD");
        user.setGender(null);
        userServiceImp.updateUser(user);
    }

    @Test
    void register() {
        User user = new User();
        user.setUserId(999L);
        user.setUserName("test");
        user.setUserPassword("test");
        userServiceImp.addUser(user);
    }

    @Test
    void deleteBook() {
        bookServiceImp.deleteBook(2022703L);
    }

    @Test
    void addRecord() {
        BorrowRecord borrowRecord = new BorrowRecord(2022652L, 444444444L, "2022-6-12", "2022-6-13");
        borrowBookRecordImp.addRecord(borrowRecord);
    }

    @Test
    void getAllRecord() {
        for (BorrowRecord allRecord : borrowBookRecordImp.getAllRecords()) {
            System.out.println(allRecord);
        }

    }
}

