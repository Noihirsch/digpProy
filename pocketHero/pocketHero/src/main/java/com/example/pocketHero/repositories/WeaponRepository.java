package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Long>{
    
    public Weapon findByName(String name);

    public void deleteByName(String name);

    public void deleteById(Long id);
}
