package com.damini.evoting.repository;

import com.damini.evoting.entity.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidates, Long> {
}