package com.cricket.csc.controller;

import com.cricket.csc.dto.InningsRequest;
import com.cricket.csc.dto.InningsResponse;
import com.cricket.csc.service.InningsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InningsController {

    private final InningsService inningsService;

    public InningsController(InningsService inningsService) {
        this.inningsService = inningsService;
    }

    @PostMapping("/api/innings")
    private InningsResponse startInnings(@RequestBody InningsRequest inningsRequest) {
        return inningsService.startInnings(inningsRequest);
    }
}
