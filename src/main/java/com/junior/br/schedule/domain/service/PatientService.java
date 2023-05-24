package com.junior.br.schedule.domain.service;

import com.junior.br.schedule.domain.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.junior.br.schedule.domain.repository.PatientRepository;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;

    public List<Patient> listAllPatient() {
        return this.repository.findAll();
    }

    public Patient findPatientById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Patient insert(Patient patient) {
        return this.repository.save(patient);
    }

    public void deletePatient(Long id) {
        this.repository.deleteById(id);
    }
}
