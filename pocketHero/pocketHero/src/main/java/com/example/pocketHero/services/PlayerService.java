package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.DTOs.DTOPlayer;
import com.example.pocketHero.domains.Player;

public interface PlayerService {

    Player create(Player player);

    List <Player> findAllPlayers();

    Player findById(Long id);

    Player findByUsername (String username);

    void deleteByUsername(String username);

    Player edit(Player player);

    DTOPlayer playerToDTO(Player player);


    Player findByEmail(String email);    

    

    
    

    
}
