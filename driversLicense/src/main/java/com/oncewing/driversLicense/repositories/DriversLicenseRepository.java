package com.oncewing.driversLicense.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oncewing.driversLicense.models.DriversLicense;

@Repository
public interface DriversLicenseRepository extends CrudRepository<DriversLicense, Long> {
	List<DriversLicense> findAll();
}