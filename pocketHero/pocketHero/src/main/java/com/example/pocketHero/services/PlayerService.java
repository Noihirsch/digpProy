package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.creation.Player;


public interface PlayerService {

    public List<Player> findAllPlayers();

    public List<Player> findPlayersWhoAreDM();

    public Player createPlayer(Player player);

    public Player findPlayerByUsername(String username);

    public void deletePlayer(Player player);

    public void deletePlayerById(Long id);

    public void deletePlayerByUsername(String username);

    public void updatePlayer(Player player);

    public void updateAllPlayers(List<Player> players);
    
    public void deleteAllPlayers(List<Player> players);

    
}
