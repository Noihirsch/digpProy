package com.example.pocketHero.domains.creation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Stat {

    @Id
    private Long num;

    private StatType stat;

    
}
