package com.Backend.Controller;

import com.Backend.Entities.Area;
import com.Backend.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public ResponseEntity<List<Area>> getAllAreas() {
        List<Area> areas = areaService.getAllAreas();
        return ResponseEntity.ok(areas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable Long id) {
        Optional<Area> area = areaService.getAreaById(id);
        return area.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody Area area) {
        Area createdArea = areaService.createArea(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable Long id, @RequestBody Area areaDetails) {
        Area updatedArea = areaService.updateArea(id, areaDetails);
        return ResponseEntity.ok(updatedArea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Long id) {
        boolean deleted = areaService.deleteArea(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
