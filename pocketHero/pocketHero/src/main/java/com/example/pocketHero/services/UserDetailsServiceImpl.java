package com.example.pocketHero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pocketHero.domains.creation.Player;
import com.example.pocketHero.domains.creation.UserDetailsImpl;
import com.example.pocketHero.repositories.PlayerRepository;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsername(username);
        if (player == null) throw new UsernameNotFoundException("User not found with username: " + username);
        return UserDetailsImpl.build(player);
    }
}