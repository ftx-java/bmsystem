package com.tx.springboot.bmsystem.service;

import com.tx.springboot.bmsystem.pojo.Book;
import com.tx.springboot.bmsystem.utils.page.Page;

import java.util.List;
/**
 * 图书管理系统  图书操作
 * service层
 *
 * @author tx
 * @date 2019/03/31
 */
public interface IBookService {

    /**
     * 录入新书
     */
    public boolean addBook(Book book);

    /**
     * 查找所有图书信息
     */
    public List<Book> selectAll();
    /**
     * 查找所有图书信息 分页查询
     */
    public Page<Book> selectAllByPage(int pageNum);
    /**
     * 根据bookId查询书籍
     */
    public Book selectByBookId(int bookId);
    /**
     * 根据bookId删除书籍
     */
    public boolean deleteByBookId(int bookId);
    /**
     * 更改书籍信息
     */
    public boolean updateBook(Book book);
    /**
     * 按照关键字查书
     */
    public List<Book> findBookByKey(String bookKey);
    /**
     * 根据书籍种类id查找书籍
     */
    public List<Book> findBookByCategoryId(int bookCategoryId);
    /**
     * 借书
     */
    public boolean borrowBooks(String userName, int bookId);
    /**
     * 还书
     */
    public void returnBooks(int borrowId);
}
