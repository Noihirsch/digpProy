package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.creation.Language;

public interface LanguageService {

    public List<Language> findAllLanguages();

    public Language findLanguageById(Long id);

    public Language createLanguage(Language language);

    public Language findLanguageByName(String name);

    public void deleteLanguage(Language language);
    
}
