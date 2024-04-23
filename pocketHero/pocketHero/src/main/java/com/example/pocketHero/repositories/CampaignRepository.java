package com.example.pocketHero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pocketHero.domains.creation.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Campaign findByName(String name);
}
