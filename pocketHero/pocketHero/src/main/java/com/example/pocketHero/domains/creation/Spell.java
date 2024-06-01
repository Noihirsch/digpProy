package com.example.pocketHero.domains.creation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Spell {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

}
