package com.ishostak.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		
		//load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach theCoach = context.getBean(
				"theCoach", CricketCoach.class);


		Coach rCoach = context.getBean(
				"weirdCoach", Coach.class);

		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam() +  "\n\n");

		System.out.println(rCoach.getDailyWorkout());
		System.out.println(rCoach.getDailyFortune());
		System.out.println(rCoach.getDailyFortune());
		System.out.println(rCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
