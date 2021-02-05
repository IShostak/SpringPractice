package com.ishostak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " :doing some db work with account");
    }

    public boolean doWork() {

        System.out.printf(getClass() +  ": doWork()");

        return false;
    }
}
