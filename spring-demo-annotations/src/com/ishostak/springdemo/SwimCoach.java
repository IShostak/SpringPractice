package com.ishostak.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
    private FortuneService service;

    @Value("${email}")
    private String email;

    @Value("${team}")
    private String team;

    public SwimCoach(FortuneService service) {
        this.service = service;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return service.getDailyFortune();
    }
}
