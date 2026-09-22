package com.damini.evoting.repository;

import com.damini.evoting.entity.voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<voter, Long> {
}
