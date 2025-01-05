package com.cricket.csc.dto;

import com.cricket.csc.model.enums.MatchStatus;

public class MatchStatusRequest {
    private String status;

    public MatchStatus getStatus() {
        return MatchStatus.valueOf(status.toUpperCase());
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}
