package com.example.librarymanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("library_management_system.book")
public class Book {
    Long bookId;
    String bookName;
    String bookAuthor;
    String press;
    BigDecimal bookPrice;
    Integer bookNumber;
    Integer borrowNumber;
    String remark;

}
