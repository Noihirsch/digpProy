package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Archetype;

public interface ArchetypeRepository extends JpaRepository<Archetype, Long>{

    Archetype findByName(String name);



    
}
