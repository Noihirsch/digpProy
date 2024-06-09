package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.pocketHero.domains.creation.Language;
import com.example.pocketHero.services.LanguageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Language", description = "Returning available languages")

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    public LanguageService languageService;

    @GetMapping("/")
    @Operation(summary = "Get all languages", description = "Gets all the registered languages")
    public ResponseEntity<?> getAllLanguages() {
        return new ResponseEntity<>(languageService.findAllLanguages(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Get language by name", description = "Obtains a language based on the name")
    public ResponseEntity<?> getLanguageByName(@PathVariable String name) {
        return new ResponseEntity<>(languageService.findLanguageByName(name), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Get language by id", description = "Obtains a language based on the id")
    public ResponseEntity<?> getLanguageById(@PathVariable Long id) {
        return new ResponseEntity<>(languageService.findLanguageById(id), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "Delete language", description = "Deletes a language")
    public ResponseEntity<?> deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(languageService.findLanguageById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    
    
}
