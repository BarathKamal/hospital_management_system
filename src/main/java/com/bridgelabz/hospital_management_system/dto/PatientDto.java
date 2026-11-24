package com.bridgelabz.hospital_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientDto {
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String address;
    private String phoneNumber;
}
