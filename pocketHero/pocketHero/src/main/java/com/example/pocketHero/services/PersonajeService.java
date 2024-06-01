package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;

import jakarta.validation.Valid;

public interface PersonajeService {

    public List<Personaje> getAllPersonajes();

    public Personaje getPersonajeById(Long id);

    public Personaje newPersonaje(Personaje personaje);

    public Personaje updatePersonaje(Personaje personaje);

    public void deletePersonaje(Long id);

    public Personaje getPersonajeByName(String name);

    public Personaje getPersonajeByCampaign(Campaign campaign);

    public Personaje getPersonajeByPlayer(Player player);

    public Object getCharacterByPlayer(Player player);

    public void deletePersonajeById(Long id);

    
}
