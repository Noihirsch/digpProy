package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.Campaign;
import com.example.pocketHero.domains.Player;
import java.util.List;


public interface PlayerRepository extends JpaRepository <Player, Long> {


    public List <Player> findByCampaign(Campaign campaign);

    public Player findByUsername(String username);

}