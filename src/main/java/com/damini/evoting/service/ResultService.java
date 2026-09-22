package com.damini.evoting.service;

import com.damini.evoting.entity.Candidates;
import com.damini.evoting.repository.CandidateRepository;
import com.damini.evoting.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResultService {

    private final CandidateRepository candidateRepository;
    private final VoteRepository voteRepository;

    public ResultService(CandidateRepository candidateRepository,
                         VoteRepository voteRepository) {
        this.candidateRepository = candidateRepository;
        this.voteRepository = voteRepository;
    }

    public List<Map<String, Object>> getElectionResults() {

        List<Candidates> candidates = candidateRepository.findAll();

        List<Map<String, Object>> results = new ArrayList<>();

        for (Candidates candidate : candidates) {

            long voteCount =
                    voteRepository.countByCandidateId(candidate.getId());

            Map<String, Object> result = new HashMap<>();

            result.put("candidateId", candidate.getId());
            result.put("candidateName", candidate.getName());
            result.put("party", candidate.getParty());
            result.put("votes", voteCount);

            results.add(result);
        }

        return results;
    }
}