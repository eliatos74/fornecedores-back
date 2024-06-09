package br.com.api.fornecedores.web.dto;

public record FornecedorResponseDTO(
        Long id,
        String name,
        String lastName,
        String email,
        String address
) {
}
