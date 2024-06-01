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
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.services.PersonajeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Characters (personajes)", description = "Data relevant to the characters existing on the app")

@RestController
@RequestMapping("/personaje")
public class CharacterController {

    @Autowired
    public PersonajeService personajeService;

    @GetMapping("/")
    @Operation(summary = "Get all characters", description = "Gets all the existing characters")
    public ResponseEntity<?> getAllPersonaje() {
        return new ResponseEntity<>(personajeService.getAllPersonajes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get character by id", description = "Obtains a personaje based on its id")
    @Parameter(name="id", description="Personaje id", required=true, example="1")
    public ResponseEntity<?> getPersonajeById(@PathVariable Long id) {
        return new ResponseEntity<>(personajeService.getPersonajeById(id), HttpStatus.OK);
    }
    
    @GetMapping("/{name}")
    @Operation(summary = "Get character by name", description = "Obtains all characters with similar names")
    @Parameter(name="name", description="Campaign name", required=true, example="1")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.getPersonajeByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete character by id", description = "Deletes a character with a certain id")
    @Parameter(name="id", description="Campaign name", required=true, example="1")
    public ResponseEntity<?> deletePersonajeById(@PathVariable Long id) {
        personajeService.deletePersonajeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Creates a character", description = "Creates a new character")
    public ResponseEntity<?> newCampaign(@Valid @RequestBody Personaje personaje) {
        return new ResponseEntity<>(personajeService.newPersonaje(personaje), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")   
    @Operation(summary = "Updates a character", description = "Edits an existing character")
    public ResponseEntity<?> updatePersonaje(@Valid @RequestBody Personaje personaje) {
        return new ResponseEntity<>(personajeService.updatePersonaje(personaje), HttpStatus.OK);
    }

    @GetMapping("/{player}")
    @Operation(summary = "Get character by player", description = "Obtains all characters that belong to a certain player")
    public ResponseEntity<?> getCharacterByPlayer(@PathVariable Player player) {
        return new ResponseEntity<>(personajeService.getPersonajeByPlayer(player), HttpStatus.OK);
    }






}