package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocketHero.domains.creation.Backstory;
import com.example.pocketHero.services.BackstoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Backstory", description = "Returning all the backstories available on the app")

@RestController
@RequestMapping("/backstory")
public class BackstoryController {

    @Autowired
    public BackstoryService backstoryService;

    @GetMapping("/")
    @Operation(summary = "Get all backstories", description = "Gets all the existing backstories")
    public ResponseEntity<?> getAllBackstories() {
        return new ResponseEntity<>(backstoryService.getAllBackstories(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get backstory by id", description = "Obtains a backstory based on an id")
    public ResponseEntity<?> getBackstoryById(@PathVariable Long id) {
        return new ResponseEntity<>(backstoryService.getBackstoryById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Get backstory by name", description = "Obtains a backstory based on the name")
    public ResponseEntity<?> getBackstoryByName(@PathVariable String name) {
        return new ResponseEntity<>(backstoryService.getBackstoryByName(name), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Create backstory", description = "Creates a new backstory")
    public ResponseEntity<?> newBackstory(@RequestBody Backstory backstory) {
        return new ResponseEntity<>(backstoryService.newBackstory(backstory), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Edit backstory", description = "Edits an existing backstory")
    public ResponseEntity<?> updateBackstory(@RequestBody Backstory backstory) {
        return new ResponseEntity<>(backstoryService.updateBackstory(backstory), HttpStatus.OK);
    }



    
    
}
