package org.technew.linkedin2.services.jobs.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record VacancyDTO(
        @NotNull
        Long jobId,
        @NotNull
        @Min(1)
        Integer numberVacancies
) {
}
