package com.damini.evoting.controller;

import com.damini.evoting.entity.Vote;
import com.damini.evoting.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<?> castVote(@RequestBody Vote vote) {

        try {
            Vote savedVote = voteService.castVote(vote);
            return ResponseEntity.ok(savedVote);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @GetMapping("/count/{candidateId}")
    public long getVoteCount(@PathVariable Long candidateId) {
        return voteService.getVoteCount(candidateId);
    }
}