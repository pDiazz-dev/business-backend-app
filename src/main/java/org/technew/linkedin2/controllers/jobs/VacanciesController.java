package org.technew.linkedin2.controllers.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technew.linkedin2.services.jobs.DTOs.VacancyDTO;
import org.technew.linkedin2.services.jobs.VacanciesService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/enterprise/vacancies")
public class VacanciesController {
    private final VacanciesService vacanciesService;

    @PostMapping
    public ResponseEntity<Void> newVacancy(@RequestBody VacancyDTO vacancyDTO) {
        vacanciesService.newVacancy(vacancyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
