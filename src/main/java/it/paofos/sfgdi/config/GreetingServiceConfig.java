package it.paofos.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.paofos.sfgdi.services.ConstructorGreetingService;
import it.paofos.sfgdi.services.PropertyInjectedGreetingService;
import it.paofos.sfgdi.services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}
	
	@Bean
	PropertyInjectedGreetingService propertyInjectedGreetingService() {
		return new PropertyInjectedGreetingService();
	}
	
	@Bean
	SetterInjectedGreetingService setterInjectedGreetingService() {
		return new SetterInjectedGreetingService();
	}
}
