package com.queriesandjoins.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.queriesandjoins.repositories.CityRepository;
import com.queriesandjoins.repositories.CountryRepository;
import com.queriesandjoins.repositories.LanguageRepository;

public class ApiService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	

	public List<Object[]> firstQuery() {
        return countryRepository.findByName();
    }

    public List<Object[]> secondQuery() {
        return countryRepository.findByName2();
    }

    public List<Object[]> thirdQuery() {
        return cityRepository.findByName();
    }

    public List<Object[]> fourthQuery() {
        return countryRepository.findByName3();
    }

    public List<Object[]> fifthQuery() {
        return countryRepository.findByName4();
    }

    public List<Object[]> sixthQuery() {
        return countryRepository.findByName5();
    }

    public List<Object[]> seventhQuery() {
        return countryRepository.findByName6();
    }

    public List<Object[]> eighthQuery() {
        return countryRepository.findByRegion();
    }	
	
}
