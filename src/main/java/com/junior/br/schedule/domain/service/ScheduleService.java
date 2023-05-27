package com.junior.br.schedule.domain.service;

import com.junior.br.schedule.api.dtos.request.ScheduleRequest;
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

    public ScheduleResponse findScheduleById(Long id) {
        Schedule response = this.schedulerepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format(ExceptionConstants.ID_NOT_FOUND, id)));

        return ScheduleMapperUtil.toScheduleResponse(response);
    }
    public ScheduleResponse insertSchedule(ScheduleRequest schedule) {
        Patient patient = this.patientRepository.findById(schedule.patientId()).orElseThrow(
                () -> new BusinessException(ExceptionConstants.PATIENT_NOT_FOUND));

        Optional<Schedule> optDate = this.schedulerepository.findByTime(schedule.time());

        if (optDate.isPresent()) {
            throw new BusinessException(ExceptionConstants.ALREADY_APPOINTMENT_TIME);
        }

        Schedule scheduleToSave = ScheduleMapperUtil.toSchedule(schedule, patient);
        scheduleToSave = this.schedulerepository.save(scheduleToSave);

        return ScheduleMapperUtil.toScheduleResponse(scheduleToSave);
    }

    public void deleteScheduleById(Long id) {
        Schedule schedule = this.schedulerepository.findById(id).orElseThrow(
                () -> new BusinessException(String.format(ExceptionConstants.ID_NOT_FOUND, id)));

        this.schedulerepository.delete(schedule);
    }

}
