package com.cricket.csc.controller;

import com.cricket.csc.dto.TeamCreationResponse;
import com.cricket.csc.dto.TeamDetailsResponse;
import com.cricket.csc.dto.TeamRequest;
import com.cricket.csc.service.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    public TeamCreationResponse createTeam(@RequestBody TeamRequest teamRequest) {
        return teamService.createTeam(teamRequest);
    }

    @GetMapping("/teams/{id}")
    public TeamDetailsResponse getTeamDetails(@PathVariable Long id) {
        return teamService.getTeamDetails(id);
    }
}
