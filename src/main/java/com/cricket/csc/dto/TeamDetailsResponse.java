package com.cricket.csc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeamDetailsResponse {
    private Long id;
    private String name;
    private List<PlayerResponse> players;
}
