package com.example.pocketHero.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocketHero.DTOs.NewCampaignDTO;
import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.services.CampaignService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Campaign", description = "Data relevant to the campaigns existing on the app")

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    public CampaignService campaignService;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("/")
    @Operation(summary = "Get all campaigns", description = "Gets all the existing campaigns")
    public ResponseEntity<?> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        if (campaigns.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<NewCampaignDTO> campaignsDTO = new ArrayList<>();
            for (Campaign campaign : campaigns) {
                campaignsDTO.add(modelMapper.map(campaign, NewCampaignDTO.class));
                ResponseEntity.ok(campaignsDTO);
            }
            return new ResponseEntity<>(campaigns, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get campaign by id", description = "Obtains a campaign based on an id")
    @Parameter(name = "id", description = "Get campaign by id", required = true, example = "1")
    public ResponseEntity<?> getCampaignById(@PathVariable Long id) {
        return new ResponseEntity<>(campaignService.getCampaignById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get campaign by name", description = "Obtains a campaign based on the name the dungeon master gave it")
    @Parameter(name = "name", description = "Campaign name", required = true, example = "1")
    public ResponseEntity<?> getCampaignByName(@PathVariable String name) {
        return new ResponseEntity<>(campaignService.getCampaignByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete campaign", description = "Deletes a campaign")
    public ResponseEntity<?> deleteCampaign(@PathVariable Long id) {
        campaignService.deleteCampaign(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/campaign")
    @Operation(summary = "Create campaign", description = "Creates a new campaign")
    public ResponseEntity<?> newCampaign(@Valid @RequestBody NewCampaignDTO newCampaignDTO) {
        Campaign campaign = new Campaign(null,
                newCampaignDTO.getName(),
                newCampaignDTO.getDescription(),
                null,
                newCampaignDTO.getPlayer());
        Campaign campaignSaved = campaignService.newCampaign(campaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(campaignSaved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update campaign based on the id", description = "Updates a campaign based on the id")
    @Parameter(name = "id", description = "Campaign id", required = true, example = "1")
    public ResponseEntity<?> updateCampaign(@Valid @RequestBody NewCampaignDTO newCampaignDTO, @PathVariable Long id) {
        Campaign campaign = campaignService.getCampaignById(id);
        return new ResponseEntity<>(campaignService.updateCampaignById(campaign), HttpStatus.OK);
    }

    @GetMapping("/{player}")
    @Operation(summary = "Get campaign by DM", description = "Obtains a campaign based on the person that DMs its")
    public ResponseEntity<?> getCampaignByDM(@PathVariable Player player) {
        return new ResponseEntity<>(campaignService.getCampaignByPlayer(player), HttpStatus.OK);
    }

}