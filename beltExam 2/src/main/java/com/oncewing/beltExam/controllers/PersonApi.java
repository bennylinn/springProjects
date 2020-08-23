package com.oncewing.beltExam.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oncewing.beltExam.models.Person;
import com.oncewing.beltExam.services.PersonService;

@RestController
public class PersonApi {
	private final PersonService personService;
	
	public PersonApi(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/api/persons")
    public List<Person> index() {
        return personService.allPerson();
    }
    
// create entry

    // find by id
    @RequestMapping("/api/persons/{id}")
    public Person show(@PathVariable("id") Long id) {
        Person person = personService.findPerson(id);
        return person;
    }
    // edit and update entry
//    @RequestMapping(value="/api/persons/{id}", method=RequestMethod.PUT)
//    public Person update(@PathVariable("id") Long id, @RequestParam(value="name") String name) {
//        Person person = personService.updatePerson(id, String name);
//        return person;
//    }
    // delete entry
    @RequestMapping(value="/api/persons/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}