package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    public CampaignService campaignService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCampaigns() {
        return new ResponseEntity<>(campaignService.getAllCampaigns(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCampaignById(@PathVariable Long id) {
        return new ResponseEntity<>(campaignService.getCampaignById(id), HttpStatus.OK);
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<?> getCampaignByName(@PathVariable String name) {
        return new ResponseEntity<>(campaignService.getCampaignByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> newCampaign(@Valid @RequestBody Campaign campaign) {
        return new ResponseEntity<>(campaignService.newCampaign(campaign), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")   
    public ResponseEntity<?> updateCampaign(@Valid @RequestBody Campaign campaign) {
        return new ResponseEntity<>(campaignService.updateCampaign(campaign), HttpStatus.OK);
    }

    @GetMapping("/{player}")
    public ResponseEntity<?> getCampaignByDM(@PathVariable Player player) {
        return new ResponseEntity<>(campaignService.getCampaignByPlayer(player), HttpStatus.OK);
    }






}