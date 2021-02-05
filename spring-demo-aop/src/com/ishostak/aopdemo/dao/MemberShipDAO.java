package com.ishostak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

    public void addAccount() {
        System.out.println(getClass() + " :doing some db work with member account");
    }

    public void goToSleep() {
        System.out.println(getClass() +  " i'm going to sleep now");
    }
}
