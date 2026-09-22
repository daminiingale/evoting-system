package com.damini.evoting.controller;

import com.damini.evoting.entity.voter;
import com.damini.evoting.service.VoterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @PostMapping
    public voter registerVoter(@RequestBody voter voter) {
        return voterService.registerVoter(voter);
    }

    @GetMapping
    public List<voter> getAllVoters() {
        return voterService.getAllVoters();
    }
}