package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;
	 
	 public LanguageService(LanguageRepository languageRepository) {
	     this.languageRepository = languageRepository;
	 }
	 // returns all the expenses
	 public List<Language> allLanguages() {
	     return languageRepository.findAll();
	 }
	 // create a new language
	 public Language createLanguage(Language e) {
	     return languageRepository.save(e);
	 }
	 
	// retrieves an language
		public Language findLanguage(Long id) {
			Optional<Language> optionalLanguage = languageRepository.findById(id);
			if (optionalLanguage.isPresent()) {
				return optionalLanguage.get();
			} else {
				return null;
			}
		}
	 
	//Updates an language
	 public Language updateLanguage(Long id, Language language) {
		Language l = findLanguage(id);
			l.setName(language.getName());
			l.setCreator(language.getCreator());
			l.setVersion(language.getVersion());
			return languageRepository.save(l);
		}
	 
	//deletes an language
	 public void deleteLanguage(Long id) {
			Language language = this.findLanguage(id);
			languageRepository.delete(language);

		}
			
		}



