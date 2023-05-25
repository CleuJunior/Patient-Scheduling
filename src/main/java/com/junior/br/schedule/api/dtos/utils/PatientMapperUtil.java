package com.junior.br.schedule.api.dtos.utils;

import com.junior.br.schedule.api.dtos.request.PatientRequest;
import com.junior.br.schedule.api.dtos.response.PatientResponse;
import com.junior.br.schedule.domain.entity.Patient;

public class PatientMapperUtil {

    private PatientMapperUtil(){
    }

    public static Patient toPatient(PatientRequest reqPatient) {
        return new Patient(
                reqPatient.name(),
                reqPatient.lastName(),
                reqPatient.email(),
                reqPatient.cpf()
        );
    }

    public static PatientResponse toPatientResponse(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getCpf()
        );
    }

}
