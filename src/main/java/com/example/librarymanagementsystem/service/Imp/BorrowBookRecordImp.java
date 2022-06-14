package com.example.librarymanagementsystem.service.Imp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.dao.BorrowRecordMapper;
import com.example.librarymanagementsystem.model.BorrowRecord;
import com.example.librarymanagementsystem.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BorrowBookRecordImp implements BorrowBookService {
    @Autowired
    BorrowRecordMapper borrowRecordMapper;

    @Override
    public void addRecord(BorrowRecord record) {
        borrowRecordMapper.insert(record);
    }

    @Override
    public List<BorrowRecord> getRecord(Long userId) {
        QueryWrapper<BorrowRecord> qw = new QueryWrapper<>();
        qw.orderByDesc("borrow_date");
        qw.eq("borrow_user_id", userId);
        return borrowRecordMapper.selectList(qw);
    }

    @Override
    public void returnBook(Long userId, Long bookId) {
        QueryWrapper<BorrowRecord> qw = new QueryWrapper<>();
        qw.eq("borrow_user_id", userId);
        qw.eq("borrow_book_id", bookId);
        borrowRecordMapper.delete(qw);
    }

    @Override
    public List<BorrowRecord> getAllRecords() {
        return borrowRecordMapper.selectList(null);
    }

    @Override
    public void updateRecord(BorrowRecord borrowRecord) {
        borrowRecordMapper.insert(borrowRecord);
    }

    @Override
    public void deleteRecord(BorrowRecord borrowRecord) {
        QueryWrapper<BorrowRecord> qw = new QueryWrapper<>();
        qw.eq("borrow_user_id", borrowRecord.getBorrowUserId());
        qw.eq("borrow_book_id", borrowRecord.getBorrowBookId());
        qw.eq("borrow_date", borrowRecord.getBorrowDate());
        qw.eq("return_date", borrowRecord.getReturnDate());

        borrowRecordMapper.delete(qw);
    }
}
