package com.example.pocketHero.services;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.DTOs.newCharacterDTO;
import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Language;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.repositories.PersonajeRepository;

import jakarta.validation.Valid;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    private Set<Language> allMyLanguages = new HashSet<>();

    @Override
    public List<Personaje> getAllPersonajes() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje getPersonajeById(Long id) {
        Optional<Personaje> personaje = personajeRepository.findById(id);
        if (personaje.isPresent()) {
            return personaje.get();
        } else {
            throw new IllegalArgumentException("Personaje not found with id: " + id);
        }
    }

    @Override
    public Personaje newPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public Personaje updatePersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }

    @Override
    public Personaje getPersonajeByName(String name) {
        return personajeRepository.findByName(name);
    }

    @Override
    public Personaje getPersonajeByCampaign(Campaign campaign) {
        return personajeRepository.getPersonajeByCampaign(campaign);
    }

    @Override
    public Personaje getPersonajeByPlayer(Player player) {
        return personajeRepository.getPersonajeByPlayer(player);
    }

    @Override
    public void deletePersonajeById(Long id) {
        personajeRepository.deleteById(id);
    }

    public void addLanguage(Language language) {
        if (this.allMyLanguages.size() < 3) {
            this.allMyLanguages.add(language);
        } else {
            throw new IllegalStateException("Cannot add more than 3 languages");
        }
    }

    public void removeLanguage(Language language) {
        this.allMyLanguages.remove(language);
    }

    public void setAllMyLanguages(Set<Language> languages) {
        if (languages.size() <= 3) {
            this.allMyLanguages = languages;
        } else {
            throw new IllegalArgumentException("No puedes añadir más de tres idiomas");
        }
    }

    public Set<Language> getAllMyLanguages() {
        return this.allMyLanguages;
    }

}
