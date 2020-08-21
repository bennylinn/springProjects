package com.oncewing.driversLicense.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oncewing.driversLicense.models.Person;
import com.oncewing.driversLicense.services.PersonService;

@RestController
public class PersonApi {
	private final PersonService personService;
	
	public PersonApi(PersonService PersonService) {
		this.personService = PersonService;
	}
	
	@RequestMapping("/api/persons")
    public List<Person> index() {
        return personService.allPerson();
    }
    
// create entry
    @RequestMapping(value="/api/persons", method=RequestMethod.POST)
    public Person create(@RequestParam(value="first_name") String first_name, 
    		@RequestParam(value="last_name") String last_name) {
        Person Person = new Person(first_name, last_name);
        return personService.createPerson(Person);
    }
    // find by id
    @RequestMapping("/api/<models>/{id}")
    public Person show(@PathVariable("id") Long id) {
        Person Person = personService.findPerson(id);
        return Person;
    }
    // edit and update entry
    @RequestMapping(value="/api/<models>/{id}", method=RequestMethod.PUT)
    public Person update(@PathVariable("id") Long id, @RequestParam(value="first_name") String first_name, 
    		@RequestParam(value="last_name") String last_name) {
        Person Person = personService.updatePerson(id, first_name, last_name);
        return Person;
    }
    // delete entry
    @RequestMapping(value="/api/<models>/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}