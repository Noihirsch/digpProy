package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pocketHero.domains.user.Campaign;

public interface CharacterRepository extends JpaRepository<Campaign, Long> {

    Character findByName(String name);
}

