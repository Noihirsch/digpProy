package com.example.pocketHero.domains.creation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Weapon {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = false, nullable = false)
    private String name;

    @Column
    private String description;
    
    @NotNull

    private String damageFormula;

    @NotNull
    private Integer range;
    
    
}
