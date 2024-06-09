package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Backstory;
import com.example.pocketHero.repositories.BackstoryRepository;


@Service
public class BackstoryServiceImpl implements BackstoryService{

    @Autowired
    public BackstoryRepository backstoryRepository;

    public List<Backstory> getAllBackstories() {
        return backstoryRepository.findAll();
    }

    public Backstory getBackstoryById(Long id) {
        return backstoryRepository.findById(id).get();
    }

    public Backstory newBackstory(Backstory backstory) {
        return backstoryRepository.save(backstory);
    }

    public Backstory updateBackstory(Backstory backstory) {
        return backstoryRepository.save(backstory);
    }

    public void deleteBackstory(Long id) {
        backstoryRepository.deleteById(id);
    }

    public Backstory getBackstoryByName(String name) {
        return backstoryRepository.findByName(name);
    }

    
    
    
}
