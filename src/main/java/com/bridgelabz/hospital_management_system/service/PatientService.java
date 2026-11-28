package com.bridgelabz.hospital_management_system.service;

import com.bridgelabz.hospital_management_system.dto.PatientDto;
import com.bridgelabz.hospital_management_system.entity.Patient;
import com.bridgelabz.hospital_management_system.mapper.Mapper;
import com.bridgelabz.hospital_management_system.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final Mapper mapper;

    public Patient createPatient(PatientDto patientDto) {
        Patient patient = mapper.toEntity(patientDto);
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(int id, PatientDto patientDto) {
        Patient patient = mapper.toEntity(patientDto);

        Optional<Patient> existingPatientOptional = patientRepository.findById(id);

        if (existingPatientOptional.isEmpty()) {
            throw new RuntimeException("Patient with ID: " + patient.getId() + " not found");
        }

        Patient existingPatient = existingPatientOptional.get();

        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setDisease(patient.getDisease());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setPhoneNumber(patient.getPhoneNumber());

        return patientRepository.save(existingPatient);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
