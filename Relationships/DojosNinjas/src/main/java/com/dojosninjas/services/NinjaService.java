package com.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.dojosninjas.models.Ninja;
import com.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	 
	 public NinjaService(NinjaRepository ninjaRepository) {
	     this.ninjaRepository =ninjaRepository;
	 }
	 // returns all thedojos
	 public List<Ninja> allNinjas() {
	     return ninjaRepository.findAll();
	 }
	 // create a new ninjas
	 public Ninja createNinja(Ninja e) {
	     return ninjaRepository.save(e);
	 }
	 
	// retrieves an language
		public Ninja findNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
			if (optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
		}

}
