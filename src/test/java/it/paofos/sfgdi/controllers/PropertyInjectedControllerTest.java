package it.paofos.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.paofos.sfgdi.services.ConstructorGreetingService;

class PropertyInjectedControllerTest {

	PropertyInjectedController controller;

	@BeforeEach
	void setUp() {
		controller = new PropertyInjectedController();

		controller.greetingService = new ConstructorGreetingService();
	}

	@Test
	void getGreeting() {

		System.out.println(controller.getGreeting());
	}
}
