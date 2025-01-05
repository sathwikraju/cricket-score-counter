package com.cricket.csc.service;

import com.cricket.csc.dto.MatchStatusRequest;
import com.cricket.csc.dto.MatchStatusResponse;
import com.cricket.csc.model.Match;
import com.cricket.csc.model.Team;
import com.cricket.csc.dto.MatchRequest;
import com.cricket.csc.dto.MatchResponse;
import com.cricket.csc.model.enums.MatchStatus;
import com.cricket.csc.repository.MatchRepository;
import com.cricket.csc.repository.TeamRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public MatchResponse createMatch(MatchRequest matchRequest) {

        Team team1 = teamRepository.findById(matchRequest.getTeam1Id()).orElseThrow(() -> new IllegalArgumentException("Team1 not found with id: " + matchRequest.getTeam1Id()));
        Team team2 = teamRepository.findById(matchRequest.getTeam2Id()).orElseThrow(() -> new IllegalArgumentException("Team2 not found with id: " + matchRequest.getTeam2Id()));

        Match match = Match
                .builder()
                .team1(team1)
                .team2(team2)
                .date(matchRequest.getDate())
                .location(matchRequest.getLocation())
                .status(MatchStatus.SCHEDULED)
                .build();

//        Innings innings1 = Innings.builder()
//                .match(match)
//                .team(team1)
//                .runs(0)
//                .wickets(0)
//                .overs(0.0)
//                .build();
//
//        Innings innings2 = Innings.builder()
//                .match(match)
//                .team(team2)
//                .runs(0)
//                .wickets(0)
//                .overs(0.0)
//                .build();
//
//        match.setInnings(List.of(innings1, innings2));
        Match savedMatch = matchRepository.save(match);

        return new MatchResponse(savedMatch.getId(), team1.getName(), team2.getName(), savedMatch.getDate(), savedMatch.getLocation(), savedMatch.getStatus());
    }

    public MatchResponse getMatchDetails(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("match not found with id: " + id));
        return new MatchResponse(match.getId(), match.getTeam1().getName(), match.getTeam2().getName(), match.getDate(), match.getLocation(), match.getStatus());
    }

    public List<MatchResponse> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream().map(match ->
                new MatchResponse(match.getId(), match.getTeam1().getName(), match.getTeam2().getName(), match.getDate(), match.getLocation(), match.getStatus())).toList();
    }


    public MatchStatusResponse setMatchStatus(Long id, MatchStatusRequest matchStatusRequest) {
        Match match = matchRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("match not found with id: " + id));
        match.setStatus(matchStatusRequest.getStatus());
        matchRepository.save(match);
        return new MatchStatusResponse(match.getId(), match.getStatus().name().toLowerCase());
    }
}
