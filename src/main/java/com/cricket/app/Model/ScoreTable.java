package com.cricket.app.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ScoreTable")
public class ScoreTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "matchId", referencedColumnName = "matchId")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "teamId", referencedColumnName = "teamId")
    private Team team;

    private int score;
    private int ballsFaced;
    private int bowledBalls;
    private int bowlerGivesScores;
    private int wicketsTaken;
    private int fours;
    private int sixes;


}