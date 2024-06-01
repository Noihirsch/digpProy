package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.repositories.PersonajeRepository;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    public PersonajeRepository personajeRepository;

    public List<Personaje> getAllPersonajes() {
        return personajeRepository.findAll();
    }

    public Personaje getPersonajeById(Long id) {
        return personajeRepository.findById(id).get();
    }

    public Personaje newPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public Personaje updatePersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }

    public Personaje getPersonajeByName(String name) {
        return personajeRepository.findByName(name);
    }

    public Personaje getPersonajeByCampaign(Campaign campaign) {
        return personajeRepository.getPersonajeByCampaign(campaign);
    }

    public Personaje getPersonajeByPlayer(Player player) {
        return personajeRepository.getPersonajeByPlayer(player);
    }

    @Override
    public Object getCharacterByPlayer(Player player) {
        return personajeRepository.getPersonajeByPlayer(player);
    
    }
}
