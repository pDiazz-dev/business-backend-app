package org.technew.linkedin2.services.jobs.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record JobDTO(
        @NotBlank
        String position,
        @NotBlank
        String description,
        @NotNull
        Long enterpriseId,
        @NotEmpty
        List<Long> skillIds
) {
}
