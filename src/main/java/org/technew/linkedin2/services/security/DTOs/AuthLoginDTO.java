package org.technew.linkedin2.services.security.DTOs;

public record AuthLoginDTO(
        String email,
        String password
) {
}
