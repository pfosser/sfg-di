package it.paofos.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import com.paofos.pets.PetService;
import com.paofos.pets.PetServiceFactory;

import it.paofos.sfgdi.datasource.FakeDataSource;
import it.paofos.sfgdi.repositories.EnglishGreetingRepository;
import it.paofos.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import it.paofos.sfgdi.services.ConstructorGreetingService;
import it.paofos.sfgdi.services.I18nEnglishGreetingService;
import it.paofos.sfgdi.services.I18nSpanishGreetingService;
import it.paofos.sfgdi.services.PrimaryGreetingService;
import it.paofos.sfgdi.services.PropertyInjectedGreetingService;
import it.paofos.sfgdi.services.SetterInjectedGreetingService;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

	@Bean
	FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration) {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(sfgConfiguration.getUsername());
		fakeDataSource.setPassword(sfgConfiguration.getPassword());
		fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());
		return fakeDataSource;
	}

	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}

	@Profile({ "dog", "default" })
	@Bean
	PetService dogPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("dog");
	}

	@Profile("cat")
	@Bean
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("cat");
	}

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
