package com.example.pocketHero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.Player;


public interface PlayerService {

    Player create(Player player);

    List <Player> findAllPlayers();

    Player findById(Long id);

    Player findByUsername (String username);

    Player edit(Player player);

    List <Player> findByCampaign(Long campaignId);
 
}
