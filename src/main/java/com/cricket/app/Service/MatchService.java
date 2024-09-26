package com.cricket.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.app.Model.Match;
import com.cricket.app.Repository.MatchRepository;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match match) {
        if (matchRepository.existsById(id)) {
            match.setMatchId(id);
            return matchRepository.save(match);
        }
        return null;
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
