package com.example.pocketHero.domains.creation;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
@AllArgsConstructor
@Entity
public class CharacterStat {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Personaje personaje;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    private int value;
}
