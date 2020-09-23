package com.ishostak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        //get the bean from container using component name
        Coach nCoach = context.getBean("omgCoach", Coach.class);
        Coach theCoach = context.getBean("theCoach", Coach.class);

        //call a method on the bean
        System.out.println("Tennis:");
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println("\nOmgCoach");
        System.out.println(nCoach.getDailyWorkout());
        System.out.println(nCoach.getDailyFortune());
        System.out.println("\nCricket:");
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());


        //close the context
        context.close();
    }
}
