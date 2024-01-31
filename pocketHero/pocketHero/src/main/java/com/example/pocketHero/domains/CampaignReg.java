package com.example.pocketHero.domains;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of="id")

@Embeddable
public class CampaignReg {
    @DateTimeFormat
    private LocalDate startedIn;

    @DateTimeFormat
    private LocalDate endedIn;

    
}
