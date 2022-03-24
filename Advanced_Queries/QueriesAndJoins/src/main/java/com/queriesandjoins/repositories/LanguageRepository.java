package com.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.queriesandjoins.models.Language;



public interface LanguageRepository extends CrudRepository<Language, Long>  {
	List <Language> findAll();

}
