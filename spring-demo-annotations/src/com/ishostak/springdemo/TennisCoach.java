package com.ishostak.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;

    //Autowiring using constructor
    @Autowired

    public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    //define init method
    @PostConstruct
    public void doStartup() {
        System.out.println("Inside startup");
    }

    //define m destroy method
    @PreDestroy
    public void doDestroy() {
        System.out.println("Inside doDestroy");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
