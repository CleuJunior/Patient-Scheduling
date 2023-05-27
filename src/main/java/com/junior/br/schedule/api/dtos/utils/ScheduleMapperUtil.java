package com.junior.br.schedule.api.dtos.utils;

import com.junior.br.schedule.api.dtos.request.ScheduleRequest;
import com.junior.br.schedule.api.dtos.response.ScheduleResponse;
import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.domain.entity.Schedule;

import java.time.LocalDateTime;

public class ScheduleMapperUtil {

    private ScheduleMapperUtil(){
    }

    public static Schedule toSchedule(ScheduleRequest reqSchedule, Patient patient) {
        Schedule schedule = new Schedule(reqSchedule.description(), reqSchedule.time(), patient);
        schedule.setDateCreation(LocalDateTime.now());
        return schedule;
    }

    public static ScheduleResponse toScheduleResponse(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getDescription(),
                schedule.getTime(),
                schedule.getDateCreation(),
                PatientMapperUtil.toPatientResponse(schedule.getPatient())
        );
    }
}
