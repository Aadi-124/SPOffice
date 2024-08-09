package com.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.Entities.Patrolling;

public interface PatrollingRepository extends JpaRepository<Patrolling, Long> {

}
