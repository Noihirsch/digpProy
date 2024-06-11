package com.example.pocketHero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.domains.creation.Personaje;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.repositories.CampaignRepository;
import com.example.pocketHero.repositories.PersonajeRepository;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    public CampaignRepository campaignRepository;

    @Autowired
    public PersonajeRepository personajeRepository;

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id).get();
    }

    public Campaign newCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }

    public Campaign getCampaignByName(String name) {
        return campaignRepository.findByName(name);
    }

    @Override
    public Campaign getCampaignByCharacter(Personaje character) {
        return campaignRepository.getCampaignByPersonajes(character);
    }

    @Override
    public Campaign getCampaignByPlayer(Player player) {
        return campaignRepository.findByPlayer(player);
    }

    @Override
    public Object updateCampaignById(Campaign campaign) {
        return campaignRepository.save(campaign);
    }



}
