package com.oncewing.beltExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oncewing.beltExam.models.Person;
import com.oncewing.beltExam.models.Task;
import com.oncewing.beltExam.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> allTask() {
		return taskRepository.findAll();
	}

	public Task createTask(Task b) {
		return taskRepository.save(b);
	}
	
	public Task findTask(long id) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if(optionalTask.isPresent()) {
			return optionalTask.get();
		} else {
			return null;
		}
	}
	
	public Task updateTask(Long id, String name, String priority, Person creator, Person assignee) {
		Task t = findTask(id);
		t.setName(name);
		t.setPriority(priority);
		t.setCreator(creator);
		t.setAssignee(assignee);
		return taskRepository.save(t);
	}
	
	public Task deleteTask(Long id) {
		Task l = findTask(id);
		if(l == null) {
			return null;
		} else {
			taskRepository.deleteById(id);
			return l;
		}
	}
}