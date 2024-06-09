package com.example.pocketHero.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Specie;

public interface RaceRepository extends JpaRepository<Specie, Long>{

    public Specie findByName(String name);

    public void deleteByName(String name);

    public void deleteById(Long id);

    
    
}
