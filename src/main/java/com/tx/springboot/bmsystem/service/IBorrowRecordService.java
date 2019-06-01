package com.tx.springboot.bmsystem.service;


import com.tx.springboot.bmsystem.pojo.BorrowRecord;
import com.tx.springboot.bmsystem.utils.page.Page;

import java.util.List;

/**
 * 图书管理系统  借书记录
 * service层
 *
 * @author tx
 * @date 2019/03/31
 */
public interface IBorrowRecordService {

    /**
     * 用户查询自己借书记录
     *
     * @param userName
     * @return
     */
    public List<BorrowRecord> selectRecord(String userName);

    /**
     * 分页查询所有用户借书记录
     *
     * @param pageNum
     * @return
     */
    public Page<BorrowRecord> selectAllByPage(int pageNum);
}
