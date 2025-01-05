package com.cricket.csc.service;

import com.cricket.csc.dto.PlayerAddRequest;
import com.cricket.csc.dto.PlayerAddResponse;
import com.cricket.csc.dto.PlayerResponse;
import com.cricket.csc.dto.TeamAddResponse;
import com.cricket.csc.model.Player;
import com.cricket.csc.model.Team;
import com.cricket.csc.repository.PlayerRepository;
import com.cricket.csc.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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
        return new PlayerAddResponse(player.getId(), playerAddRequest.getName(), playerAddRequest.getRole().name().toLowerCase(), new TeamAddResponse(team.getId(), team.getName()));
    }

    public PlayerAddResponse getPlayerById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
        Team team = teamRepository.findById(player.getTeam().getId()).orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + player.getTeam().getId()));
        return new PlayerAddResponse(player.getId(), player.getName(), player.getRole().name().toLowerCase(), new TeamAddResponse(team.getId(), team.getName()));
    }

    public List<PlayerResponse> getPlayerByTeamId(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));
        List<Player> players = playerRepository.findAll().stream().filter(player -> player.getTeam().equals(team)).toList();
        return players.stream().map(player -> new PlayerResponse(player.getId(), player.getName(), player.getRole().name().toLowerCase())).toList();
    }
}
