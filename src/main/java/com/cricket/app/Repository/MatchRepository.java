package com.cricket.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.app.Model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
