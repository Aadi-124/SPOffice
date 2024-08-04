package com.Backend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.Backend.Entities.Patrolling;
import com.Backend.Repository.PatrollingRepository;

@Service
public class PatrollingService {

    private final PatrollingRepository patrollingRepository;

    @Autowired
    public PatrollingService(PatrollingRepository patrollingRepository){
        this.patrollingRepository = patrollingRepository;
    }

    public List<Patrolling> getAllPatrollings(){
        try {
            return patrollingRepository.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Optional<Patrolling> getPatrollingById(Long id) {
        try {
            return patrollingRepository.findById(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Patrolling createPatrolling(Patrolling patrolling) {
        try {
            return patrollingRepository.save(patrolling);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Patrolling updatePatrolling(Long id, Patrolling updatedPatrolling) {
        try {
            return patrollingRepository.findById(id)
                .map(patrolling -> {
                    return patrollingRepository.save(patrolling);
                })
                .orElseGet(() -> {
                    updatedPatrolling.setId(id);
                    return patrollingRepository.save(updatedPatrolling);
                });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update patrolling", e);
        }
    }

    public boolean deletePatrolling(Long id) {
        try {
            patrollingRepository.deleteById(id);
            return true;
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete patrolling", e);
        }
    }

}
