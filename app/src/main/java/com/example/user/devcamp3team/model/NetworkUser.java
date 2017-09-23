package com.example.user.devcamp3team.model;

/**
 * Created by jeongyeoeun on 2017. 9. 24..
 */

public class NetworkUser {
    private String account;
    private String password;

    public NetworkUser(String userAccount, String userPassword){
        this.account = userAccount;
        this.password = userPassword;
    };

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
