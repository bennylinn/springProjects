package com.oncewing.beltExam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oncewing.beltExam.models.Person;
import com.oncewing.beltExam.models.Task;
import com.oncewing.beltExam.services.PersonService;
import com.oncewing.beltExam.services.TaskService;
import com.oncewing.beltExam.validator.PersonValidator;

@Controller
public class MainController {
	private final TaskService taskServices;
	private final PersonService personServices;
    private final PersonValidator personValidator;
    
    public MainController(TaskService taskService, PersonService personService, PersonValidator personValidator) {
        this.taskServices = taskService;
        this.personServices = personService;
        this.personValidator = personValidator;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String login(@ModelAttribute("person") Person person) {
    	return "login.jsp";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, HttpSession session) {
        boolean loggedIn = personServices.authenticateUser(person.getEmail(), person.getPassword());
        if(!loggedIn) {
            return "login.jsp";
        }
        Long id = personServices.findByEmail(person.getEmail()).getId();
        session.setAttribute("personId", id);
        return "redirect:/tasks";
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, HttpSession session) {
        personValidator.validate(person, result);
        if(result.hasErrors()) {
            return "login.jsp";
        }
        Person u = personServices.registerPerson(person);
        session.setAttribute("personId", u.getId());
        return "redirect:/tasks";
    }
    
    @RequestMapping(value="/tasks", method=RequestMethod.GET)
    public String index(Model model, @Valid @ModelAttribute("task") Task param, BindingResult result, HttpSession session) {
        List<Task> tasks = taskServices.allTask();
        model.addAttribute("tasks", tasks);
        return "index.jsp";
    }

    @RequestMapping(value="/tasks/new", method=RequestMethod.GET)
    public String newTask(@ModelAttribute("task") Task task, BindingResult result, Model model) {
    	List<Person> persons = personServices.allPerson();
    	model.addAttribute("persons", persons);
        return "new.jsp"; 
    }
    @RequestMapping(value="/tasks", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("task") Task task, BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println(result);
            return "index.jsp";
        } else {
            Long a_id = task.getA_id();
            Long c_id = task.getC_id();
            
            Person assignee = personServices.findPerson(a_id);
            Person creator = personServices.findPerson(c_id);
            
            System.out.println(assignee.getName());
            System.out.println(creator.getName());
            
            Task t = new Task(task.getName(), task.getPriority(), creator, assignee);
            taskServices.createTask(t);
            return "redirect:/tasks";
        }
    }
     
    @RequestMapping(value="/tasks/{id}")
    public String display(@PathVariable("id") Long id, Model model) {
    	Task task = taskServices.findTask(id);
    	model.addAttribute("task", task);
    	return "display.jsp";
    }
    
    @RequestMapping(value="/tasks/{id}/edit") 
    public String edit(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("task") Task task, BindingResult result) {
    	Task t = taskServices.findTask(id);
    	List<Person> persons = personServices.allPerson();
    	model.addAttribute("persons", persons);
    	model.addAttribute("task", t);
    	return "edit.jsp";
    }
    
    @RequestMapping(value="/tasks/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("id") Long id, org.springframework.ui.Model Model) {
    	if (result.hasErrors()) {
    		String error = "Must be at least 3 chars long";
    		Model.addAttribute("error", error);
    		return "redirect:/tasks/" + id + "/edit";
    	} else {
    		
    		
    		Long a_id = task.getA_id();
            Long c_id = task.getC_id();
            
            Person assignee = personServices.findPerson(a_id);
            Person creator = personServices.findPerson(c_id);
            
            
    		taskServices.updateTask(id, task.getName(), task.getPriority(), creator, assignee);
    		System.out.println(assignee.getName());
    		System.out.println(creator.getName());
    		return "redirect:/tasks";
    	}
    }
    
    @RequestMapping(value="/tasks/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        taskServices.deleteTask(id);
        return "redirect:/tasks";
    }
 
    
        
    
}
