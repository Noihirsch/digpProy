package com.example.pocketHero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Archetype;

@Service
public interface ArchetypeService {

    public List<Archetype> getAllArchetypes();

    public Archetype getArchetypeById(Long id);

    public Archetype newArchetype(Archetype archetype);

    public Archetype updateArchetype(Archetype archetype);

    public void deleteArchetype(Long id);

    public Archetype getArchetypeByName(String name);



    
}
