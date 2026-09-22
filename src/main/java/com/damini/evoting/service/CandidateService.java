package com.damini.evoting.service;

import com.damini.evoting.entity.Candidates;
import com.damini.evoting.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidates addCandidate(Candidates candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidates> getAllCandidates() {
        return candidateRepository.findAll();
    }
}