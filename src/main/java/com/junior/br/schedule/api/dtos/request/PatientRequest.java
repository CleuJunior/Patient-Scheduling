package com.junior.br.schedule.api.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record PatientRequest(
        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Lastname is mandatory")
        String lastName,

        String email,

        @NotBlank(message = "Name is mandatory")
        String cpf) {}
