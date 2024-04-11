package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.Campaign;


public interface CampaignService {
    
    List <Campaign> findAll();

    Campaign create(Campaign campaign);
    
    Campaign edit(Campaign campaign);

    Campaign findById(Long id);

    Campaign findByName (String name);

    List <Campaign> findByCampaignId(Long campaign_id);
 
}
