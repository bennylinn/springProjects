package com.oncewing.beltExam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.oncewing.beltExam.models.Person;
import com.oncewing.beltExam.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPerson() {
		return personRepository.findAll();
	}

	public Person createPerson(Person b) {
		return personRepository.save(b);
	}
	
	public Person findPerson(long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	// Don't need to update person
//	public Person updatePerson(Long id, <Model Params>) {
//		if (this.findPerson(id) == null) {
//			Person l = new Person(<Model Params>);
//			return PersonRepository.save(l);
//		} else {
//			Person l = findPerson(id);
//			l.set<Param>
//			// … set more params
//			return PersonRepository.save(l);
//		}
//	}
	
	public Person deletePerson(Long id) {
		Person l = findPerson(id);
		if(l == null) {
			return null;
		} else {
			personRepository.deleteById(id);
			return l;
		}
	}
	
	// register person and hash their password
    public Person registerPerson(Person person) {
        String hashed = BCrypt.hashpw(person.getPassword(), BCrypt.gensalt());
        person.setPassword(hashed);
        return personRepository.save(person);
    }
    
    // find person by email
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        Person user = personRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
        	
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
            	System.out.println("pass don't match");
                return false;
            }
        }
    }
}