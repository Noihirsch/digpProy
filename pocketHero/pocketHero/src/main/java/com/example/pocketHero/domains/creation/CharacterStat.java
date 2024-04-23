package com.example.pocketHero.domains.creation;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class CharacterStat {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Character character;

    @Enumerated(EnumType.STRING)
    private StatType statType;

    private int value;
}

