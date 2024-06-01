package com.example.pocketHero.domains.creation;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;


@Entity
@AllArgsConstructor
public class Archetype {


    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private HitDie hitdie;

    @NotNull
    @OneToMany
    private List<Trait> archetypeTraits;

    @NotNull
    @OneToMany
    private List<Gear> inventory;

    @OneToMany
    private List<Personaje> allMyPersonajes;

}
