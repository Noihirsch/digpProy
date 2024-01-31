package com.example.pocketHero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pocketHero.domains.Player;
import com.example.pocketHero.services.CampaignService;
import com.example.pocketHero.services.PlayerService;

import jakarta.validation.Valid;

@Controller
@Primary
@RequestMapping("/user")
public class PlayerController {

    
    @Autowired
    public PlayerService playerService;

    @Autowired
    public CampaignService campaignService;

        @GetMapping({ "/{id}", "/list/{id}" })
    public String showList(@PathVariable long id, Model model) {
        Player player = playerService.findById(id);
        if (player != null){
            model.addAttribute("playerForm", player);
            return "user/listView";
        }
        return "redirect:/index/login";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Player player = playerService.findById(id);
        if (player != null) {
            model.addAttribute("playerForm", player);
            return "empleados/editFormView";
        }

        return "redirect:/";
    }

    @PostMapping("/editar/submit")
    public String showEditSubmit(@Valid Player playerForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            playerService.edit(playerForm);
        return "redirect:/list";
    }


}

