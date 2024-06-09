package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Backstory;

public interface BackstoryRepository extends JpaRepository<Backstory, Long>{

    Backstory findByName(String name);
    
    
}
