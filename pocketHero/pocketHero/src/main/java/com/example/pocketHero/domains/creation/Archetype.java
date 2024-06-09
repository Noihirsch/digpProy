package com.example.pocketHero.domains.creation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
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
    @JsonIgnore
    private List<Trait> archetypeTraits;

    @NotNull
    @OneToMany
    private List<Gear> inventory;

    @OneToMany
    @JsonIgnore
    private List<Personaje> allMyPersonajes;

}
