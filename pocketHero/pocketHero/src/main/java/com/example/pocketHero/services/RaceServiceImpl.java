package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Specie;
import com.example.pocketHero.repositories.RaceRepository;

@Service
public class RaceServiceImpl implements RaceService{

    @Autowired
    private RaceRepository raceRepository;

    public List<Specie> getAllRaces(){
        return raceRepository.findAll();
    }

    public Specie getRaceById(Long id){
        return raceRepository.findById(id).get();
    }

    public Specie newRace(Specie specie){
        return raceRepository.save(specie);
    }

    public Specie updateRace(Specie specie){
        return raceRepository.save(specie);
    }

    public void deleteRace(Long id){
        raceRepository.deleteById(id);
    }

    public Specie getRaceByName(String name){
        return raceRepository.findByName(name);
    }

    
    

    
    
}
