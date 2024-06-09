package com.example.pocketHero.domains.creation;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Debe llevar un nombre obligatoriamente")
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "languages")
    private Set<Specie> species = new HashSet<>();
    
    // No podemos crear más idiomas. Estos son los restringidos.
    public static final Language COMMON = new Language(null, "COMMON", "El idioma común", null);
    public static final Language ORCISH = new Language(null, "ORCISH", "El idioma de los orcos", null);
    public static final Language ELVISH = new Language(null, "ELVISH", "El idioma de los elfos", null);
    public static final Language DWARVISH = new Language(null, "DWARVISH", "El idioma de los enanos", null);
    public static final Language DRACONIC = new Language(null, "DRACONIC", "El idioma de los dragones", null);
    public static final Language CELESTIAL = new Language(null, "CELESTIAL", "El idioma celestial", null);
    public static final Language INFERNAL = new Language(null, "INFERNAL", "El idioma infernal", null);

}
