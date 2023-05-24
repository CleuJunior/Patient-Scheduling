package com.junior.br.schedule.api.controller;

import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.domain.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> listAllPatients() {
        List<Patient> response = this.service.listAllPatient();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<Patient> insertPatient(@RequestBody Patient patient) {
        Patient response =  this.service.insert(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}