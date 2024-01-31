package com.example.pocketHero.domains;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Player {
    
    @Id
    @GeneratedValue
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
