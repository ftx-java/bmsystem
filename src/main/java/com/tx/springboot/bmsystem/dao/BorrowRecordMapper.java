package com.tx.springboot.bmsystem.dao;

import com.tx.springboot.bmsystem.pojo.BorrowRecord;
import com.tx.springboot.bmsystem.pojo.BorrowRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BorrowRecordMapper {
    int countByExample(BorrowRecordExample example);

    int deleteByExample(BorrowRecordExample example);

    int deleteByPrimaryKey(Integer borrowId);

    int insert(BorrowRecord record);

    int insertSelective(BorrowRecord record);

    List<BorrowRecord> selectByExample(BorrowRecordExample example);

    BorrowRecord selectByPrimaryKey(Integer borrowId);

    int updateByExampleSelective(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByExample(@Param("record") BorrowRecord record, @Param("example") BorrowRecordExample example);

    int updateByPrimaryKeySelective(BorrowRecord record);

    int updateByPrimaryKey(BorrowRecord record);

    /**
     * 根据用户名查找自己借书记录
     *
     * @param userName
     * @return
     */
    List<BorrowRecord> selectByUserName(String userName);

    /**
     * 查询总数
     *
     * @return
     */
    int selectRecordCount();

    /**
     * 分页查询所有记录
     *
     * @return
     */
    List<BorrowRecord> selectAllByPage(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);
}