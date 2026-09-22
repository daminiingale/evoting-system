package com.damini.evoting.service;

import com.damini.evoting.entity.voter;
import com.damini.evoting.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public voter registerVoter(voter voter) {
        return voterRepository.save(voter);
    }

    public List<voter> getAllVoters() {
        return voterRepository.findAll();
    }
}