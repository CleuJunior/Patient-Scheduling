package com.junior.br.schedule.api.controller;

import com.junior.br.schedule.api.dtos.response.ScheduleResponse;
import com.junior.br.schedule.domain.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> listAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllSchedules());
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PatientResponse> findPatientById(@PathVariable Long id) {
//        PatientResponse response = this.service.findPatientById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<PatientResponse> insertPatient(@Valid @RequestBody PatientRequest request) {
//        PatientResponse response = this.service.insertPatient(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientRequest request) {
//        PatientResponse response = this.service.updatePatient(id, request);
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
//        this.service.deletePatient(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
