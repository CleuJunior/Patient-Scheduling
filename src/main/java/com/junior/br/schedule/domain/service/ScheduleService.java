package com.junior.br.schedule.domain.service;

import com.junior.br.schedule.api.dtos.response.ScheduleResponse;
import com.junior.br.schedule.api.dtos.utils.ScheduleMapperUtil;
import com.junior.br.schedule.domain.entity.Patient;
import com.junior.br.schedule.domain.entity.Schedule;
import com.junior.br.schedule.domain.repository.PatientRepository;
import com.junior.br.schedule.domain.repository.ScheduleRepository;
import com.junior.br.schedule.excepetion.BusinessException;
import com.junior.br.schedule.excepetion.ExceptionConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository schedulerepository;
    private final PatientRepository patientRepository;

    public List<ScheduleResponse> listAllSchedules() {
        return this.schedulerepository.findAll().stream()
                .map(ScheduleMapperUtil::toScheduleResponse)
                .toList();
    }
    public Schedule insertSchedule(Schedule schedule) {
        Optional<Patient> optionalPatient = this.patientRepository.findById(schedule.getPatient().getId());

        if (optionalPatient.isEmpty()) {
            throw new BusinessException(ExceptionConstants.PATIENT_NOT_FOUND);
        }

        Optional<Schedule> optDate = this.schedulerepository.findByTime(schedule.getDateCreation());

        if (optDate.isPresent()) {
            throw new BusinessException(ExceptionConstants.ALREADY_APPOINTMENT_TIME);
        }

        schedule.setPatient(optionalPatient.get());
        schedule.setDateCreation(LocalDateTime.now());

        return this.schedulerepository.save(schedule);
    }

}
