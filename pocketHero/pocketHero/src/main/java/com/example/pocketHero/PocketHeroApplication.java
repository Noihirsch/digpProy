package com.example.pocketHero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pocketHero.domains.Player;
import com.example.pocketHero.services.CampaignService;
import com.example.pocketHero.services.PlayerService;

@SpringBootApplication
public class PocketHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketHeroApplication.class, args);
	}
	@Bean
	CommandLineRunner initData(PlayerService playerService, CampaignService campaignService) {
		return args -> {
			playerService.create(new Player(01, "user123", "user@gmail.com", "1234" ));
		};

}
}