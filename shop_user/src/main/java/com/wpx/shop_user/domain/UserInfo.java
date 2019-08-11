package com.wpx.shop_user.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userinfo")
public class UserInfo {
    //设置主键
    @Id
    @Column(name = "userNo", length = 30)
    private String userNo;

    //设置用户名唯一
    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    //设置用户密码
    @Column(name = "userPwd",length = 32)
    private String userPwd;

    //设置用户的生产日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "burnDate")
    private Date burnDate;

    public UserInfo() {
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getBurnDate() {
        return burnDate;
    }

    public void setBurnDate(Date burnDate) {
        this.burnDate = burnDate;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userNo='" + userNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", burnDate=" + burnDate +
                '}';
    }
}
