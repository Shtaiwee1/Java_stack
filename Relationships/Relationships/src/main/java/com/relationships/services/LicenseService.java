package com.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.models.License;
import com.relationships.repositories.LicenseRepository;


@Service
public class LicenseService {
	
	// adding the book repository as a dependency
	private final LicenseRepository licenseRepository;
	 
	 public LicenseService(LicenseRepository licenseRepository) {
	     this.licenseRepository = licenseRepository;
	 }
	
	// retrieves a book
	 public License findBook(Long id) {
	     Optional<License> optionalLicense = licenseRepository.findById(id);
	     if(optionalLicense.isPresent()) {
	         return optionalLicense.get();
	     } else {
	         return null;
	     }
	 }
	 
	// creates a license
	 public License createLicense(License b) {
	     return licenseRepository.save(b);
	 }

}
