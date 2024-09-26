package com.cricket.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.app.Model.ScoreTable;

@Repository
public interface ScoreTableRepository extends JpaRepository<ScoreTable, Long> {
}
