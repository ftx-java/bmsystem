package com.tx.springboot.bmsystem.pojo;

public class User {
    private Integer userid;

    private String username;

    private String userpwd;

    private String useremail;

    public Integer getUserId() {
        return userid;
    }

    public void setUserId(Integer userId) {
        this.userid = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userpwd;
    }

    public void setUserPwd(String userPwd) {
        this.userpwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserEmail() {
        return useremail;
    }

    public void setUserEmail(String userEmail) {
        this.useremail = userEmail == null ? null : userEmail.trim();
    }
}