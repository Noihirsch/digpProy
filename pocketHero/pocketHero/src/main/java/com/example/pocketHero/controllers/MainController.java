package com.example.pocketHero.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHome() {
        
        return "index";
    }

    @GetMapping("/about-us")
    public String showAboutUs() {
        return "/aboutus";
    }

    @GetMapping("/create")
    public String showCreator() {
        return "/creator/createCharacter";
    }

    @GetMapping("/join-a-game")
    public String showCampaignList() {
        return "/campaignlist";
    }

    @GetMapping("/contact")
    public String showContactInfo() {
        return "/contact";
    }

    
    @GetMapping("/error")
    public String showError() {
        return "error";
    }

}
