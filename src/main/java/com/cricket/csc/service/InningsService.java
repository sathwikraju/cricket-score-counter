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
        Team battingTeam = teamRepository.findById(inningsRequest.getBattingTeamId()).orElseThrow(() -> new IllegalArgumentException("team not found with id: " + inningsRequest.getBattingTeamId()));
        Team bowlingTeam = teamRepository.findById(inningsRequest.getBowlingTeamId()).orElseThrow(() -> new IllegalArgumentException("team not found with id: " + inningsRequest.getBowlingTeamId()));

        Innings innings = Innings.builder()
                .match(match)
                .battingTeam(battingTeam)
                .bowlingTeam(bowlingTeam)
                .runs(0)
                .wickets(0)
                .overs(0.0)
                .build();
        Innings savedInnings = inningsRepository.save(innings);

        return new InningsResponse(savedInnings.getId(), inningsRequest.getMatchId(), battingTeam.getName(), bowlingTeam.getName(), savedInnings.getRuns(), savedInnings.getWickets(), savedInnings.getOvers());
    }
}
