package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Campaign;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    public Character findByName(String name);
}

