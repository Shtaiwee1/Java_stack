package com.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relationships.models.License;




public interface LicenseRepository extends CrudRepository<License, Long> {

	// this method retrieves all the people from the database
    List<License> findAll();

}
