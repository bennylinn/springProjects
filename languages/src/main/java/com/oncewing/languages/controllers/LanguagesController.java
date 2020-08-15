package com.oncewing.languages.controllers;

import java.util.List;

import javax.validation.Valid; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oncewing.languages.models.Language; 
import com.oncewing.languages.services.LanguageServices;

@Controller
public class LanguagesController {
	private final LanguageServices languageServices;
    
    public LanguagesController(LanguageServices LanguageService) {
        this.languageServices = LanguageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> Languages = languageServices.allLanguages();
        model.addAttribute("languages", Languages);
        return "index.jsp";
    }

    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language Language) {
        return "new.jsp"; 
    }
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/languages";
        } else {
            languageServices.createLanguage(language);
            return "redirect:/languages";
        }
    }
     
    @RequestMapping(value="/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Language Language = languageServices.findLanguage(id);
    	model.addAttribute("language", Language);
    	return "/show.jsp";
    }
    
    @RequestMapping(value="/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language Language = languageServices.findLanguage(id);
    	model.addAttribute("language", Language);
    	return "/edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
    	if (result.hasErrors()) {
    		return "/edit.jsp";
    	} else {
    		languageServices.updateLanguage(language.getId(), language.getName(), language.getCreator(), language.getVersion());
    		return "redirect:/languages";
    	}
    }
    
    @RequestMapping(value="/Languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageServices.deleteLanguage(id);
        return "redirect:/Languages";
    }
}
