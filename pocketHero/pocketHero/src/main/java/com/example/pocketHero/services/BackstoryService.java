package com.example.pocketHero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Backstory;

public interface BackstoryService {

    public List<Backstory> getAllBackstories();
    
    public Backstory getBackstoryById(Long id);

    public Backstory newBackstory(Backstory backstory);

    public Backstory updateBackstory(Backstory backstory);

    public void deleteBackstory(Long id);

    public Backstory getBackstoryByName(String name);

    
}
