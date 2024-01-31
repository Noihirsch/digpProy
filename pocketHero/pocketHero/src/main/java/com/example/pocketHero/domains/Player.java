package com.example.pocketHero.domains;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "PLAYER")
@Getter
@Setter

public class Player {
    @Id
    @Column(name="player_id")
    private Long id;

    @NotEmpty
    @Column(unique= true)
    private String username;

    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;
    
    @NotEmpty
    @Column(name = "password")
    private String password; 
    

    @DateTimeFormat
    @Column(name="signup_date")
    private LocalDate signup_date;

    private boolean isDM;

    


}
