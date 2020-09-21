package com.ishostak.springdemo;

public class BoxCoach implements Coach {
	
	private FortuneService service;

	public BoxCoach(FortuneService service) {
		super();
		this.service = service;
	}

	@Override
	public String getDailyWorkout() {
		return "2 hours sparring";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}
}
