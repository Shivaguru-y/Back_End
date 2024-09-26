package com.cricket.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.app.Model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}