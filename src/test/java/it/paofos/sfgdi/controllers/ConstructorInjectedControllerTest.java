package it.paofos.sfgdi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.paofos.sfgdi.services.ConstructorGreetingService;

class ConstructorInjectedControllerTest {

	ConstructorInjectedController controller;

	@BeforeEach
	void setUp() throws Exception {
		
		controller = new ConstructorInjectedController(new ConstructorGreetingService());
	}

	@Test
	void getGreeting() {

		System.out.println(controller.getGreeting());
	}
}
