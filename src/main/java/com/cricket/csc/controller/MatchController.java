package com.cricket.csc.controller;

import com.cricket.csc.dto.MatchRequest;
import com.cricket.csc.dto.MatchResponse;
import com.cricket.csc.dto.MatchStatusRequest;
import com.cricket.csc.dto.MatchStatusResponse;
import com.cricket.csc.model.enums.MatchStatus;
import com.cricket.csc.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }


    // create match
    // POST /api/matches
    @PostMapping("/api/matches")
    public MatchResponse createMatch(@RequestBody MatchRequest matchRequest) {
        return matchService.createMatch(matchRequest);
    }


    // get  match details
    // GET /api/matches/{id}
    @GetMapping("/api/matches/{id}")
    public MatchResponse getMatchDetails(@PathVariable Long id) {
        return matchService.getMatchDetails(id);
    }

    // list all matches
    // GET /api/matches
    @GetMapping("/api/matches")
    public List<MatchResponse> getAllMatches() {
        return matchService.getAllMatches();
    }

    // update match status
    // PUT /api/matches/{id}
    @PutMapping("/api/matches/{id}")
    public MatchStatusResponse setMatchStatus(@PathVariable Long id, @RequestBody MatchStatusRequest matchStatusRequest) {
        return matchService.setMatchStatus(id, matchStatusRequest);
    }
}
