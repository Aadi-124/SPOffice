package com.Backend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.Backend.Entities.Subadmin;
import com.Backend.Repository.SubadminRepository;

@Service
public class SubadminService {

    private final SubadminRepository subadminRepository;

    @Autowired
    public SubadminService(SubadminRepository subadminRepository){
        this.subadminRepository = subadminRepository;
    }

    public List<Subadmin> getAllSubadmins(){
        try {
            return subadminRepository.findAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Optional<Subadmin> getSubadminById(Long id) {
        try {
            return subadminRepository.findById(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Subadmin createSubadmin(Subadmin subadmin) {
        try {
            return subadminRepository.save(subadmin);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Subadmin updateSubadmin(Long id, Subadmin updatedSubadmin) {
        try {
            return subadminRepository.findById(id)
                .map(subadmin -> {
                    subadmin.setUsername(updatedSubadmin.getUsername());
                    subadmin.setPassword(updatedSubadmin.getPassword());
                    subadmin.setContact(updatedSubadmin.getContact());
                    subadmin.setStation(updatedSubadmin.getStation());
                    return subadminRepository.save(subadmin);
                })
                .orElseGet(() -> {
                    updatedSubadmin.setId(id);
                    return subadminRepository.save(updatedSubadmin);
                });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update admin", e);
        }
    }

    public boolean deleteSubadmin(Long id) {
        try {
            subadminRepository.deleteById(id);
            return true;
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete admin", e);
        }
    }

}
