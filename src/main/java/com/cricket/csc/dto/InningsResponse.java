package com.cricket.csc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InningsResponse {
    private Long id;
    private Long matchId;
    private String battingTeam;
    private String bowlingTeam;
    private Integer runs;
    private Integer wickets;
    private Double overs;
}
