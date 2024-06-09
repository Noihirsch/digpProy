package com.example.pocketHero.DTOs;

import com.example.pocketHero.domains.creation.HitDie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor

public class newCharacterDTO {

    
    private Long id;
    private String name;
    private int age;
    private String race;
    private String classType;
    public HitDie hitDie;

}


    
