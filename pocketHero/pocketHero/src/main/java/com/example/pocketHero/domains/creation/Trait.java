package com.example.pocketHero.domains.creation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Trait {

    @Id    
    @NotNull
    @NotEmpty
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    
    @NotNull
    private String description;

    @ManyToOne
    private Archetype archetype;

}
