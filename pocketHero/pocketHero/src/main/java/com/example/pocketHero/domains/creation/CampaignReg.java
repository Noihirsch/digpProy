package com.example.pocketHero.domains.creation;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class CampaignReg {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @ManyToOne
    private Campaign campaign;

    @NotEmpty
    @ManyToOne 
    private Player player;

    @DateTimeFormat
    private LocalDate startedIn;

    @DateTimeFormat
    private LocalDate endedIn;
    
}
