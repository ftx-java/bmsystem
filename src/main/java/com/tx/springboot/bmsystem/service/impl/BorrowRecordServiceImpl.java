package com.tx.springboot.bmsystem.service.impl;

import com.tx.springboot.bmsystem.dao.BookMapper;
import com.tx.springboot.bmsystem.dao.BorrowRecordMapper;
import com.tx.springboot.bmsystem.pojo.BorrowRecord;
import com.tx.springboot.bmsystem.service.IBorrowRecordService;
import com.tx.springboot.bmsystem.utils.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 图书管理系统  借书记录
 * service层
 *
 * @author tx
 * @date 2019/03/31
 */
@Service
public class BorrowRecordServiceImpl implements IBorrowRecordService {
    @Resource
    private BookMapper bookMapper;

    @Resource
    private BorrowRecordMapper borrowRecordMapper;

    @Override
    public List<BorrowRecord> selectRecord(String userName) {
        return borrowRecordMapper.selectByUserName(userName);
    }

    @Override
    public Page<BorrowRecord> selectAllByPage(int pageNum) {
        List<BorrowRecord> records = borrowRecordMapper.selectAllByPage((pageNum - 1) * 10, 10);
        Page<BorrowRecord> page = new Page<>();
        page.setList(records);
        page.setPageNum(pageNum);
        page.setPageSize(10);

        int recordCount = borrowRecordMapper.selectRecordCount();
        int pageCount = recordCount / 10;
        if (recordCount % 10 != 0) {
            pageCount++;
        }
        page.setPageCount(pageCount);
        return page;
    }
}
