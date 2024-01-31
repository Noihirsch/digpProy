package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.Campaign;


public interface CampaignService {

    Campaign create(Campaign campaign);

    List <Campaign> findAllCampaigns();

    Campaign findById(Long id);

    Campaign findByName (String name);

    Campaign edit(Campaign campaign);

    List <Campaign> findByCampaign(Long campaign_id);
 
}
