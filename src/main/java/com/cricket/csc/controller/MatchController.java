package com.cricket.csc.controller;

import org.springframework.web.bind.annotation.RestController;
import com.cricket.csc.repository.MatchRepository;

@RestController
public class MatchController {

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }


    // create match
    // POST /api/matches

    // get match details
    // GET /api/matches/{id}

    // list all matches
    // GET /api/matches

    // update match status
    // PUT /api/matches/{id}
}
