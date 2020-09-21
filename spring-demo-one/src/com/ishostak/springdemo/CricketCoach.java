package com.ishostak.springdemo;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    private String email;
    private String team;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    //no-arg constructor
    public CricketCoach() {
    }

    //our setter method for dependencies
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return "Good day for cricket: " + fortuneService.getFortune();
    }
}
