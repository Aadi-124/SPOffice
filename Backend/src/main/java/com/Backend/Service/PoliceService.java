package com.Backend.Service;

import com.Backend.Entities.Police;
import com.Backend.Repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceService {

    @Autowired
    private PoliceRepository policeRepository;

    // Get all Police
    public List<Police> getAllPolices() {
        try {
            return policeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all polices", e);
        }
    }

    // Get Police by ID
    public Optional<Police> getPoliceById(Long id) {
        try {
            return policeRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching police by ID", e);
        }
    }

    // Create a new Police
    public Police createPolice(Police police) {
        try {
            return policeRepository.save(police);
        } catch (Exception e) {
            throw new RuntimeException("Error creating police", e);
        }
    }

    // Update Police
    public Police updatePolice(Long id, Police policeDetails) {
        try {
            Optional<Police> police = policeRepository.findById(id);
            if (police.isPresent()) {
                Police existingPolice = police.get();
                existingPolice.setFullname(policeDetails.getFullname());
                existingPolice.setPoliceId(policeDetails.getPoliceId());
                existingPolice.setPhone(policeDetails.getPhone());
                existingPolice.setEmail(policeDetails.getEmail());
                existingPolice.setDesignation(policeDetails.getDesignation());
                existingPolice.setSubadmin(policeDetails.getSubadmin());
                return policeRepository.save(existingPolice);
            }
            throw new RuntimeException("Police not found");
        } catch (Exception e) {
            throw new RuntimeException("Error updating police", e);
        }
    }

    // Delete Police
    public boolean deletePolice(Long id) {
        try {
            Optional<Police> police = policeRepository.findById(id);
            if (police.isPresent()) {
                policeRepository.delete(police.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting police", e);
        }
    }
}
