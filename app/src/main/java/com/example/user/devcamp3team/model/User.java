package com.example.user.devcamp3team.model;

/**
 * Created by jeongyeoeun on 2017. 9. 23..
 */


/*
model.User(name='화원 B', account='memB', password='123mem', group=groups[0])
model.User(name='관리자 A', account='managerA', password='123manager', manager_flag=True, group=groups[0])
 */
public class User{
    private String name;
    private String account;
    private String password;
    private boolean manager_flag; // boolean?
    private int group; // int?

    public User(String userAccount, String userPassword){
        this.account = userAccount;
        this.password = userPassword;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
