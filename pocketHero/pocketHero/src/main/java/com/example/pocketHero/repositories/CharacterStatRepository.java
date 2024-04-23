package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.CharacterStat;

public interface CharacterStatRepository extends JpaRepository<CharacterStat, Long> {

}

