package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocketHero.domains.creation.Archetype;
import com.example.pocketHero.services.ArchetypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Archetype", description = "Returning all the archetypes available on the app")

@RestController
@RequestMapping("/archetype")
public class ArchetypeController {

    @Autowired
    public ArchetypeService archetypeService;

    @GetMapping("/")
    @Operation(summary = "Get all archetypes", description = "Gets all the existing archetypes")
    public ResponseEntity<?> getAllArchetypes() {
        return new ResponseEntity<>(archetypeService.getAllArchetypes(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get archetype by id", description = "Obtains an archetype based on an id")
    @Parameter(name="id", description="Get archetype by id", required=true, example="1")
    public ResponseEntity<?> getArchetypeById(@PathVariable Long id) {
        return new ResponseEntity<>(archetypeService.getArchetypeById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Get archetype by name", description = "Obtains an archetype based on the name")
    @Parameter(name="name", description="Archetype name", required=true, example="1")
    public ResponseEntity<?> getArchetypeByName(@PathVariable String name) {
        return new ResponseEntity<>(archetypeService.getArchetypeByName(name), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Create archetype", description = "Creates a new archetype")
    public ResponseEntity<?> newArchetype(@RequestBody Archetype archetype) {
        return new ResponseEntity<>(archetypeService.newArchetype(archetype), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Edit archetype", description = "Edits an existing archetype")
    public ResponseEntity<?> updateArchetype(@RequestBody Archetype archetype) {
        return new ResponseEntity<>(archetypeService.updateArchetype(archetype), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "Delete archetype", description = "Deletes an archetype")
    public ResponseEntity<?> deleteArchetype(@PathVariable Long id) {
        archetypeService.deleteArchetype(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
