package com.bridgelabz.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String disease;

    @Column(nullable = false)
    private String address;

    @Column(length = 15,nullable = false)
    private String phoneNumber;

    public Patient(String name, int age, String gender, String disease, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}

