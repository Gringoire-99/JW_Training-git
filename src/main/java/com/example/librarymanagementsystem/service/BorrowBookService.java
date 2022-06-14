package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.BorrowRecord;

import java.util.List;

public interface BorrowBookService {
    void addRecord(BorrowRecord record);

    List<BorrowRecord> getRecord(Long userId);

    void returnBook(Long userId, Long bookId);

    List<BorrowRecord> getAllRecords();

    void updateRecord(BorrowRecord borrowRecord);

    void deleteRecord(BorrowRecord borrowRecord);

}
