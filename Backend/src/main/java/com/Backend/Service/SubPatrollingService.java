package com.Backend.Service;

import com.Backend.Entities.SubPatrolling;
import com.Backend.Repository.SubPatrollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubPatrollingService {

    @Autowired
    private SubPatrollingRepository subPatrollingRepository;

    // Get all SubPatrollings
    public List<SubPatrolling> getAllSubPatrollings() {
        return subPatrollingRepository.findAll();
    }

    // Get SubPatrolling by ID
    public Optional<SubPatrolling> getSubPatrollingById(Long id) {
        return subPatrollingRepository.findById(id);
    }

    // Create a new SubPatrolling
    public SubPatrolling createSubPatrolling(SubPatrolling subPatrolling) {
        try {
            return subPatrollingRepository.save(subPatrolling);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to create SubPatrolling", e);
        }
    }

    // Update SubPatrolling
    public SubPatrolling updateSubPatrolling(Long id, SubPatrolling updatedSubPatrolling) {
        try {
            return subPatrollingRepository.findById(id)
                    .map(subPatrolling -> {
                        // Update fields
                        subPatrolling.setHead(updatedSubPatrolling.getHead());
                        subPatrolling.setCohead(updatedSubPatrolling.getCohead());
                        subPatrolling.setDescription(updatedSubPatrolling.getDescription());
                        subPatrolling.setInstructions(updatedSubPatrolling.getInstructions());
                        subPatrolling.setPatrolling(updatedSubPatrolling.getPatrolling());
                        subPatrolling.setAreas(updatedSubPatrolling.getAreas());

                        return subPatrollingRepository.save(subPatrolling);
                    })
                    .orElseGet(() -> {
                        updatedSubPatrolling.setId(id);
                        return subPatrollingRepository.save(updatedSubPatrolling);
                    });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update SubPatrolling", e);
        }
    }

    // Delete SubPatrolling
    public boolean deleteSubPatrolling(Long id) {
        try {
            if (subPatrollingRepository.existsById(id)) {
                subPatrollingRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete SubPatrolling", e);
        }
    }
}
