package com.cricket.csc.dto;

import com.cricket.csc.model.enums.PlayerRole;
import lombok.Data;

@Data
public class PlayerAddRequest {

    private String name;
    private Long teamId;
    private String role;

    public PlayerRole getRole() {
        return PlayerRole.valueOf(role.toUpperCase());
    }
}
