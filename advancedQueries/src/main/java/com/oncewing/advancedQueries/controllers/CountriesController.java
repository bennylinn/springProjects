package com.oncewing.advancedQueries.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oncewing.advancedQueries.models.Countries;
import com.oncewing.advancedQueries.models.Languages;
import com.oncewing.advancedQueries.services.CountriesService;

@Controller
public class CountriesController {
	private final CountriesService countriesServices;
    
    public CountriesController(CountriesService countriesService) {
        this.countriesServices = countriesService;
    }
    
    @RequestMapping("")
    public String login() {
    	return "index.jsp";
    }
    
    @RequestMapping("/countries")
    public String home(Model model, @Valid @ModelAttribute("countries") Countries param, BindingResult result) {
        List<Languages> l = countriesServices.allLanguages("CAN");
        for (Languages lang : l) {
        	System.out.println(lang.getLanguage()); 
        }
        return "countries.jsp";
    }
}
