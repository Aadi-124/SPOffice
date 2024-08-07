package com.Backend.Service;

import com.Backend.Entities.Area;
import com.Backend.Repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<Area> getAllAreas() {
        return areaRepository.findAll();
    }

    public Optional<Area> getAreaById(Long id) {
        return areaRepository.findById(id);
    }

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    public Area updateArea(Long id, Area updatedArea) {
        try {
            return areaRepository.findById(id)
                .map(area -> {
                    area.setAreaName(updatedArea.getAreaName());
                    area.setHead(updatedArea.getHead());
                    area.setSubPatrolling(updatedArea.getSubPatrolling());
                    area.setSectors(updatedArea.getSectors());
                    return areaRepository.save(area);
                })
                .orElseGet(() -> {
                    updatedArea.setId(id);
                    return areaRepository.save(updatedArea);
                });
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to update area", e);
        }
    }

    public boolean deleteArea(Long id) {
        try {
            areaRepository.deleteById(id);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
