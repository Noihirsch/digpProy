package com.example.pocketHero.domains.creator.background;

import java.util.List;

import com.example.pocketHero.domains.creator.Equipment;
import com.example.pocketHero.domains.creator.proficiencies.SkillProficiency;
import com.example.pocketHero.domains.creator.proficiencies.ToolProficiency;

public interface Background {
    
    String getName();

    List <SkillProficiency> getSkillProficiency();

    List <ToolProficiency> getToolProficiency();

    List <Equipment> getEquipment();

    String getLanguages();
}
 