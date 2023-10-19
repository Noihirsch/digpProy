package com.example.pocketHero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String greetVisitor(@RequestParam(name = "username", required = false) String username, Model model) {
        String welcome = "";
        if (username != null && !username.isEmpty()) {
            welcome += "Bienvenido, " + username;
        } else {
            welcome += "Bienvenido, jugador";
        }
        model.addAttribute("welcome", welcome);
        return "index"; 
    }
    
}
