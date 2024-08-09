package com.Backend.Service;

import com.Backend.Entities.Patrolling;
import com.Backend.Repository.PatrollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrollingService {

    @Autowired
    private PatrollingRepository patrollingRepository;

    public List<Patrolling> getAllPatrollings() {
        return patrollingRepository.findAll();
    }

    public Optional<Patrolling> getPatrollingById(Long id) {
        return patrollingRepository.findById(id);
    }

    public Patrolling createPatrolling(Patrolling patrolling) {
        return patrollingRepository.save(patrolling);
    }

    public Patrolling updatePatrolling(Long id, Patrolling updatedPatrolling) {
        try {
            return patrollingRepository.findById(id)
                    .map(existingPatrolling -> {
                        existingPatrolling.setAdmin(updatedPatrolling.getAdmin());
                        existingPatrolling.setHead(updatedPatrolling.getHead());
                        existingPatrolling.setDate(updatedPatrolling.getDate());
                        existingPatrolling.setSubPatrollings(updatedPatrolling.getSubPatrollings());
                        return patrollingRepository.save(existingPatrolling);
                    })
                    .orElseGet(() -> {
                        updatedPatrolling.setId(id);
                        return patrollingRepository.save(updatedPatrolling);
                    });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update Patrolling", e);
        }
    }

    public boolean deletePatrolling(Long id) {
        try {
            patrollingRepository.deleteById(id);
            return true;
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete Patrolling", e);
        }
    }
}
