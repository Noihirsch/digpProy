package com.example.pocketHero.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseDto {
private String token;
private String type;
private Long id;
private String username;
private String email;
private String password;
private String rol;
}