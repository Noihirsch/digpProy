package com.example.pocketHero.domains.creation;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor  
@Getter
@Setter
public class CharacterReg {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Personaje personaje;

    @DateTimeFormat
    private LocalDate createdIn;

    
}
