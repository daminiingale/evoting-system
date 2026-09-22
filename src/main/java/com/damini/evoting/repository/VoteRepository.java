package com.damini.evoting.repository;

import com.damini.evoting.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoterId(Long voterId);
    long countByCandidateId(Long candidateId);
}