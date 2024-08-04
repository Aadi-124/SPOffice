package com.Backend.Repository;

import com.Backend.Entities.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceRepository extends JpaRepository<Police, Long> {
}
