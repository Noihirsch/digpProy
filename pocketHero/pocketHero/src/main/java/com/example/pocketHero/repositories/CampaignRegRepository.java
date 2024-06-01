package com.example.pocketHero.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pocketHero.domains.creation.CampaignReg;

public interface CampaignRegRepository extends JpaRepository<CampaignReg, Long> {

    CampaignReg findByCampaignId(Long campaignId);

    CampaignReg findByPlayerId(Long playerId);

    @Query("SELECT c FROM CampaignReg c WHERE c.startedIn >= :startDate AND c.endedIn <= :endDate")
    List<CampaignReg> findCampaignsByDateRange(@Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);



}
