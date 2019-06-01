package com.tx.springboot.bmsystem.dao;


import com.tx.springboot.bmsystem.pojo.Book;
import com.tx.springboot.bmsystem.pojo.BookExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书管理系统  图书操作
 * dao层
 *
 * @author tx
 * @date 2019/03/31
 */
@Mapper
public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 按书籍种类分页查找
     *
     * @param categoryId
     * @param currIndex
     * @param PageSize
     * @return
     */
    List<Book> selectByCategoryId(@Param("categoryId") int categoryId, @Param("currIndex") int currIndex, @Param("pageSize") int PageSize);

    /**
     * 查找某一类别书籍的总数
     *
     * @param categoryId
     * @return
     */
    int selectBookCountByCategoryId(@Param("categoryId") int categoryId);

    /**
     * 查找所有图书信息
     *
     * @return
     */
    List<Book> selectAll();

    /**
     * 分页查询
     *
     * @param currIndex
     * @param pageSize
     * @return
     */
    List<Book> selectByPageNum(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);

    /**
     * 查询总数
     */
    int selectBookCount();

    /**
     * 按照关键字查书
     *
     * @param bookKey
     * @return
     */
    List<Book> findBookByKey(@Param("bookKey") String bookKey);

    /**
     * 按书籍种类查找
     *
     * @param bookCategoryId
     * @return
     */
    List<Book> findBookByCategoryId(@Param("bookCategoryId") int bookCategoryId);
}