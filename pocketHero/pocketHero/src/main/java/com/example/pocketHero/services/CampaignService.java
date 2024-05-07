package com.example.pocketHero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;


public interface CampaignService {

    public List<Campaign> getAllCampaigns();

    public Campaign getCampaignById(Long id);

    public Campaign newCampaign(Campaign campaign);

    public Campaign updateCampaign(Campaign campaign);

    public void deleteCampaign(Long id);

    public Campaign getCampaignByName(String name);

    public Campaign getCampaignByCharacter(Personaje personaje);

    public Campaign getCampaignByPlayer(Player player);


    



}
