package com.example.pocketHero.domains.creation;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@AllArgsConstructor
public class Archetype {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    @NotNull
    private String name;

    @NotNull
    @Column(name="description")
    private String description;

    @NotNull
    @Column(name="hit_die")
    private HitDie hitdie;

    @NotNull
    @Column(name="proficiencies")
    @OneToMany
    private List<Proficiency> proficiencies;

    @NotNull
    @Column(name="inventory")
    @OneToMany
    private List<Gear> inventory;


}
