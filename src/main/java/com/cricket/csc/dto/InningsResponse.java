package com.cricket.csc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InningsResponse {
    private Long id;
    private Long matchId;
    private Long teamId;
    private Integer runs;
    private Integer wickets;
    private Double overs;
}
