package com.ishostak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleDemoApp {
    public static void main(String[] args) {

        //load context from xml
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("lifeCycle-applicationContext.xml");

        //Load bean from context
        Coach coach = context.getBean("myCoach", Coach.class);

        Coach coach2 = context.getBean("myCoach", Coach.class);


        //close context
        context.close();

    }
}
