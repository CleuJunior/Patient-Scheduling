package com.junior.br.schedule.domain.service;

import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.excepetion.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.junior.br.schedule.domain.repository.PatientRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;

    public List<Patient> listAllPatient() {
        return this.repository.findAll();
    }

    public Optional<Patient> findPatientById(Long id) {
        return this.repository.findById(id);
    }

    public Patient insert(Patient patient) {
        boolean hasCpf = false;
        Optional<Patient> optPatient = this.repository.findByCpf(patient.getCpf());

        if (optPatient.isPresent() && !optPatient.get().getId().equals(patient.getId())) {
            hasCpf = true;
        }

        if (hasCpf) {
            throw new BusinessException("CPF já cadastrado");
        }

        return this.repository.save(patient);
    }

    public void deletePatient(Long id) {
        this.repository.deleteById(id);
    }
}
