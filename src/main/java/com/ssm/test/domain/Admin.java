package com.ssm.test.domain;

/**
 * 管理员类
 *
 * @author xu
 * @create 2017-08-10-21:38
 */
public class Admin {
    private String adUser;
    private String adPass;
    private Integer roleId;

    public String getAdUser() {
        return adUser;
    }

    public void setAdUser(String adUser) {
        this.adUser = adUser;
    }

    public String getAdPass() {
        return adPass;
    }

    public void setAdPass(String adPass) {
        this.adPass = adPass;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
