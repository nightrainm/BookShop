package com.fc.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
public class User implements Serializable {
    private Integer uid;

    private String uname;

    private String upwd;

    private String urealname;

    private Date uredgt;

    private Integer urole;

    private String umark;

    private String uphone;

    private String uaddress;

    private boolean isadmin;

    public User(Integer uid, String uname, String upwd, String urealname, Date uredgt, Integer urole,
                String umark, String uphone, String uaddress) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.urealname = urealname;
        this.uredgt = uredgt;
        this.urole = urole;
        this.umark = umark;
        this.uphone = uphone;
        this.uaddress = uaddress;
        if (this.umark.equals("超级管理员")) {
            this.isadmin = true;
        }
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUrealname() {
        return urealname;
    }

    public void setUrealname(String urealname) {
        this.urealname = urealname;
    }

    public Date getUredgt() {
        return uredgt;
    }

    public void setUredgt(Date uredgt) {
        this.uredgt = uredgt;
    }

    public Integer getUrole() {
        return urole;
    }

    public void setUrole(Integer urole) {
        this.urole = urole;
    }

    public String getUmark() {
        return umark;
    }

    public void setUmark(String umark) {
        this.umark = umark;
        if (umark.equals("超级管理员")) {
            this.isadmin = true;
        }
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", urealname='" + urealname + '\'' +
                ", uredgt=" + uredgt +
                ", urole=" + urole +
                ", umark='" + umark + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", isadmin=" + isadmin +
                '}';
    }
}