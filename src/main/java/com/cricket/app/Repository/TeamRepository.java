package com.cricket.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.app.Model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
