package com.ishostak.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService service;
		
	public BaseballCoach(FortuneService service) {
		super();
		this.service = service;
	}

	@Override
	public String getDailyWorkout() {
		return "30 minutes on bating practice";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}
}
