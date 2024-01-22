package com.example.pocketHero.domains;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
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
public class Campaign {

    @Id
    @GeneratedValue
    @Column(name="campaign_id")
    @Min(value = 0)
    private Long id;

    @NotEmpty
    private String name; 

    @NotEmpty
    private String description; 



}

