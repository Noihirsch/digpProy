package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.Campaign;

public interface CharacterStatRepository extends JpaRepository<CharacterStat, Long> {

    Character findByCharacter(Character char);
}

