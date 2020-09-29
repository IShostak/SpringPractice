package com.ishostak.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        //read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfiguration.class);

        //get the bean from container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        //get the bean from container using component name
        Coach nCoach = context.getBean("omgCoach", Coach.class);
        Coach theCoach = context.getBean("theCoach", Coach.class);

        //call a method on the bean
        System.out.println(nCoach.getDailyFortune());
        System.out.println(nCoach.getDailyWorkout());

        //close the context
        context.close();
    }
}
