package com.oncewing.beltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oncewing.beltExam.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findAll();
	
	// advanced queries
}
