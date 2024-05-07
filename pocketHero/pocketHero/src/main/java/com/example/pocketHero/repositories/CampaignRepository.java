package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Campaign findByName(String name);

    Campaign findByPlayer(Player player);

    Campaign getCampaignByPersonajes(Personaje personaje);


}
