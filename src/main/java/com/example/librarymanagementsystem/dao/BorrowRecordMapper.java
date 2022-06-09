package com.example.librarymanagementsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.librarymanagementsystem.model.BorrowRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BorrowRecordMapper extends BaseMapper<BorrowRecord> {
}
