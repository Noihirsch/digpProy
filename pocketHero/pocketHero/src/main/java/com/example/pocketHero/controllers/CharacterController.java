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
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.services.CampaignService;
import com.example.pocketHero.services.PersonajeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/personaje")
public class CharacterController {

    @Autowired
    public PersonajeService personajeService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPersonaje() {
        return new ResponseEntity<>(personajeService.getAllPersonajes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonajeById(@PathVariable Long id) {
        return new ResponseEntity<>(personajeService.getPersonajeById(id), HttpStatus.OK);
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.getPersonajeByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonaje(@PathVariable Long id) {
        personajeService.deletePersonaje(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> newCampaign(@Valid @RequestBody Personaje personaje) {
        return new ResponseEntity<>(personajeService.newPersonaje(personaje), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")   
    public ResponseEntity<?> updatePersonaje(@Valid @RequestBody Personaje personaje) {
        return new ResponseEntity<>(personajeService.updatePersonaje(personaje), HttpStatus.OK);
    }

    @GetMapping("/{dm}")
    public ResponseEntity<?> getCharacterByPlayer(@PathVariable Player player) {
        return new ResponseEntity<>(personajeService.getCharacterByPlayer(player), HttpStatus.OK);
    }






}