package com.example.pocketHero.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHome() {
        
        return "index";
    }

    @GetMapping("/aboutus")
    public String showAboutUs() {
        return "aboutus";
    }

    @GetMapping("/campaign")
    public String showCampaigns() {
        return "campaign";
    }

    @GetMapping("/campaignlist")
    public String showCampaignList() {
        return "campaignlist";
    }

    @GetMapping("/create")
    public String showCharacterCreator() {
        return "charcreator";
    }

    @GetMapping("/contact")
    public String showContactInfo() {
        return "contact";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/user")
    public String showMyProfile() {
        return "profile";
    }

    
    @GetMapping("/error")
    public String showError() {
        return "error";
    }

}
