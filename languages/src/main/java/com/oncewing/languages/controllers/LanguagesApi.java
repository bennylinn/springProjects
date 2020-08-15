package com.oncewing.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oncewing.languages.models.Language;
import com.oncewing.languages.services.LanguageServices;

@RestController
public class LanguagesApi {
	private final LanguageServices LanguageServices;
	
	public LanguagesApi(LanguageServices languageService) {
		this.LanguageServices = languageService;
	}
	
	@RequestMapping("/api/languages")
    public List<Language> index() {
        return LanguageServices.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
        Language Language = new Language(name, creator, version);
        return LanguageServices.createLanguage(Language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language Language = LanguageServices.findLanguage(id);
        return Language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
        Language Language = LanguageServices.updateLanguage(id, name, creator, version);
        return Language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        LanguageServices.deleteLanguage(id);
    }
}
