package com.example.pocketHero.services;

import java.util.List;

import com.example.pocketHero.domains.creation.CampaignReg;

public interface CampaignRegService {

    public List<CampaignReg> getAllCampaignRegs();

    public CampaignReg getCampaignRegById(Long id);

    public CampaignReg newCampaignReg(CampaignReg campaignReg);

    public CampaignReg updateCampaignReg(CampaignReg campaignReg);

    public void deleteCampaignReg(Long id);

    public List<CampaignReg> getCampaignsByYear(int year);

}
