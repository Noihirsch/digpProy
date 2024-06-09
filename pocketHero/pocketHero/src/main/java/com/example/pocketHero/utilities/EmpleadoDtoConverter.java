package com.example.pocketHero.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pocketHero.DTOs.NewCampaignDTO;
import com.example.pocketHero.domains.creation.Campaign;
import com.example.pocketHero.services.CampaignService;

@Component
public class EmpleadoDtoConverter {
    @Autowired
    CampaignService campaignService;

    public Campaign convertDtoToCampaign(NewCampaignDTO newCampaignDTO) {
        return new Campaign(null,
            newCampaignDTO.getName(),
            newCampaignDTO.getDescription(),
            null,
            newCampaignDTO.getPlayer());
    }

    public Campaign convertDtoToEmpleado(NewCampaignDTO newCampaignDTO, Long id) {
        Campaign campaign = convertDtoToCampaign(newCampaignDTO);
        campaign.setId(id);
        return campaign;
    }
}