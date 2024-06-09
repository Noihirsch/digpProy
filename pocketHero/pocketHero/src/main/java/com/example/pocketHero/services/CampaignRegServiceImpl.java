package com.example.pocketHero.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pocketHero.domains.creation.CampaignReg;
import com.example.pocketHero.repositories.CampaignRegRepository;

@Service
public class CampaignRegServiceImpl implements CampaignRegService {

    @Autowired
    public CampaignRegRepository campaignRegRepository;

    public List<CampaignReg> getAllCampaignRegs() {
        return campaignRegRepository.findAll();
    }

    public CampaignReg getCampaignRegById(Long id) {
        return campaignRegRepository.findById(id).get();
    }

    public CampaignReg newCampaignReg(CampaignReg campaignReg) {
        return campaignRegRepository.save(campaignReg);
    }

    public CampaignReg updateCampaignReg(CampaignReg campaignReg) {
        return campaignRegRepository.save(campaignReg);
    }

    public void deleteCampaignReg(Long id) {
        campaignRegRepository.deleteById(id);
    }

    public List<CampaignReg> getCampaignsByYear(int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        return campaignRegRepository.findCampaignsByDateRange(startDate, endDate);

    }
}
