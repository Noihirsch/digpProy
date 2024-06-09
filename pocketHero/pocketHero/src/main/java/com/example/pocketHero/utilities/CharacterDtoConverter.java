package com.example.pocketHero.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pocketHero.DTOs.NewCharacterDTO;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.services.PersonajeService;

@Component
public class CharacterDtoConverter {

    @Autowired
    private PersonajeService personajeService;

    public Personaje convertDtoToPersonaje(NewCharacterDTO newCharacterDTO) {
        return new Personaje(null,
            newCharacterDTO.getName(),
            newCharacterDTO.getLevel(),
            newCharacterDTO.getHitDie(),
            newCharacterDTO.getCharacterStat(),
            newCharacterDTO.getRace(),
            newCharacterDTO.getArchetype(),
            newCharacterDTO.getBackstory(),
            newCharacterDTO.getPlayer(),
            newCharacterDTO.getSpells(),
            newCharacterDTO.getWeapons()
        );

    }

    public Personaje convertDtoToPersonaje(NewCharacterDTO newCharacterDTO, Long id) {
        Personaje personaje = convertDtoToPersonaje(newCharacterDTO);
        personaje.setId(id);
        return personaje;
    }

}
