package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocketHero.services.CampaignRegService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CampaignReg", description = "Data relevant to the campaign creation logs")

@RestController
@RequestMapping("/campaignReg")
public class CampaignRegController {

    @Autowired
    public CampaignRegService campaignRegService;

    @GetMapping("/")
    @Operation(summary = "Get all campaigns", description = "Gets all existing registers of campaigns being created")
    public ResponseEntity<?> getAllCampaignRegs() {
        return new ResponseEntity<>(campaignRegService.getAllCampaignRegs(), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    @Operation(summary = "Get campaignReg by id", description = "Obtains a campaignreg based on an id")
    @Parameter(name = "id", description = "Get campaignReg by id", required = true, example = "1")
    public ResponseEntity<?> getCampaignRegById(@PathVariable Long id) {
        return new ResponseEntity<>(campaignRegService.getCampaignRegById(id), HttpStatus.OK);
    }

    @GetMapping("betweenYear/{year}")
    @Operation(summary = "Get campaignReg by year", description = "Obtains a campaignreg based on the year it was created")
    @Parameter(name = "year", description = "Get campaignReg by year", required = true, example = "2021")
    public ResponseEntity<?> getCampaignRegByYear(@PathVariable int year) {
        return new ResponseEntity<>(campaignRegService.getCampaignsByYear(year), HttpStatus.OK);
    }


}
