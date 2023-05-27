package com.junior.br.schedule.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public class ServiceManager {
    private final PatientService patientService;
    private final ScheduleService scheduleService;
}
