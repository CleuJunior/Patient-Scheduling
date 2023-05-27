package com.junior.br.schedule.api.controller;

import com.junior.br.schedule.api.dtos.request.ScheduleRequest;
import com.junior.br.schedule.api.dtos.response.ScheduleResponse;
import com.junior.br.schedule.domain.service.ServiceManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ServiceManager serviceManger;

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> listAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK).body(this.serviceManger.getScheduleService().listAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> findScheduleById(@PathVariable Long id) {
        ScheduleResponse response = this.serviceManger.getScheduleService().findScheduleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> insertSchedule(@Valid @RequestBody ScheduleRequest request) {
        ScheduleResponse response = this.serviceManger.getScheduleService().insertSchedule(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
