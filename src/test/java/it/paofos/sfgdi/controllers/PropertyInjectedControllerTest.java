package it.paofos.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.paofos.sfgdi.services.GreetingServiceImpl;

class PropertyInjectedControllerTest {

	PropertyInjectedController controller;

	@BeforeEach
	void setUp() {
		controller = new PropertyInjectedController();

		controller.greetingService = new GreetingServiceImpl();
	}

	@Test
	void getGreeting() {

		System.out.println(controller.getGreeting());
	}
}
