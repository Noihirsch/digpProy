package com.example.pocketHero.domains.creation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Gear {
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String description;

    public String type;
    
}
