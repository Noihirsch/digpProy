package com.example.pocketHero.domains.creation;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table (name = "CAMPAIGN")
public class Campaign {

    @Id
    @GeneratedValue
    @Column(name="campaign_id")
    @Min(value = 0)
    private Long id;

    @NotEmpty
    @Column(name="name")
    private String name; 

    @NotEmpty
    @Column(name="description")
    private String description;


    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name="DM_ID"))
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Player dm;

    @OneToMany
    @JoinTable(
        name = "campaign_players",
        joinColumns = @JoinColumn(name = "campaign_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id"))
    @JoinColumn (foreignKey = @ForeignKey(name="PLAYER_ID"))
    @OnDelete (action = OnDeleteAction.CASCADE)
    private List <Personaje> listOfPersonajes = new ArrayList<>();
  









}

