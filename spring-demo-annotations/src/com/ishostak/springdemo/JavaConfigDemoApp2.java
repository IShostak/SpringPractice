package com.ishostak.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp2 {

    public static void main(String[] args) {

        //read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfiguration.class);

        //get the bean from container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on the bean
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());

        //close the context
        context.close();
    }
}
