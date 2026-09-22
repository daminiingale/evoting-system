package com.damini.evoting.controller;

import com.damini.evoting.entity.Candidates;
import com.damini.evoting.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public Candidates addCandidate(@RequestBody Candidates candidate) {
        return candidateService.addCandidate(candidate);
    }

    @GetMapping
    public List<Candidates> getAllCandidates() {
        return candidateService.getAllCandidates();
    }
}