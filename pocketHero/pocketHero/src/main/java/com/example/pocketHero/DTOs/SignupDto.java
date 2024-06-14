package com.example.pocketHero.DTOs;

import com.example.pocketHero.domains.creation.Rol;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class SignupDto {
    @NotBlank(message = "Username is required")
@Size(min = 3, max = 20)
private String username;


  @Size(max = 50)
  @NotBlank(message = "Email is required")
  @Email
  private String email;


  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  private String rol;

}
