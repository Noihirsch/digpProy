package com.example.pocketHero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.pocketHero.domains.creation.Player;
public interface PlayerRepository extends JpaRepository <Player, Long> {

    Player findByUsername(String username);
    @Transactional
    @Modifying
    @Query("DELETE FROM Player p WHERE p.username = ?1")
    void deleteByUsername(String username);


    boolean existsById(Long id);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    
}
