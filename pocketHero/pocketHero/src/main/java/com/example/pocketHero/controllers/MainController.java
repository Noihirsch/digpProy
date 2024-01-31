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
        return "index/aboutus";
    }

    @GetMapping("/campaignlist")
    public String showCampaignList() {
        return "index/campaignlist";
    }

    @GetMapping("/contact")
    public String showContactInfo() {
        return "index/contact";
    }

    
    @GetMapping("/error")
    public String showError() {
        return "error";
    }

}
