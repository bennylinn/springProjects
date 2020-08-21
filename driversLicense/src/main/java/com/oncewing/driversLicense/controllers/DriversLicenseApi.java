package com.oncewing.driversLicense.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oncewing.driversLicense.models.DriversLicense;
import com.oncewing.driversLicense.models.Person;
import com.oncewing.driversLicense.services.DriversLicenseService;
import com.oncewing.driversLicense.services.PersonService;

@RestController
public class DriversLicenseApi {
	private final DriversLicenseService driversLicenseService;
	private final PersonService personService;
	
	public DriversLicenseApi(DriversLicenseService driversLicenseService, PersonService personService) {
		this.driversLicenseService = driversLicenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/api/drivers-licenses")
    public List<DriversLicense> index() {
        return driversLicenseService.allDriversLicense();
    }
    
// create entry
    @RequestMapping(value="/api/drivers-licenses", method=RequestMethod.POST)
    public DriversLicense create(@RequestParam(value="number") String number, 
    		@RequestParam(value="expiration_date") String expiration_date, 
    		@RequestParam(value="state") String state, 
    		@RequestParam(value="person_id") Integer person_id) {
    	Person person = personService.findPerson(person_id);
        DriversLicense DriversLicense = new DriversLicense(number, expiration_date, state, person);
        return driversLicenseService.createDriversLicense(DriversLicense);
    }
    // find by id
    @RequestMapping("/api/drivers-licenses/{id}")
    public DriversLicense show(@PathVariable("id") Long id) {
        DriversLicense driversLicenses = driversLicenseService.findDriversLicense(id);
        return driversLicenses;
    }
    // edit and update entry
    @RequestMapping(value="/api/drivers-licenses/{id}", method=RequestMethod.PUT)
    public DriversLicense update(@PathVariable("id") Long id, 
    		@RequestParam(value="number") String number, 
    		@RequestParam(value="expiration_date") String expiration_date, 
    		@RequestParam(value="state") String state, 
    		@RequestParam(value="person") Person person) {
        DriversLicense driversLicense = driversLicenseService.updateDriversLicense(id, number, expiration_date, state, person);
        return driversLicense;
    }
    // delete entry
    @RequestMapping(value="/api/drivers-licenses/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        driversLicenseService.deleteDriversLicense(id);
    }
}
