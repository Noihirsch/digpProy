package com.example.pocketHero.domains.creation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@Getter
@NoArgsConstructor
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Min(0)
    private int hp;

    private int level;

    @Max(1)
    private HitDie hitDie;

    @OneToOne(mappedBy = "personaje")
    private CharacterStat characterStat;

    @OneToOne
    private Specie race;

    @ManyToOne
    private Archetype archetype;

    @OneToOne
    private Backstory backstory;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @ManyToOne
    private Player player;

    @OneToMany
    @JsonIgnore
    private List<Spell> spells;

    @OneToMany
    @JsonIgnore
    private List<Weapon> weapons;

    public void calculateHp() {
        int averageHitDieValue = this.race.getHitDie().getValue();
        this.hp = averageHitDieValue;

}

public Personaje(Long id, String name, int level, HitDie hitDie, CharacterStat characterStat, Specie specie, Archetype archetype, Backstory backstory, Player player, List<Spell> spells, List<Weapon> weapons) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.hitDie = hitDie;
    this.characterStat = characterStat;
    this.race = specie;
    this.archetype = archetype;
    this.backstory = backstory;
    this.player = player;
    this.spells = spells;
    this.weapons = weapons;

}

}



