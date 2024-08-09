package com.Backend.Controller;

import com.Backend.Entities.Sector;
import com.Backend.Service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    // Get all sectors
    @GetMapping
    public ResponseEntity<List<Sector>> getAllSectors() {
        List<Sector> sectors = sectorService.getAllSectors();
        return ResponseEntity.ok(sectors);
    }

    // Get sector by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id) {
        Optional<Sector> sector = sectorService.getSectorById(id);
        return sector.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new sector
    @PostMapping
    public ResponseEntity<Sector> createSector(@RequestBody Sector sector) {
        Sector createdSector = sectorService.createSector(sector);
        return ResponseEntity.ok(createdSector);
    }

    // Update sector
    @PutMapping("/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable Long id, @RequestBody Sector sectorDetails) {
        Sector updatedSector = sectorService.updateSector(id, sectorDetails);
        return ResponseEntity.ok(updatedSector);
    }

    // Delete sector
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        boolean deleted = sectorService.deleteSector(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
