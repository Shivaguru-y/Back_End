package com.cricket.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.app.Model.Player;
import com.cricket.app.Repository.PlayerRepository;
import com.cricket.app.Repository.TeamRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player createPlayer(Player player) {
        if (player.getTeam() != null) {
            Long teamId = player.getTeam().getTeamId();
            player.setTeam(teamRepository.findById(teamId).orElse(null));
        }
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player playerDetails) {
        return playerRepository.findById(id).map(player -> {
            player.setPlayerName(playerDetails.getPlayerName());
            if (playerDetails.getTeam() != null) {
                Long teamId = playerDetails.getTeam().getTeamId();
                player.setTeam(teamRepository.findById(teamId).orElse(null));
            }
            return playerRepository.save(player);
        }).orElse(null);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
