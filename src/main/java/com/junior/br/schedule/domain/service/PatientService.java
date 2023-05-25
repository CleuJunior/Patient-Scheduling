package com.junior.br.schedule.domain.service;

import com.junior.br.schedule.api.dtos.request.PatientRequest;
import com.junior.br.schedule.api.dtos.response.PatientResponse;
import com.junior.br.schedule.api.dtos.utils.PatientMapperUtil;
import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.domain.repository.PatientRepository;
import com.junior.br.schedule.excepetion.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;

    public List<PatientResponse> listAllPatient() {
        return this.repository.findAll().stream().map(PatientMapperUtil::toPatientResponse).toList();
    }

    public PatientResponse findPatientById(Long id) {
        Patient patient = this.repository.findById(id).orElseThrow(RuntimeException::new);
        return PatientMapperUtil.toPatientResponse(patient);
    }

    public PatientResponse insert(Patient patient) {
        boolean hasCpf = false;
        Optional<Patient> optPatient = this.repository.findByCpf(patient.getCpf());

        if (optPatient.isPresent() && !optPatient.get().getId().equals(patient.getId())) {
            hasCpf = true;
        }

        if (hasCpf) {
            throw new BusinessException("CPF já cadastrado");
        }

        this.repository.save(patient);
        return PatientMapperUtil.toPatientResponse(patient);
    }

    public void deletePatient(Long id) {
        this.repository.deleteById(id);
    }
}
