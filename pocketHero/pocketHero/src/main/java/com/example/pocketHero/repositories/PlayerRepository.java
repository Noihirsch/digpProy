package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.Player;

public interface PlayerRepository extends JpaRepository <Player, String> {

    Player findById(Long id);
    Player findByUsername(String username);
    Player findByEmail(String email);
}