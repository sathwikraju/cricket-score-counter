package com.cricket.csc.service;

import com.cricket.csc.dto.PlayerResponse;
import com.cricket.csc.dto.TeamCreationResponse;
import com.cricket.csc.dto.TeamDetailsResponse;
import com.cricket.csc.dto.TeamRequest;
import com.cricket.csc.model.Team;
import com.cricket.csc.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamCreationResponse createTeam(TeamRequest teamRequest) {
        Team team = Team.builder()
                .name(teamRequest.getName())
                .build();
        Team savedTeam = teamRepository.save(team);
        return new TeamCreationResponse(savedTeam.getId(), savedTeam.getName());
    }

    public TeamDetailsResponse getTeamDetails(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found with id: " + id));
        List<PlayerResponse> players = team.getPlayers().stream().map(player -> new PlayerResponse(player.getId(), player.getName())).toList();
        return new TeamDetailsResponse(id, team.getName(), players);
    }
}
