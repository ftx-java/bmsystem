package com.tx.springboot.bmsystem.service.impl;

import com.tx.springboot.bmsystem.dao.BorrowRecordMapper;
import com.tx.springboot.bmsystem.pojo.*;
import com.tx.springboot.bmsystem.dao.BookMapper;
import com.tx.springboot.bmsystem.service.IBookService;
import com.tx.springboot.bmsystem.utils.page.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 图书管理系统  图书操作
 * service层
 *
 * @author tx
 * @date 2019/03/31
 */
@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BorrowRecordMapper borrowRecordMapper;

    @Override
    public boolean addBook(Book book) {
        int n = bookMapper.insert(book);
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public Page<Book> selectAllByPage(int pageNum) {
        List<Book> books = bookMapper.selectByPageNum((pageNum - 1) * 10, 10);
        Page<Book> page = new Page<>();
        page.setList(books);
        page.setPageNum(pageNum);
        page.setPageSize(10);

        int bookCount = bookMapper.selectBookCount();
        int pageCount = bookCount / 10;
        if (bookCount % 10 != 0) {
            pageCount++;
        }
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public Book selectByBookId(int bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public boolean deleteByBookId(int bookId) {
        int n = bookMapper.deleteByPrimaryKey(bookId);
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        int n = bookMapper.updateByPrimaryKey(book);
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Book> findBookByKey(String bookKey) {
        return bookMapper.findBookByKey(bookKey);
    }

    @Override
    public List<Book> findBookByCategoryId(int bookCategoryId) {
        return bookMapper.findBookByCategoryId(bookCategoryId);
    }

    @Override
    public boolean borrowBooks(String userName, int bookId) {
        Book newBook = bookMapper.selectByPrimaryKey(bookId);
        int bookNum = newBook.getBookNumber();
        //书库中是否还有剩余
        if (bookNum > 0) {
            //每借一次书将书的数量减一
            bookNum = bookNum - 1;
            newBook.setBookNumber(bookNum);
            bookMapper.updateByPrimaryKey(newBook);
            //将借书记录加到借书记录表中
            BorrowRecord record = new BorrowRecord();
            record.setUserName(userName);
            record.setBookId(newBook.getBookId());
            record.setBookName(newBook.getBookName());
            record.setStates(1);
            borrowRecordMapper.insert(record);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void returnBooks(int borrowId) {
        //找到对应的借书记录
        BorrowRecord newRecord = borrowRecordMapper.selectByPrimaryKey(borrowId);
        //还书后将该书的剩余数量加一
        int bookId = newRecord.getBookId();
        Book newBook = bookMapper.selectByPrimaryKey(bookId);
        int bookNum = newBook.getBookNumber() + 1;
        newBook.setBookNumber(bookNum);
        bookMapper.updateByPrimaryKey(newBook);
        //将借书状态置为已还书状态
        newRecord.setStates(0);
        borrowRecordMapper.updateByPrimaryKey(newRecord);
    }
}
