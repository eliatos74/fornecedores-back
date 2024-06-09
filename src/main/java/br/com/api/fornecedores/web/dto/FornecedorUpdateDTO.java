package br.com.api.fornecedores.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FornecedorUpdateDTO(
        @NotBlank
        String name,

        @NotBlank
        String lastName,

        @NotBlank
        @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "Formato de e-mail inválido.")
        String email,

        String address
) {
}
