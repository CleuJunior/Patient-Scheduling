package com.junior.br.schedule.api.dtos.request;

public record PatientRequest(
        Long id,
        String name,
        String lastName,
        String email,
        String cpf) {
}
