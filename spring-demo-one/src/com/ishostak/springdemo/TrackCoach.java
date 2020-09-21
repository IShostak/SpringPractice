package com.ishostak.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService service;

	public TrackCoach(FortuneService service) {
		this.service = service;
	}

	//init method
	public void myInitMethod() {
		System.out.println("TrackCoach: inside init method");
	}

	//destroy method
	public void myDestroyMethod() {
		System.out.println("TrackCoach: inside destroy method");
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	@Override
	public String getDailyFortune() {
		return "Just do it: " + service.getFortune();
	}

}
