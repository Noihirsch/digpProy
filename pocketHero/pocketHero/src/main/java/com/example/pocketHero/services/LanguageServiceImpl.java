package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Language;
import com.example.pocketHero.repositories.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService{
    
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language findLanguageById(Long id) {
        return languageRepository.findById(id).get();
    }

    @Override
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language findLanguageByName(String name) {
        return languageRepository.findByName(name);
    }

    @Override
    public void deleteLanguage(Language language) {
        languageRepository.delete(language);
    }

}
