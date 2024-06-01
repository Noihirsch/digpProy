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
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Player", description = "Obtain all the data related to the players that are registered on the app")
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    public PlayerService playerService;

    @GetMapping("/")
    @Operation(summary = "Get all players", description = "Gets all players")
    public ResponseEntity<?> getAllCampaigns() {
        return new ResponseEntity<>(playerService.findAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get player", description = "Gets a player by their ID")
    @Parameter(name = "id", description = "Player id", example = "1", required = true)
    public ResponseEntity<?> getPlayerById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(playerService.findPlayerById(id), HttpStatus.OK);
    }

    @GetMapping("/whoIsDM")
    @Operation(summary = "Get Dungeon Masters", description = "Get players who are dungeon masters")
    public ResponseEntity<?> getPlayersWhoAreDM() {
        return new ResponseEntity<>(playerService.findPlayersWhoAreDM(), HttpStatus.OK);
    }
    
    @GetMapping("username/{username}")
    @Parameter(name = "username", description = "Player username", example = "usuario", required = true)
    @Operation(summary = "Get by username", description = "Get a player by username")
    public ResponseEntity<?> getPlayerByUsername(@PathVariable String username) {
        return new ResponseEntity<>(playerService.findPlayerByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Create player", description = "Creates a new player")
    public ResponseEntity<?> createPlayer(@Valid @RequestBody Player player) {
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.CREATED);
    }

    @DeleteMapping("id/{id}")
    @Parameter(name = "id", description = "Player id", example = "1", required = true)
    @Operation(summary = "Delete player by id", description = "Deletes a player by their id")
    public ResponseEntity<?> deletePlayerById(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    @Parameter(name = "id", description = "Player id", example = "1", required = true)
    @Operation(summary = "Edit player", description = "Edits a player")
    public ResponseEntity<?> updatePlayer(@Valid @RequestBody Player player) {
        playerService.updatePlayer(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }
} 