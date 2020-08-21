package com.oncewing.driversLicense.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
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
    
    @Size(min = 2, max = 20)
    private String first_name;
    
    @Size(min = 2, max = 20)
    private String last_name;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;
    
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private DriversLicense license;
    
    public Person() {
    }
    
    // Constructor
    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
    
    // Setters and getters ——> generate from Source tab —> generate getters and setters
    
	
	public DriversLicense getLicense() {
		return license;
	}

	public void setLicense(DriversLicense license) {
		this.license = license;
	}

	@PrePersist
	protected void onCreate(){
		this.created_at = new Date();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@PreUpdate
	protected void onUpdate(){
    		this.updated_at = new Date();
	}
}
