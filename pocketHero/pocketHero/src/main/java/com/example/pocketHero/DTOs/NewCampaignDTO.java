package com.example.pocketHero.DTOs;

import com.example.pocketHero.domains.creation.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class NewCampaignDTO {

    private Long id;
    private String name;
    private String description;
    private Player player;
    
}
