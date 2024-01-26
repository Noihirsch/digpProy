package com.example.pocketHero.domains;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class CampaignReg {

    @NotEmpty
    @Id
    private int campaign_id;

    @NotEmpty
    private int dm_id;

    @DateTimeFormat
    private LocalDate createdIn;

    @DateTimeFormat
    private LocalDate endedIn;

    
}
