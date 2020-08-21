package com.oncewing.driversLicense.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oncewing.driversLicense.models.DriversLicense;
import com.oncewing.driversLicense.models.Person;
import com.oncewing.driversLicense.repositories.DriversLicenseRepository;

@Service
public class DriversLicenseService {
	private final DriversLicenseRepository driversLicenseRepository;
	
	public DriversLicenseService(DriversLicenseRepository DriversLicenseRepository) {
		this.driversLicenseRepository = DriversLicenseRepository;
	}
	
	public List<DriversLicense> allDriversLicense() {
		return driversLicenseRepository.findAll();
	}
	
	public DriversLicense createDriversLicense(DriversLicense dl) {
		return driversLicenseRepository.save(dl);
	}
	
	public DriversLicense findDriversLicense(long id) {
		Optional<DriversLicense> optionalDriversLicense = driversLicenseRepository.findById(id);
		if(optionalDriversLicense.isPresent()) {
			return optionalDriversLicense.get();
		} else {
			return null;
		}
	}
	
	public DriversLicense updateDriversLicense(Long id, String number, String expiration_date, String state, Person person) {
		if (this.findDriversLicense(id) == null) {
			DriversLicense dl = new DriversLicense(number, expiration_date, state, person);
			return driversLicenseRepository.save(dl);
		} else {
			DriversLicense dl = findDriversLicense(id);
			dl.setNumber(number);
			dl.setExpiration_date(expiration_date);
			dl.setState(state);
			return driversLicenseRepository.save(dl);
		}
	}
	
	public DriversLicense deleteDriversLicense(Long id) {
		DriversLicense dl = findDriversLicense(id);
		if(dl == null) {
			return null;
		} else {
			driversLicenseRepository.deleteById(id);
			return dl;
		}
	}
}

