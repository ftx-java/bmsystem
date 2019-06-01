package com.tx.springboot.bmsystem.pojo;

import java.util.Date;

public class BorrowRecord {
    private Integer borrowId;

    private String userName;

    private Integer bookId;

    private String bookName;

    private Integer states;

    private Date date;

    public BorrowRecord(Integer borrowId, String userName, Integer bookId, String bookName, Integer states, Date date) {
        this.borrowId = borrowId;
        this.userName = userName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.states = states;
        this.date = date;
    }

    public BorrowRecord() {
        super();
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}