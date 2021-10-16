package it.paofos.sfgdi.controllers;

import it.paofos.sfgdi.services.GreetingService;

public class PropertyInjectedController {

	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
