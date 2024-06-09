package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Language;

public interface LanguageRepository extends JpaRepository<Language, Long>{

    Language findByName(String name);


}
