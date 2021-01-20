package com.ishostak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

    public void addAccount() {
        System.out.println(getClass() + " :doing some db work with member account");
    }
}
