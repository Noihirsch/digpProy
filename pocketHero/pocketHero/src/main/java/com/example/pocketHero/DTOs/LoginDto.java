package com.example.pocketHero.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
@NotBlank
private String username;
@NotBlank
private String password;
}