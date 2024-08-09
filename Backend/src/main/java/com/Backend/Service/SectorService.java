package com.Backend.Service;

import com.Backend.Entities.Sector;
import com.Backend.Repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    public Optional<Sector> getSectorById(Long id) {
        return sectorRepository.findById(id);
    }

    public Sector createSector(Sector sector) {
        return sectorRepository.save(sector);
    }

    public Sector updateSector(Long id, Sector updatedSector) {
        try {
            return sectorRepository.findById(id)
                .map(sector -> {
                    sector.setName(updatedSector.getName());
                    sector.setHead(updatedSector.getHead());
                    sector.setArea(updatedSector.getArea());
                    sector.setLocations(updatedSector.getLocations());
                    return sectorRepository.save(sector);
                })
                .orElseGet(() -> {
                    updatedSector.setId(id);
                    return sectorRepository.save(updatedSector);
                });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update sector", e);
        }
    }

    public boolean deleteSector(Long id) {
        try {
            if (sectorRepository.existsById(id)) {
                sectorRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to delete sector", e);
        }
    }
}
