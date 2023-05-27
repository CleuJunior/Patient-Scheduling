package com.junior.br.schedule.api.dtos.utils;

import com.junior.br.schedule.api.dtos.request.PatientRequest;
import com.junior.br.schedule.api.dtos.response.PatientResponse;
import com.junior.br.schedule.api.dtos.response.ScheduleResponse;
import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.domain.entity.Schedule;

public class ScheduleMapperUtil {

    private ScheduleMapperUtil(){
    }

    public static Patient toPatient(PatientRequest reqPatient) {
        return new Patient(
                reqPatient.name(),
                reqPatient.lastName(),
                reqPatient.email(),
                reqPatient.cpf()
        );
    }

    public static ScheduleResponse toScheduleResponse(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTime(),
                schedule.getDateCreation(),
                PatientMapperUtil.toPatientResponse(schedule.getPatient())
        );
    }

    public static void updatePatient(PatientRequest patientRequest, Patient patient) {
        patient.setName(patientRequest.name());
        patient.setLastName(patientRequest.lastName());
        patient.setEmail(patientRequest.email());
        patient.setCpf(patientRequest.cpf());
    }

}
