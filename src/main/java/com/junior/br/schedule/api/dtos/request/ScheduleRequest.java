package com.junior.br.schedule.api.dtos.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ScheduleRequest(

        @NotBlank
        String description,

        @NotNull
        @Future
        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        LocalDateTime time,

        @NotNull
        Long patientId
) {}
