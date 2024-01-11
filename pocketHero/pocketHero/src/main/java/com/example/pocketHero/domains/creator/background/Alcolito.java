package com.example.pocketHero.domains.creator.background;

import java.util.ArrayList;
import java.util.List;

import com.example.pocketHero.domains.creator.Equipment;
import com.example.pocketHero.domains.creator.proficiencies.SkillProficiency;
import com.example.pocketHero.domains.creator.proficiencies.ToolProficiency;

public class Alcolito implements Background {

    String index = "alcolito";
    String name = "Alcolito";
    List <SkillProficiency> skillProf;
    List <ToolProficiency> toolProf;
    List <Equipment> equipments;
    List <String> languages = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List <SkillProficiency> getSkillProficiency() {
        return skillProf;
    }

    @Override
    public List <ToolProficiency> getToolProficiency() {
        return toolProf;
    }

    @Override
    public List <Equipment> getEquipment() {
        return equipments;
    }

    @Override
    public List <String> getLanguages() {
        return languages;
    }


    
}
