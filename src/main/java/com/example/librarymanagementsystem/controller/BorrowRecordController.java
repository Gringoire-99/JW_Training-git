package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.common.ErrorStatus;
import com.example.librarymanagementsystem.common.Result;
import com.example.librarymanagementsystem.model.BorrowRecord;
import com.example.librarymanagementsystem.service.Imp.BorrowBookRecordImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowRecordController {
    @Autowired
    BorrowBookRecordImp borrowBookRecordImp;

    @PostMapping("/borrowBook")
    public Result<BorrowRecord> borrowRecord(@RequestBody BorrowRecord borrowRecord) {
        try {
            borrowBookRecordImp.addRecord(borrowRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(ErrorStatus.SERVICE_UNAVAILABLE);
        }
        return new Result<>(ErrorStatus.OK);
    }
}
