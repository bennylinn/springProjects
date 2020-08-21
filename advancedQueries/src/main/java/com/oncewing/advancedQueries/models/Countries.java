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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

// MySQL database entry
@Entity
@Table(name="Countries")
public class Countries {
	// Attributes of the class
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    
    private String name;

    private String region;
    
    private double surface_area;
    
    private Integer indep_year;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "languages_countries", 
//        joinColumns = @JoinColumn(name = "countries_id"), 
//        inverseJoinColumns = @JoinColumn(name = "languages_id")
//    )
//    private List<Languages> languages;
    
//    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
//    private List<Cities> cities;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;

	public void setIndep_year(Integer indep_year) {
		this.indep_year = indep_year;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // empty constructor
    public Countries() {
    }

    // Constructor
    public Countries(String code, String name, String region, double surface_area, int indep_year) {
        this.code = code;
    	this.name = name;
    	this.region = region;
    	this.surface_area = surface_area;
    	this.indep_year = indep_year;
    }
    
    
    // Setters and getters ——> generate from Source tab —> generate getters and setters
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(double surface_area) {
		this.surface_area = surface_area;
	}

	public int getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(int indep_year) {
		this.indep_year = indep_year;
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

	@PreUpdate
    	protected void onUpdate(){
        		this.updatedAt = new Date();
    	}
}