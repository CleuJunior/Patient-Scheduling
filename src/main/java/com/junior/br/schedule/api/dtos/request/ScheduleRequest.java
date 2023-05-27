package com.junior.br.schedule.api.dtos.request;

import com.junior.br.schedule.domain.entity.Patient;

import java.time.LocalDateTime;

public record ScheduleRequest(
        LocalDateTime time,
        LocalDateTime dateCreation,
        Patient patient
) {}
