package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.creation.Weapon;

public interface WeaponService {

    public List<Weapon> getAllWeapons();

    public Weapon getWeaponById(Long id);

    public Weapon newWeapon(Weapon weapon);

    public Weapon updateWeapon(Weapon weapon);

    public void deleteWeapon(Long id);

    public Weapon getWeaponByName(String name);

    
    
}
