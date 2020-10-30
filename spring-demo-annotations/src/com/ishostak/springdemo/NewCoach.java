package com.ishostak.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("omgCoach")//specify name
@Scope("singleton") //specify bean scope
public class NewCoach implements Coach{

    private FortuneService service;

    public NewCoach() {
    }

    //Autowiring using method(any method name actually not only setter)
    @Autowired
    @Qualifier("happyFortuneService")
    public void setService(FortuneService service) {
        this.service = service;
    }

    @Override
    public String getDailyWorkout() {
        return "Double jump 20 times";
    }

    @Override
    public String getDailyFortune() {
        return service.getDailyFortune() + " so jump";
    }
}
