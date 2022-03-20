package com.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojosninjas.models.Dojo;
import com.dojosninjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	 
	 public DojoService(DojoRepository dojoRepository) {
	     this.dojoRepository =dojoRepository;
	 }
	 // returns all thedojos
	 public List<Dojo> allDojos() {
	     return dojoRepository.findAll();
	 }
	 // create a new dojos
	 public Dojo createDojo(Dojo e) {
	     return dojoRepository.save(e);
	 }
	 
	// retrieves an language
		public Dojo findDojo(Long id) {
			Optional<Dojo> optionalDojo = dojoRepository.findById(id);
			if (optionalDojo.isPresent()) {
				return optionalDojo.get();
			} else {
				return null;
			}
		}
	 

}
