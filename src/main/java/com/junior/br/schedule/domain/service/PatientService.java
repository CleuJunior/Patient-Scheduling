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
        return this.repository.findAll().stream()
                .map(PatientMapperUtil::toPatientResponse)
                .toList();
    }

    public PatientResponse findPatientById(Long id) {
        Patient patient = this.repository.findById(id).orElseThrow(RuntimeException::new);
        return PatientMapperUtil.toPatientResponse(patient);
    }

    public PatientResponse insertPatient(PatientRequest patient) {
        Optional<Patient> optPatientByCPF = this.repository.findByCpf(patient.cpf());

        if (optPatientByCPF.isPresent()) {
            throw new BusinessException("CPF já cadastrado");
        }

        Patient patientToInsert = PatientMapperUtil.toPatient(patient);
        this.repository.save(patientToInsert);

        return PatientMapperUtil.toPatientResponse(patientToInsert);
    }

    public PatientResponse updatePatient(Long id, PatientRequest patient) {
        Optional<Patient> optPatientByCPF = this.repository.findByCpf(patient.cpf());
        Patient optPatient = this.repository.findById(id).orElseThrow(RuntimeException::new);

        if (optPatientByCPF.isPresent() && !optPatient.getCpf().equals(optPatientByCPF.get().getCpf())) {
            throw new BusinessException("CPF já cadastrado");
        }

        PatientMapperUtil.updatePatient(patient, optPatient);
        this.repository.save(optPatient);

        return PatientMapperUtil.toPatientResponse(optPatient);
    }

    public void deletePatient(Long id) {
        this.repository.deleteById(id);
    }
}
