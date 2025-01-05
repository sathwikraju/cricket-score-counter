package com.cricket.csc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchStatusResponse {
    private Long id;
    private String status;
}
