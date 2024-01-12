package com.example.pocketHero.controllers;

import org.springframework.stereotype.Controller;

public class PlayerController {
    @Controller
    @RequestMappign("/")
    public class PlayerController {

        @Autowired
        public PlayerService PlayerService;

        @GetMapping({"/", "/list"})
        public String showProfile(Model model){
            model.AddAttribute("playerForm", new Player());
            
            return "user/profileView";
        }

        
    }

}
