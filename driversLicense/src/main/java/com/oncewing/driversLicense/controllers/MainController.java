package com.oncewing.driversLicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oncewing.driversLicense.models.DriversLicense;
import com.oncewing.driversLicense.services.DriversLicenseService;

@Controller
public class MainController {
	private final DriversLicenseService driversLicenseServices;
    
    public MainController(DriversLicenseService driversLicenseService) {
        this.driversLicenseServices = driversLicenseService;
    }
    
    @RequestMapping(value="/drivers-licenses", method=RequestMethod.GET)
    public String index(Model model, @Valid @ModelAttribute("driversLicense") DriversLicense param, BindingResult result) {
        List<DriversLicense> dls = driversLicenseServices.allDriversLicense();
        model.addAttribute("dls", dls);
        return "index.jsp";
    }

    @RequestMapping("/drivers-licenses/new")
    public String newDriversLicense(@ModelAttribute("DriversLicense") DriversLicense dl) {
        return "new.jsp"; 
    }
    
    @RequestMapping(value="/drivers-licenses", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") DriversLicense driversLicense, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            driversLicenseServices.createDriversLicense(driversLicense);
            return "redirect:/drivers-licenses";
        }
    }
     
    @RequestMapping(value="/drivers-licenses/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	DriversLicense driversLicense = driversLicenseServices.findDriversLicense(id);
    	model.addAttribute("driversLicense", driversLicense);
    	return "show.jsp";
    }
    
    @RequestMapping(value="/drivers-licenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("driversLicense") DriversLicense driversLicense, BindingResult result) {
    	DriversLicense dl = driversLicenseServices.findDriversLicense(id);
    	model.addAttribute("driversLicense", dl);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/drivers-licenses/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("driversLicense") DriversLicense driversLicense, BindingResult result) {
    	if (result.hasErrors()) {
    		return "index.jsp";
    	} else {
    		driversLicenseServices.updateDriversLicense(driversLicense.getId(), driversLicense.getNumber(), driversLicense.getExpiration_date(), driversLicense.getState(), driversLicense.getPerson());
    		return "redirect:/drivers-licenses";
    	}
    }
    
    @RequestMapping(value="/drivers-licenses/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        driversLicenseServices.deleteDriversLicense(id);
        return "redirect:/drivers-licenses";
    }
}
