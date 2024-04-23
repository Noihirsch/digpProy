package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.user.Player;
public interface PlayerRepository extends JpaRepository <Player, Long> {

    public Player findByUsername(String username);

}