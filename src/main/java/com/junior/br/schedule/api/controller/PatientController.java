package com.junior.br.schedule.api.controller;

import com.junior.br.schedule.api.dtos.request.PatientRequest;
import com.junior.br.schedule.api.dtos.response.PatientResponse;
import com.junior.br.schedule.domain.service.ServiceManager;
import jakarta.validation.Valid;
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
    private final ServiceManager serviceManger;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> listAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(this.serviceManger.getPatientService().listAllPatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findPatientById(@PathVariable Long id) {
        PatientResponse response = this.serviceManger.getPatientService().findPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<PatientResponse> insertPatient(@Valid @RequestBody PatientRequest request) {
        PatientResponse response = this.serviceManger.getPatientService().insertPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientRequest request) {
        PatientResponse response = this.serviceManger.getPatientService().updatePatient(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long id) {
        this.serviceManger.getPatientService().deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
