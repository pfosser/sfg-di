package it.paofos.sfgdi.services;

import it.paofos.sfgdi.repositories.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService {

	private final EnglishGreetingRepository englishGreetingRepository;

	public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
		super();
		this.englishGreetingRepository = englishGreetingRepository;
	}

	@Override
	public String sayGreeting() {
		return englishGreetingRepository.getGreeting();
	}

}
