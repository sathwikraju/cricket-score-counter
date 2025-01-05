package com.cricket.csc.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MatchRequest {
    private Long team1Id;
    private Long team2Id;
    private LocalDate date;
    private String location;

}

