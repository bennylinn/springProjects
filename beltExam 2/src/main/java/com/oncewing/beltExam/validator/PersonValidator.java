package com.oncewing.beltExam.validator;
import com.oncewing.beltExam.models.Person;

import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class PersonValidator implements Validator {
	// 1
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        
        if (!person.getPasswordConfirmation().equals(person.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
