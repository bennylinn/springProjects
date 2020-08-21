package com.oncewing.driversLicense.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size; // String length constraints

import org.springframework.format.annotation.DateTimeFormat;

import com.oncewing.driversLicense.services.PersonService;

// MySQL database entry
@Entity
@Table(name="DriversLicense")
public class DriversLicense {
	// Attributes of the class
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 6, max = 255)
    private String number;
    
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date expiration_date;
    
    @Size(min = 2, max = 255)
    private String expiration_date;
    
	@Size(min = 2, max = 255)    
    private String state;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date created_at;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updated_at;
    
    // One to One mapping person ID
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    public DriversLicense() {
    }
    
    
	// Constructor
    public DriversLicense(String number, String expiration_date, String state, Person person) {
    	this.number = number;
        this.expiration_date = expiration_date;
        this.state = state;
        this.person = person;
    }
    
    public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	// Setters and getters ——> generate from Source tab —> generate getters and setters
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getNumber() {
    	return number;
    }
    
    public void setNumber(String number) {
    	this.number = number;
    }
    
    public String getExpiration_date() {
    	return expiration_date;
    }
    
    public void setExpiration_date(String expiration_date) {
    	this.expiration_date = expiration_date;
    }
    
    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
    	this.state = state;
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
	
	@PrePersist
	protected void onCreate(){
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updated_at = new Date();
	}
}

