package com.example.pocketHero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Specie;


public interface RaceService {

    public List<Specie> getAllRaces();

    public Specie getRaceById(Long id);

    public Specie newRace(Specie specie);

    public Specie updateRace(Specie specie);

    public void deleteRace(Long id);

    public Specie getRaceByName(String name);


    
}
