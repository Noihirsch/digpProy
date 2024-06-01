package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.repositories.PlayerRepository;

import jakarta.validation.Valid;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findPlayersWhoAreDM(){
        return playerRepository.findPlayersWhoAreDM();
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player findPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    @Override
    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }

    @Override
    public void deletePlayerByUsername(String username) {
        playerRepository.deleteByUsername(username);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Player findPlayerById(Long id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }



}
