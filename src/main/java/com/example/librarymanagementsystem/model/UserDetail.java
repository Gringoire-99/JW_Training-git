package com.example.librarymanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    //用户头像信息（暂不使用）
//    Blob avatar;
    //收藏书籍（暂不使用）
//    List<Book> collect;

    //用户的借书记录
    List<BorrowRecord> records;
    //用户正在读的书（最近借的书）
    Book readingBook;
}
