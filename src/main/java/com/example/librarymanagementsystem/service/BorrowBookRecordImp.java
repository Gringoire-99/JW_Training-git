package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.dao.BorrowRecordMapper;
import com.example.librarymanagementsystem.model.BorrowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BorrowBookRecordImp implements BorrowBookService {
    @Autowired
    BorrowRecordMapper borrowRecordMapper;

    @Override
    public void addRecord(BorrowRecord record) {
        borrowRecordMapper.insert(record);
    }
}
