package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Archetype;
import com.example.pocketHero.repositories.ArchetypeRepository;

@Service
public class ArchetypeServiceImpl implements ArchetypeService {

    @Autowired
    public ArchetypeRepository archetypeRepository;

    public List<Archetype> getAllArchetypes() {
        return archetypeRepository.findAll();
    }

    public Archetype getArchetypeById(Long id) {
        return archetypeRepository.findById(id).get();
    }

    public Archetype newArchetype(Archetype archetype) {
        return archetypeRepository.save(archetype);
    }

    public Archetype updateArchetype(Archetype archetype) {
        return archetypeRepository.save(archetype);
    }

    public void deleteArchetype(Long id) {
        archetypeRepository.deleteById(id);
    }

    public Archetype getArchetypeByName(String name) {
        return archetypeRepository.findByName(name);
    }

    
    
}
