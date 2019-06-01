package com.tx.springboot.bmsystem.pojo;

public class Admin {
    private Integer adminid;

    private String adminname;

    private String adminpwd;

    private String adminemail;

    public Integer getAdminId() {
        return adminid;
    }

    public void setAdminId(Integer adminId) {
        this.adminid = adminId;
    }

    public String getAdminName() {
        return adminname;
    }

    public void setAdminName(String adminName) {
        this.adminname = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminpwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminpwd = adminPwd == null ? null : adminPwd.trim();
    }

    public String getAdminEmail() {
        return adminemail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminemail = adminEmail == null ? null : adminEmail.trim();
    }
}