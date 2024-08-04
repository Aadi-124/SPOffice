package com.Backend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.Backend.Entities.SubPatrolling;
import com.Backend.Repository.SubPatrollingRepository;

@Service
public class SubPatrollingService {

    private final SubPatrollingRepository subPatrollingRepository;

    @Autowired
    public SubPatrollingService(SubPatrollingRepository subPatrollingRepository){
        this.subPatrollingRepository = subPatrollingRepository;
    }

    public List<SubPatrolling> getAllSubPatrollings(){
        try {
            return subPatrollingRepository.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Optional<SubPatrolling> getSubPatrollingById(Long id) {
        try {
            return subPatrollingRepository.findById(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SubPatrolling createSubPatrolling(SubPatrolling subPatrolling) {
        try {
            return subPatrollingRepository.save(subPatrolling);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SubPatrolling updateSubPatrolling(Long id, SubPatrolling updatedSubPatrolling) {
        try {
            return subPatrollingRepository.findById(id)
                .map(subPatrolling -> {
                    return subPatrollingRepository.save(subPatrolling);
                })
                .orElseGet(() -> {
                    updatedSubPatrolling.setId(id);
                    return subPatrollingRepository.save(updatedSubPatrolling);
                });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update admin", e);
        }
    }

    public boolean deleteSubPatrolling(Long id) {
        try {
            subPatrollingRepository.deleteById(id);
            return true;
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete admin", e);
        }
    }

}
