package com.example.librarymanagementsystem.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.librarymanagementsystem.dao.BorrowRecordMapper;
import com.example.librarymanagementsystem.model.BorrowRecord;
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
        qw.eq("borrow_", userId);
        return borrowRecordMapper.selectList(qw);
    }
}
