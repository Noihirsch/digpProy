package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.services.CampaignService;
import com.example.pocketHero.services.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    public PlayerService playerService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCampaigns() {
        return new ResponseEntity<>(playerService.findAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/DM")
    public ResponseEntity<?> getPlayersWhoAreDM() {
        return new ResponseEntity<>(playerService.findPlayersWhoAreDM(), HttpStatus.OK);
    }
    
    @GetMapping("/{username}")
    public ResponseEntity<?> getPlayerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(playerService.findPlayerByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createPlayer(@Valid @RequestBody Player player) {
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deletePlayerByUsername(@PathVariable String username) {
        playerService.deletePlayerByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updatePlayer(@Valid @RequestBody Player player) {
        playerService.updatePlayer(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    




}