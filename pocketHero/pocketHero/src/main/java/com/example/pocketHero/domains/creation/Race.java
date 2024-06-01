package com.example.pocketHero.domains.creation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Entity
public class Race {

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

    @NotNull
    private String size;

    @OneToMany(mappedBy = "languageId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> language;

    @OneToMany  // or @OneToMany, depending on your relationship
    private List<Trait> traits;
}