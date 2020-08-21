package com.oncewing.advancedQueries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oncewing.advancedQueries.models.Countries;
import com.oncewing.advancedQueries.services.CountriesService;

@RestController
public class CountriesApi {
	private final CountriesService countriesService;
	
	public CountriesApi(CountriesService countriesService) {
		this.countriesService = countriesService;
	}
	
	@RequestMapping("/api/world")
    public List<Countries> index() {
        return countriesService.allCountries();
    }
}

