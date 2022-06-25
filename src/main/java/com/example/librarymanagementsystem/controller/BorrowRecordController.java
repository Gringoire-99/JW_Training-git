package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.common.ErrorStatus;
import com.example.librarymanagementsystem.common.Result;
import com.example.librarymanagementsystem.model.BorrowRecord;
import com.example.librarymanagementsystem.service.Imp.BorrowBookRecordImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/returnBook")
    public Result<BorrowRecord> returnBook(@RequestParam Long userId, @RequestParam Long bookId) {
        try {
            int change = borrowBookRecordImp.returnBook(userId, bookId);
            if (change == 0) throw new Exception("无借阅记录");
        } catch (Exception e) {
            return new Result<>(503, e.getMessage());
        }
        return new Result<>(ErrorStatus.OK);
    }

    @GetMapping("/getAllRecord")
    public Result<List<BorrowRecord>> getAllRecord() {
        List<BorrowRecord> allRecords;
        try {
            allRecords = borrowBookRecordImp.getAllRecords();
        } catch (Exception e) {
            return new Result<>(ErrorStatus.SERVICE_UNAVAILABLE);
        }
        Result<List<BorrowRecord>> listResult = new Result<>(ErrorStatus.OK);
        listResult.setData(allRecords);
        return listResult;
    }

    @PostMapping("/updateRecord")
    public Result<BorrowRecord> updateRecord(@RequestBody BorrowRecord borrowRecord) {
        try {
            borrowBookRecordImp.updateRecord(borrowRecord);
        } catch (Exception e) {
            return new Result<>(ErrorStatus.SERVICE_UNAVAILABLE);
        }
        return new Result<>(ErrorStatus.OK);
    }

    @DeleteMapping("deleteRecord")
    public Result<BorrowRecord> deleteRecord(@RequestParam Long borrowUserId, @RequestParam Long borrowBookId, @RequestParam String borrowDate, @RequestParam String returnDate) {
        BorrowRecord newRecord = new BorrowRecord(borrowBookId, borrowUserId, borrowDate, returnDate);
        try {
            borrowBookRecordImp.deleteRecord(newRecord);
        } catch (Exception e) {
            return new Result<>(ErrorStatus.SERVICE_UNAVAILABLE);
        }
        return new Result<>(ErrorStatus.OK);
    }
}
