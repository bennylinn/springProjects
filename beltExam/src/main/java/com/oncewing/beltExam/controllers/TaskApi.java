package com.oncewing.beltExam.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oncewing.beltExam.models.Person;
import com.oncewing.beltExam.models.Task;
import com.oncewing.beltExam.services.TaskService;

@RestController
public class TaskApi {
	private final TaskService taskService;
	
	public TaskApi(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@RequestMapping("/api/tasks")
    public List<Task> index() {
        return taskService.allTask();
    }
    
// create entry
    @RequestMapping(value="/api/tasks", method=RequestMethod.POST)
    public Task create(@RequestParam(value="name") String name, 
    		@RequestParam(value="priority") String priority,
    		@RequestParam(value="creator") Person creator,
    		@RequestParam(value="assignee") Person assignee) { // add creator, assignee
        Task task = new Task(name, priority, creator, assignee);
        return taskService.createTask(task);
    }
    // find by id
    @RequestMapping("/api/tasks/{id}")
    public Task show(@PathVariable("id") Long id) {
        Task task = taskService.findTask(id);
        return task;
    }
    // edit and update entry
    @RequestMapping(value="/api/tasks/{id}", method=RequestMethod.PUT)
    public Task update(@PathVariable("id") Long id, 
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="priority") String priority,
    		@RequestParam(value="creator") Person creator,
    		@RequestParam(value="assignee") Person assignee) {
        Task task = taskService.updateTask(id, name, priority, creator, assignee);
        return task;
    }
    // delete entry
    @RequestMapping(value="/api/tasks/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}