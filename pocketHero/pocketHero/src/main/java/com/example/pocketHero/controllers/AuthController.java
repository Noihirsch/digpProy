package com.example.pocketHero.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocketHero.DTOs.JwtResponseDto;
import com.example.pocketHero.DTOs.LoginDto;
import com.example.pocketHero.DTOs.SignupDto;
import com.example.pocketHero.domains.creation.MessageResponse;
import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.domains.creation.Rol;
import com.example.pocketHero.domains.creation.UserDetailsImpl;
import com.example.pocketHero.repositories.PlayerRepository;
import com.example.pocketHero.security.JwtUtils;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        PlayerRepository usuarioRepository;

        @Autowired
        PasswordEncoder encoder;

        @Autowired
        JwtUtils jwtUtils;

        @PostMapping("/signin")
        public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginDto) {

                Authentication authentication = authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtils.generateJwtToken(authentication);

                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                String rol = userDetails.getAuthorities().stream().findFirst().map(a -> a.getAuthority())
                                .orElse("ERROR");

                return ResponseEntity.ok(new JwtResponseDto(jwt, "Bearer",
                                userDetails.getId(),
                                userDetails.getUsername(),
                                userDetails.getEmail(),
                                userDetails.getPassword()
                                , rol));
        }

        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDto signUpRequest) {
                if (usuarioRepository.existsByUsername(signUpRequest.getUsername())) {
                        return ResponseEntity
                                        .badRequest()
                                        .body(new MessageResponse("Error: Username is already taken!"));
                }

                if (usuarioRepository.existsByEmail(signUpRequest.getEmail())) {
                        return ResponseEntity
                                        .badRequest()
                                        .body(new MessageResponse("Error: Email is already in use!"));
                }

                // Create new user's account
                Player user = new Player(signUpRequest.getUsername(),
                                signUpRequest.getEmail(),
                                signUpRequest.getPassword(),
                                Rol.valueOf(signUpRequest.getRol())
                                );
                usuarioRepository.save(user);
                return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
}
