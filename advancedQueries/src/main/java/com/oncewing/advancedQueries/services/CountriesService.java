package com.oncewing.advancedQueries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oncewing.advancedQueries.models.Countries;
import com.oncewing.advancedQueries.models.Languages;
import com.oncewing.advancedQueries.repos.CountryInterface;

@Service
public class CountriesService {
	private final CountryInterface CountriesRepository;
	
	public CountriesService(CountryInterface CountriesRepository) {
		this.CountriesRepository = CountriesRepository;
	}
	
	public List<Countries> allCountries() {
		return CountriesRepository.findAllCountries();
	}
	
	public List<Languages> allLanguages(String code) {
		return CountriesRepository.findAllLanguagesFromCountry(code);
	}

	
}
