package com.example.pocketHero.domains.creation;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Personaje {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Min(0)
    private int hp;

    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private CharacterStat CharacterStat;
    
    @OneToOne
     private Race race;

    @ManyToOne
    private Archetype archetype;

    @OneToOne
    private Backstory backstory;

    @OneToMany(mappedBy = "languageId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> allMyLanguages;

}
