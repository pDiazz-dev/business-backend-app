package org.technew.linkedin2.services.security.DTOs;

public record LoginResponseDTO(
        String acessToken,
        String refreshToken
) {
}
