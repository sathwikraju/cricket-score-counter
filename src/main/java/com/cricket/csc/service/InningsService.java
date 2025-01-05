package com.cricket.csc.service;

import com.cricket.csc.dto.InningsRequest;
import com.cricket.csc.dto.InningsResponse;
import com.cricket.csc.model.Innings;
import com.cricket.csc.model.Match;
import com.cricket.csc.model.Team;
import com.cricket.csc.repository.InningsRepository;
import com.cricket.csc.repository.MatchRepository;
import com.cricket.csc.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class InningsService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final InningsRepository inningsRepository;

    public InningsService(MatchRepository matchRepository, TeamRepository teamRepository, InningsRepository inningsRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.inningsRepository = inningsRepository;
    }


    public InningsResponse startInnings(InningsRequest inningsRequest) {

        Match match = matchRepository.findById(inningsRequest.getMatchId()).orElseThrow(() -> new IllegalArgumentException("match not found with id: " + inningsRequest.getMatchId()));
        Team team = teamRepository.findById(inningsRequest.getTeamId()).orElseThrow(() -> new IllegalArgumentException("team not found with id: " + inningsRequest.getMatchId()));

        Innings innings = Innings.builder()
                .match(match)
                .team(team)
                .runs(0)
                .wickets(0)
                .overs(0.0)
                .build();
        Innings savedInnings = inningsRepository.save(innings);

        return new InningsResponse(savedInnings.getId(), inningsRequest.getMatchId(), inningsRequest.getTeamId(), savedInnings.getRuns(), savedInnings.getWickets(), savedInnings.getOvers());
    }
}
