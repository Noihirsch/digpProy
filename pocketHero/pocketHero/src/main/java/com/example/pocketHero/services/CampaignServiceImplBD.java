package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.Campaign;
import com.example.pocketHero.domains.Player;
import com.example.pocketHero.repositories.CampaignRepository;
import com.example.pocketHero.repositories.PlayerRepository;

@Service
public class CampaignServiceImplBD implements CampaignService{

    
    @Autowired 
    PlayerRepository playerRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Override
    public Campaign create(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public List<Campaign> findAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public Campaign findById(Long id) {
        return campaignRepository.findById(id).orElse(null);
    }

    @Override
    public Campaign findByName(String name) {
        return campaignRepository.findByName(name);
    }

    @Override
    public Campaign edit(Campaign campaign) {
        return campaignRepository.save(campaign);

    }

    @Override
    public List<Campaign> findByCampaign(Long campaign_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCampaign'");
    }

}