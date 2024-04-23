package com.example.pocketHero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pocketHero.domains.user.Player;

@SpringBootApplication
public class PocketHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketHeroApplication.class, args);
	}
}
