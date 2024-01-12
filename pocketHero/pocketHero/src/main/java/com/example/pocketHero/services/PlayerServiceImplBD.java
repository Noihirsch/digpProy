package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pocketHero.DTOs.DTOPlayer;
import com.example.pocketHero.domains.Player;
import com.example.pocketHero.repositories.PlayerRepository;

public class PlayerServiceImplBD implements PlayerService {

    @Autowired 
    PlayerRepository playerRepository;

    public Player create(Player player){
        return playerRepository.save(player);
    }

    public List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }

    public Player findById(Long id){
        return playerRepository.findById(id);

    }

    public Player findByUsername(String username){
        return playerRepository.findByUsername(username);

    }

    public Player edit(Player player) {
        return playerRepository.save(player);
    }

    public DTOPlayer playerToDTO(Player player){
        DTOPlayer dtoPlayer = new DTOPlayer();
        dtoPlayer.setCampaign(player.getCampaign());
        dtoPlayer.setEmail(player.getEmail());
        dtoPlayer.setPassword(player.getPassword());
        return dtoPlayer;
    }

    public Player findByEmail(String email){
        return playerRepository.findByEmail(email);
    }
    
    
    



    
    
}
