package com.example.librarymanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
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
