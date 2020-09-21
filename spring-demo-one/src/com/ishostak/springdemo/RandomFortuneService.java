package com.ishostak.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{
    String[] fortunes = {"not so lucky", "lucky", "Super lucky"};

    Random random = new Random();

    @Override
    public String getFortune() {
        return fortunes[random.nextInt(fortunes.length)];
    }
}
