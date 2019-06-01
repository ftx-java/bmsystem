package com.tx.springboot.bmsystem.service;


import com.tx.springboot.bmsystem.pojo.BookCategory;
import com.tx.springboot.bmsystem.utils.page.Page;

public interface IBookCategoryService {

    //图书类别分页查询
    public Page<BookCategory> selectBookCategoryByPageNum(int pageNum);

    int deleteBookCategoryById(int bookCategoryId);
}
