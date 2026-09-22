package com.damini.evoting.service;

import com.damini.evoting.entity.Vote;
import com.damini.evoting.repository.VoteRepository;
import com.damini.evoting.repository.VoterRepository;
import com.damini.evoting.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    public VoteService(VoteRepository voteRepository,
                       VoterRepository voterRepository,
                       CandidateRepository candidateRepository) {

        this.voteRepository = voteRepository;
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    public Vote castVote(Vote vote) {

        // Check whether voter exists
        if (!voterRepository.existsById(vote.getVoterId())) {
            throw new RuntimeException("Voter does not exist");
        }

        // Check whether candidate exists
        if (!candidateRepository.existsById(vote.getCandidateId())) {
            throw new RuntimeException("Candidate does not exist");
        }

        // Check whether voter has already voted
        if (voteRepository.existsByVoterId(vote.getVoterId())) {
            throw new RuntimeException("Voter has already voted");
        }

        return voteRepository.save(vote);
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public long getVoteCount(Long candidateId) {
        return voteRepository.countByCandidateId(candidateId);
    }
}