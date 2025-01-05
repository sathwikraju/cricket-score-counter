package com.cricket.csc.dto;

import com.cricket.csc.model.enums.MatchStatus;
import lombok.Setter;

@Setter
public class MatchStatusRequest {
    private String status;

    public MatchStatus getStatus() {
        return MatchStatus.valueOf(status.toUpperCase());
    }


}
