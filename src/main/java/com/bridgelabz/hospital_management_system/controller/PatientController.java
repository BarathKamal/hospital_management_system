package com.bridgelabz.hospital_management_system.controller;

import com.bridgelabz.hospital_management_system.dto.PatientDto;
import com.bridgelabz.hospital_management_system.entity.Patient;
import com.bridgelabz.hospital_management_system.service.PatientService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// uc7:create controller layer
@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // Add Patient
    @PostMapping
    public ResponseEntity<Patient> addPatient(
            @RequestBody PatientDto patientDto) {

        return ResponseEntity.ok(
                patientService.createPatient(patientDto)
        );
    }

    // Get All Patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {

        return ResponseEntity.ok(
                patientService.getAllPatients()
        );
    }

    // Get Patient By ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(
            @PathVariable int id) {

        Optional<Patient> patient =
                patientService.getPatientById(id);

        return patient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable int id,
            @RequestBody PatientDto patientDto) {

        return ResponseEntity.ok(
                patientService.updatePatient(id, patientDto)
        );
    }

    // Delete Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(
            @PathVariable int id) {

        patientService.deletePatient(id);

        return ResponseEntity.noContent().build();
    }
}
