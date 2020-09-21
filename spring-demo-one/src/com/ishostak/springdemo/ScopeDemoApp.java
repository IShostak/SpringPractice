package com.ishostak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemoApp {
    public static void main(String[] args) {

        //load context from xml
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("scope-applicationContext.xml");

        //Load bean from context
        Coach coach = context.getBean("myCoach", Coach.class);

        Coach coach2 = context.getBean("myCoach", Coach.class);

        //check if they are te same and print res
        System.out.println(coach == coach2 ? "same" : "not same");

        System.out.println("Memory location coach: " + coach);
        System.out.println("Memory location coach2: " + coach2);

        //close context
        context.close();

    }
}
