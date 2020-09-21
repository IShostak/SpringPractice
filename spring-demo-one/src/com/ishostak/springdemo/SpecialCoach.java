package com.ishostak.springdemo;

public class SpecialCoach implements Coach{
    private FortuneService service;

    public SpecialCoach(FortuneService service) {
        this.service = service;
    }

    @Override
    public String getDailyWorkout() {
        return "Okey dokey its time to workey";
    }

    @Override
    public String getDailyFortune() {
        return "Some fortune for you: " + service.getFortune();
    }
}
