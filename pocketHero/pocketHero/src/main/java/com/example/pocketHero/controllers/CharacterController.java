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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.pocketHero.DTOs.NewCharacterDTO;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.services.PersonajeService;
import com.example.pocketHero.services.RaceService;

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

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public RaceService raceService;

    @GetMapping("/")
    @Operation(summary = "Get all characters", description = "Gets all the existing characters")
    public ResponseEntity<?> getAllPersonaje() {
        List<Personaje> personajes = personajeService.getAllPersonajes();
        if (personajes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<NewCharacterDTO> personajesDTO = new ArrayList<>();
            for (Personaje personaje : personajes) {
                personajesDTO.add(modelMapper.map(personaje, NewCharacterDTO.class));
            }
            return ResponseEntity.ok(personajesDTO);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get character by id", description = "Obtains a personaje based on its id")
    @Parameter(name = "id", description = "Personaje id", required = true, example = "1")
    public ResponseEntity<?> getPersonajeById(@PathVariable Long id) {
        if (personajeService.getPersonajeById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Cannot find this character based on the id you provided us with. (404)");
        } else {
            return new ResponseEntity<>(personajeService.getPersonajeById(id), HttpStatus.OK);
        }
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get character by name", description = "Obtains all characters with similar names")
    @Parameter(name = "name", description = "Campaign name", required = true, example = "1")
    public ResponseEntity<?> getPersonajeByName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.getPersonajeByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete character by id", description = "Deletes a character with a certain id")
    @Parameter(name = "id", description = "Campaign name", required = true, example = "1")
    public ResponseEntity<?> deletePersonajeById(@PathVariable Long id) {
        personajeService.deletePersonajeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/personaje")
    public ResponseEntity<?> newCharacter(@RequestBody NewCharacterDTO newCharacterDTO) {
        Personaje character = new Personaje(null, 
                newCharacterDTO.getName(),
                newCharacterDTO.getLevel(),
                newCharacterDTO.getHitDie(),
                newCharacterDTO.getCharacterStat(),
                newCharacterDTO.getRace(),
                newCharacterDTO.getArchetype(),
                newCharacterDTO.getBackstory(),
                newCharacterDTO.getPlayer(),
                newCharacterDTO.getSpells(),
                newCharacterDTO.getWeapons());
        Personaje characterSaved = personajeService.newPersonaje(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved); // cod 201
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