package com.Backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Entities.SubPatrolling;
import com.Backend.Service.SubPatrollingService;

@RestController
@RequestMapping("/api/sub-patrollings")
public class SubPatrollingController {

    @Autowired
    private SubPatrollingService subPatrollingService;

    // Get all SubPatrollings
    @GetMapping
    public ResponseEntity<List<SubPatrolling>> getAllSubPatrollings() {
        try {
            List<SubPatrolling> subPatrollings = subPatrollingService.getAllSubPatrollings();
            return ResponseEntity.ok(subPatrollings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get SubPatrolling by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubPatrolling> getSubPatrollingById(@PathVariable Long id) {
        try {
            Optional<SubPatrolling> subpatrolling = subPatrollingService.getSubPatrollingById(id);
            return subpatrolling.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Create a new SubPatrolling
    @PostMapping
    public ResponseEntity<SubPatrolling> createSubPatrolling(@RequestBody SubPatrolling subPatrolling) {
        try {
            SubPatrolling createdSubPatrolling = subPatrollingService.createSubPatrolling(subPatrolling);
            return ResponseEntity.ok(createdSubPatrolling);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update SubPatrolling
    @PutMapping("/{id}")
    public ResponseEntity<SubPatrolling> updateSubPatrolling(@PathVariable Long id, @RequestBody SubPatrolling subPatrollingDetails) {
        try {
            SubPatrolling updatedSubPatrolling = subPatrollingService.updateSubPatrolling(id, subPatrollingDetails);
            return new ResponseEntity<>(updatedSubPatrolling, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete Subadmin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubPatrolling(@PathVariable Long id) {
        try {
            boolean deleted = subPatrollingService.deleteSubPatrolling(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
