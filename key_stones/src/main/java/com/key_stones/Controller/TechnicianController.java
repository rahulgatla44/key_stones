
package com.key_stones.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.key_stones.Entity.Technician;
import com.key_stones.Service.TechnicianService;

@RestController
@RequestMapping("/api/technician")
public class TechnicianController {

    private final TechnicianService technicianService;

    // Constructor injection
    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    // Create Technician
    @PostMapping("/create")
    public ResponseEntity<Technician> createTechnician(
            @RequestBody Technician technician) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(technicianService.createTechnician(technician));
    }

    // Get Technician by ID
    @GetMapping("/{id}")
    public ResponseEntity<Technician> getTechnician(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                technicianService.getTechnician(id));
    }

    // Get All Technicians
    @GetMapping("/all")
    public ResponseEntity<List<Technician>> getAllTechnician() {

        return ResponseEntity.ok(
                technicianService.getAllTechnician());
    }

    // Update Technician
    @PutMapping("/update/{id}")
    public ResponseEntity<Technician> update(
            @PathVariable Long id,
            @RequestBody Technician technician) {

        return ResponseEntity.ok(
                technicianService.updateTechnician(id, technician));
    }

    // Delete Technician
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        technicianService.deleteTechnician(id);

        return ResponseEntity.ok("Technician deleted successfully");
    }
}
