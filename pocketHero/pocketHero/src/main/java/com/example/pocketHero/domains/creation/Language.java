package com.example.pocketHero.domains.creation;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Language {
    
    @Id
    @GeneratedValue
    @Column(name="player_id")
    private Long languageId;

    @NotEmpty
    private String name;

    @ManyToMany
    private List<Race> races;
}
