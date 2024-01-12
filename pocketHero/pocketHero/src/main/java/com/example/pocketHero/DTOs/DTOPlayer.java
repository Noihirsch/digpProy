package com.example.pocketHero.DTOs;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.pocketHero.domains.Campaign;

import jakarta.persistence.JoinColumn;
public class DTOPlayer {

    @JoinColumn (name= "CAMPAIGN_ID", foreignKey = @ForeignKey(name="CAMPAIGN_ID_FK"))
    @OnDelete (action = OnDeleteAction.CASCADE)
    private Campaign campaign;

    public void setId(Long id) {
    }

    public void setUsername(String email) {

    }

    public void setPassword(String password){

    }

    public Long getId(){
        return null;
    }

    public String getPassword(){

    }



    public String getUsername(){

    }




    
}
