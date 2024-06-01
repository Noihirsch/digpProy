package com.example.pocketHero.domains.creation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Information {

    @Id
    private Long id;    
    
}
