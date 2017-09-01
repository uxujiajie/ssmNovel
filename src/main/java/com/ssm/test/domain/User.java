package com.ssm.test.domain;

import java.math.BigDecimal;

/**
 * 用户实体类
 *
 * @author xu
 * @create 2017-07-23-10:53
 */
public class User {

    private Integer id;                     //id主键
    private String userName;            //用户名
    private String userPass;            //用户密码
    private String userPick;            //用户昵称
    private String userEmail;           //用户邮箱
    private BigDecimal userBalance;    //用户余额
    private Integer userRole;               //用户权限
    private String userAcode;           //用户激活码
    private String userTel;             //用户手机号
    private Integer userState;              //用户状态

    public User() {
    }


    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPick() {
        return userPick;
    }

    public void setUserPick(String userPick) {
        this.userPick = userPick;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getUserAcode() {
        return userAcode;
    }

    public void setUserAcode(String userAcode) {
        this.userAcode = userAcode;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
