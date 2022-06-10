package com.example.librarymanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("library_management_system.borrow_record")
public class BorrowRecord {
    Long borrowBookId;
    Long borrowUserId;
    String borrowDate;
    String returnDate;
}
