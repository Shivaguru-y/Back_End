package com.cricket.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.app.Model.ScoreTable;
import com.cricket.app.Repository.ScoreTableRepository;

@Service
public class ScoreTableService {

    @Autowired
    private ScoreTableRepository scoreTableRepository;

    public List<ScoreTable> getAllScores() {
        return scoreTableRepository.findAll();
    }

    public ScoreTable getScoreById(Long id) {
        return scoreTableRepository.findById(id).orElse(null);
    }

    public ScoreTable createScore(ScoreTable scoreTable) {
        return scoreTableRepository.save(scoreTable);
    }

    public ScoreTable updateScore(Long id, ScoreTable scoreTable) {
        if (scoreTableRepository.existsById(id)) {
            scoreTable.setId(id);
            return scoreTableRepository.save(scoreTable);
        }
        return null;
    }

    public void deleteScore(Long id) {
        scoreTableRepository.deleteById(id);
    }
}
