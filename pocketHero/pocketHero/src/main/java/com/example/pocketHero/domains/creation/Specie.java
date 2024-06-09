package com.example.pocketHero.domains.creation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter
@Setter

public class Specie {

    @Id
    @GeneratedValue
    @Column(name="player_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Long speed;

    @ManyToMany
    @JoinTable(
      name = "specie_language",
      joinColumns = @JoinColumn(name = "specie_id"),
      inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages = new HashSet<>();

    @OneToMany  
    @JsonIgnore
    private List<Trait> traits;
    
    private HitDie hitDie;


}