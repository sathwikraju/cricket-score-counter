package com.cricket.csc.dto;

import com.cricket.csc.model.enums.MatchStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MatchResponse {
    private Long id;
    private String team1;
    private String team2;
    private LocalDate date;
    private String location;
    private String status;

    public MatchResponse(Long id, String team1, String team2, LocalDate date, String location, MatchStatus status) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.location = location;
        this.status = status.name().toLowerCase();
    }
}
