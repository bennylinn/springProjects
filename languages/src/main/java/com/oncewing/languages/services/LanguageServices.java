package com.oncewing.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oncewing.languages.models.Language;
import com.oncewing.languages.repositories.LanguageRepository;

@Service
public class LanguageServices {
	private final LanguageRepository LanguageRepository;
	
	public LanguageServices(LanguageRepository LanguageRepository) {
		this.LanguageRepository = LanguageRepository;
	}
	
	public List<Language> allLanguages() {
		return LanguageRepository.findAll();
	}
	
	public Language createLanguage(Language b) {
		return LanguageRepository.save(b);
	}
	
	public Language findLanguage(long id) {
		Optional<Language> optionalLanguage = LanguageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		if (this.findLanguage(id) == null) {
			Language l = new Language(name, creator, version);
			return LanguageRepository.save(l);
		} else {
			Language l = findLanguage(id);
			l.setName(name);
			l.setCreator(creator);
			l.setVersion(version);
			return LanguageRepository.save(l);
		}
	}
	
	public Language deleteLanguage(Long id) {
		Language l = findLanguage(id);
		if(l == null) {
			return null;
		} else {
			LanguageRepository.deleteById(id);
			return l;
		}
	}
}