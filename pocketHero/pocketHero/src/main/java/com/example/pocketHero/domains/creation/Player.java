package com.example.pocketHero.domains.creation;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter 
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String password; 

    private boolean isDM;

    @OneToMany
    @JoinColumn(name = "player_id")
    private List<Campaign> campaignsDMed = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "player_id")
    private List<Personaje> personajes = new ArrayList<>();
    

}