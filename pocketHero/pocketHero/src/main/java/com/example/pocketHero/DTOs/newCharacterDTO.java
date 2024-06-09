package com.example.pocketHero.DTOs;

import java.util.List;

import com.example.pocketHero.domains.creation.Archetype;
import com.example.pocketHero.domains.creation.Backstory;
import com.example.pocketHero.domains.creation.CharacterStat;
import com.example.pocketHero.domains.creation.HitDie;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.domains.creation.Specie;
import com.example.pocketHero.domains.creation.Spell;
import com.example.pocketHero.domains.creation.Weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor

public class NewCharacterDTO {

    
    private Long id;
    private String name;
    private int level;
    private HitDie hitDie;
    private CharacterStat characterStat;
    private Specie race;
    private Archetype archetype;
    public Backstory backstory;
    public Player player;
    public List<Spell> spells;
    public List<Weapon> weapons;
    

}


    
