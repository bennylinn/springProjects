package com.oncewing.beltExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size; // String length constraints

import org.springframework.format.annotation.DateTimeFormat;

// MySQL database entry
@Entity
@Table(name="Task")
public class Task {
	// Attributes of the class
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 3, max = 255, message = "Must be at least 3") // can put message in validation
    private String name;
    @Size(min = 3, max = 255)
    private String priority;
    
    // Many to One: creator
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private Person creator;
    
    // (many to one) One to one: assignee
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="assignee_id")
    private Person assignee;
    
    private Long a_id;
    
    private Long c_id;

    
    // empty constructor
    public Task() {
    }
    
    // Constructor
    public Task(String name, String priority, Person creator, Person assignee) {
    	this.name = name;
    	this.priority = priority;
    	this.creator = creator;
    	this.assignee = assignee;
    }
    
//    public Task(String name, String priority, Long creator_id, Long assignee_id) {
//    	this.name = name;
//    	this.priority = priority;
//    	this.c_id = creator_id;
//    	this.a_id = assignee_id;
//    }
    
    public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	public Person getAssignee() {
		return assignee;
	}

	public void setAssignee(Person assignee) {
		this.assignee = assignee;
	}
	
    // Setters and getters ——> generate from Source tab —> generate getters and setters
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	


	public Long getA_id() {
		return a_id;
	}

	public void setA_id(Long a_id) {
		this.a_id = a_id;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}




	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    	protected void onUpdate(){
        		this.updatedAt = new Date();
    	}
}