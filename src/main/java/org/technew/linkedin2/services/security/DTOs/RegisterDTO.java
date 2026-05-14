package org.technew.linkedin2.services.security.DTOs;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank(message = "this camp is not empty or null")
        String name,
        @NotBlank(message = "this camp is not empty or null")
        String email,
        @NotBlank
        String password
) {
}
