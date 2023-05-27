package com.junior.br.schedule.api.dtos.response;

import com.junior.br.schedule.domain.entity.Patient;

import java.time.LocalDateTime;

public record ScheduleResponse(
        Long id,
        String description,
        LocalDateTime time,
        LocalDateTime dateCreation,
        PatientResponse patient
) {}
