package com.example.pocketHero.domains.creation;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Min(0)
    private int hp;

    @OneToOne(mappedBy = "personaje")
    private CharacterStat characterStat;

    @OneToOne
    private Race race;

    @ManyToOne
    private Archetype archetype;

    @OneToOne
    private Backstory backstory;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @OneToMany(mappedBy = "languageId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> allMyLanguages;

    @OneToOne
    private Player player;

}
