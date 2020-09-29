package com.ishostak.springdemo;

public class SadFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "Not so lucky day";
    }
}
