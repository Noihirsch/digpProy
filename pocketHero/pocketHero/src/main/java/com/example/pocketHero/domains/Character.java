package com.example.pocketHero.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Character {
    @Id
    @GeneratedValue
    @Column(name="character_id")
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotEmpty
    @Column(name="hp")
    private int hp;

1   @NotEmpty
    @Column(name="CharacterStat")
    private CharacterStat CharacterStat;
    
    @Column(name="race")
     private Race race;

    @Column(name="archetype")
    private Archetype archetype;

    @Column(name="background")
    private Background background;


}
