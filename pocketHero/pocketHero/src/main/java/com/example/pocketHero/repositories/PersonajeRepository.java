package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    public Personaje findByName(String name);
}

