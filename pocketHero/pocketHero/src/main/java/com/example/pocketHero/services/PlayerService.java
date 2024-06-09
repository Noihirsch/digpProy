package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.creation.Player;

import jakarta.validation.Valid;


public interface PlayerService {

    public List<Player> findAllPlayers();

    public Player findPlayerById(Long id);

    public Player createPlayer(Player player);

    public Player findPlayerByUsername(String username);

    public void deletePlayer(Player player);

    public void deletePlayerByUsername(String username);

    public void updatePlayer(Player player);

    public void deletePlayerById(Long id);


    
    
}
