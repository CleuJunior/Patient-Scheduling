package com.junior.br.schedule.api.controller;

import com.junior.br.schedule.api.dtos.request.PatientRequest;
import com.junior.br.schedule.api.dtos.response.PatientResponse;
import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.domain.service.PatientService;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService service;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> listAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findPatientById(@PathVariable Long id) {
        PatientResponse response = this.service.findPatientById(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<PatientResponse> insertPatient(@RequestBody Patient request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.insert(request));
    }

    @PutMapping
    public ResponseEntity<PatientResponse> updatePatient(@RequestBody Patient request) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.insert(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        this.service.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
