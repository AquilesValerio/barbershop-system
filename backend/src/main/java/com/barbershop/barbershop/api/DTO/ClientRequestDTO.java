package com.barbershop.barbershop.api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientRequestDTO(
        @NotBlank(message = "Nome é obrigatório. ")
        @Size(max = 50)
        String name,
        @NotBlank(message = "Email é obrigatório. ")
        @Email
        String email,
        @NotBlank(message = "Telefone é obrigatório. ")
        String phone) {
}
