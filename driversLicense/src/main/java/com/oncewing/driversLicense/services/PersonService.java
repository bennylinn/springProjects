package com.oncewing.driversLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oncewing.driversLicense.models.DriversLicense;
import com.oncewing.driversLicense.models.Person;
import com.oncewing.driversLicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository PersonRepository;
	
	public PersonService(PersonRepository PersonRepository) {
		this.PersonRepository = PersonRepository;
	}
	
	public List<Person> allPerson() {
		return PersonRepository.findAll();
	}
	
	public Person createPerson(Person b) {
		return PersonRepository.save(b);
	}
	
	public Person findPerson(long id) {
		Optional<Person> optionalPerson = PersonRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	public Person updatePerson(Long id, String first_name, String last_name) {
		if (this.findPerson(id) == null) {
			Person p = new Person(first_name, last_name);
			return PersonRepository.save(p);
		} else {
			Person p = findPerson(id);
			p.setFirst_name(first_name);
			p.setLast_name(last_name);
			return PersonRepository.save(p);
		}
	}
	
	public Person deletePerson(Long id) {
		Person l = findPerson(id);
		if(l == null) {
			return null;
		} else {
			PersonRepository.deleteById(id);
			return l;
		}
	}
}