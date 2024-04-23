package com.example.pocketHero.domains.creation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Character {
    @Id
    @GeneratedValue
    @Column(name="character_id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @Min(0)
    @Column(name="hp")
    private int hp;

    @OneToOne
    private CharacterStat CharacterStat;
    
    @OneToOne
     private Race race;

    @OneToOne
    private Archetype archetype;

    @OneToOne
    private Backstory backstory;


}
