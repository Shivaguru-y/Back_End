package com.cricket.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.app.Model.ScoreTable;
import com.cricket.app.Service.ScoreTableService;

@RestController
@RequestMapping("/scores")
public class ScoreTableController {

    @Autowired
    private ScoreTableService scoreTableService;

    @GetMapping("/getAllScores")
    public List<ScoreTable> getAllScores() {
        return scoreTableService.getAllScores();
    }

    @GetMapping("/getScoreById/{id}")
    public ResponseEntity<ScoreTable> getScoreById(@PathVariable Long id) {
        ScoreTable score = scoreTableService.getScoreById(id);
        return score != null ? ResponseEntity.ok(score) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createScore")
    public ScoreTable createScore(@RequestBody ScoreTable scoreTable) {
        return scoreTableService.createScore(scoreTable);
    }

    @PutMapping("/updateScoreById/{id}")
    public ResponseEntity<ScoreTable> updateScore(@PathVariable Long id, @RequestBody ScoreTable scoreTable) {
        ScoreTable updatedScore = scoreTableService.updateScore(id, scoreTable);
        return updatedScore != null ? ResponseEntity.ok(updatedScore) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteScoreById/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreTableService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
