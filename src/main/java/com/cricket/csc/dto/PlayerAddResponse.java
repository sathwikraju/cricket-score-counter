package com.cricket.csc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerAddResponse {

    private Long id;
    private String name;
    private Long teamId;
    private String role;


}
