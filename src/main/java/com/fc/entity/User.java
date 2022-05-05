package com.fc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
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
        if (umark.equals("超级管理员")) {
            this.isadmin = true;
        }
    }
}