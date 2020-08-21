package com.oncewing.advancedQueries.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oncewing.advancedQueries.models.Countries;
import com.oncewing.advancedQueries.models.Languages;



@Repository
public interface CountryInterface extends CrudRepository<Countries, Long> {
	// get all dojos
    @Query("SELECT d FROM Countries d")
    List<Countries> findAllCountries();
    
    // get all the names of the dojos
    @Query("SELECT d.name FROM Countries d")
    List<String> findAllCountryNames();
    
    // passing params and filtering (still retrieves a list)
    @Query("SELECT d FROM Countries d WHERE code = ?1")
    List<Countries> getCountryWhereCode(String code);
    
    // passing params and filtering
    @Query("SELECT d FROM Countries d WHERE code = ?1")
    Countries getSingleCountryWhereCode(String code);
    
    @Query("SELECT l from Languages l WHERE country_code = ?1")
    List<Languages> findAllLanguagesFromCountry(String code);
}