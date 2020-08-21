package com.oncewing.advancedQueries.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

// MySQL database entry
@Entity
@Table(name="Languages")
public class Languages {
	// Attributes of the class
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private String country_code;
    
    private String language;

    private double percentage;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "languages_countries", 
//        joinColumns = @JoinColumn(name = "languages_id"), 
//        inverseJoinColumns = @JoinColumn(name = "countries_id")
//    )
//    private List<Countries> countries;

    
    // empty constructor
    public Languages() {
    }

    // Constructor
    public Languages(String country_code, String language, double percentage) {
        this.country_code = country_code;
        this.language = language;
        this.percentage = percentage;
    }
    
    // Setters and getters ——> generate from Source tab —> generate getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
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
