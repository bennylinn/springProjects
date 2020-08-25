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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size; // String length constraints

import org.springframework.format.annotation.DateTimeFormat;

// MySQL database entry
@Entity
@Table(name="Person")
public class Person {
	// Attributes of the class
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 3, max = 255)
    private String name;
    
//     email and pass for login
    @Size(min = 3, max = 20)
    // @Patter validation (regex pattern)
    private String email;
    public String getEmail() {
		return email;
	}
    
    @Transient
    private String passwordConfirmation;

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Size(min = 3, max = 255)
    private String password;
    
    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<Task> created_tasks;
//    
    @OneToMany(mappedBy="assignee", fetch=FetchType.LAZY)
    private List<Task> assigned_tasks;
//    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    public List<Task> getTasks() {
		return created_tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.created_tasks = tasks;
	}

	public List<Task> getTodo() {
		return assigned_tasks;
	}

	public void setTodo(List<Task> assigned_tasks) {
		this.assigned_tasks = assigned_tasks;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // empty constructor
    public Person() {
    }

    // Constructor
    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    	protected void onUpdate(){
        		this.updatedAt = new Date();
    	}
}
