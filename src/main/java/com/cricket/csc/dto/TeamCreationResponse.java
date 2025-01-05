package com.cricket.csc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamCreationResponse {
    private Long id;
    private String name;
    private String location;
}
