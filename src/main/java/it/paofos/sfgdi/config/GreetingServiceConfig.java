package it.paofos.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import it.paofos.sfgdi.repositories.EnglishGreetingRepository;
import it.paofos.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import it.paofos.sfgdi.services.ConstructorGreetingService;
import it.paofos.sfgdi.services.I18nEnglishGreetingService;
import it.paofos.sfgdi.services.I18nSpanishGreetingService;
import it.paofos.sfgdi.services.PrimaryGreetingService;
import it.paofos.sfgdi.services.PropertyInjectedGreetingService;
import it.paofos.sfgdi.services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

	@Profile({ "ES", "default" })
	@Bean("i18nService")
	I18nSpanishGreetingService i18nSpanishGreetingService() {
		return new I18nSpanishGreetingService();
	}

	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}

	@Profile("EN")
	@Bean
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}

	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

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
