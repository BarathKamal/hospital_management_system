package com.bridgelabz.hospital_management_system.mapper;

import com.bridgelabz.hospital_management_system.dto.PatientDto;
import com.bridgelabz.hospital_management_system.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Patient toEntity(PatientDto patientDto) {
        Patient patient = new Patient(
                patientDto.getName(),
                patientDto.getAge(),
                patientDto.getGender(),
                patientDto.getDisease(),
                patientDto.getAddress(),
                patientDto.getPhoneNumber()
        );

        return patient;
    }

    public PatientDto toDto(Patient patient) {
        PatientDto patientDto = new PatientDto(
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getDisease(),
                patient.getAddress(),
                patient.getPhoneNumber()
        );

        return patientDto;
    }
}
