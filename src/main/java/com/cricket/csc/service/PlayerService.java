package com.cricket.csc.service;

import com.cricket.csc.dto.PlayerAddRequest;
import com.cricket.csc.dto.PlayerAddResponse;
import com.cricket.csc.model.Player;
import com.cricket.csc.model.Team;
import com.cricket.csc.repository.PlayerRepository;
import com.cricket.csc.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public PlayerAddResponse addPlayer(PlayerAddRequest playerAddRequest) {
        Team team = teamRepository.findById(playerAddRequest.getTeamId()).orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + playerAddRequest.getTeamId()));
        Player player = Player.builder()
                .name(playerAddRequest.getName())
                .team(team)
                .role(playerAddRequest.getRole())
                .build();
        playerRepository.save(player);
        return new PlayerAddResponse(player.getId(), playerAddRequest.getName(), playerAddRequest.getTeamId(), playerAddRequest.getRole().name().toLowerCase());
    }
}
