package com.ishostak.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theCoach")
public class CricketCoach implements Coach{

    //autowiring using fields
    @Autowired
    @Qualifier("happyFortuneService")//in case of different implementations
    FortuneService service;

    @Override
    public String getDailyWorkout() {
        return "Some bating practice";
    }

    @Override
    public String getDailyFortune() {
        return "Cricket good today, because " + service.getDailyFortune();
    }
}
