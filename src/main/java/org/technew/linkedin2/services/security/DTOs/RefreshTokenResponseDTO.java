package org.technew.linkedin2.services.security.DTOs;

public record RefreshTokenResponseDTO(
        String acessToken,
        String tokenRefresh
) {
}
