package com.cricket.csc.controller;

import com.cricket.csc.dto.PlayerAddRequest;
import com.cricket.csc.dto.PlayerAddResponse;
import com.cricket.csc.dto.PlayerResponse;
import com.cricket.csc.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/api/players")
    public PlayerAddResponse addPlayer(@RequestBody PlayerAddRequest playerAddRequest) {
        return playerService.addPlayer(playerAddRequest);
    }

    @GetMapping("/api/players/{id}")
    public PlayerAddResponse getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/api/teams/{id}/players")
    public List<PlayerResponse> getPlayersByTeamId(@PathVariable Long id) {
        return playerService.getPlayerByTeamId(id);
    }
}
