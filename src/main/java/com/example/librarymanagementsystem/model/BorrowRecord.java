package com.example.librarymanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("library_management_system.borrow_record")
public class BorrowRecord {
    Long borrowBookId;
    Long borrowUserId;
    String borrowDate;
    String returnDate;
}
