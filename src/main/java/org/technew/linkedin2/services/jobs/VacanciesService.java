package org.technew.linkedin2.services.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.jobs.Vacancies;
import org.technew.linkedin2.model.repositories.jobs.JobsRepository;
import org.technew.linkedin2.model.repositories.jobs.VacanciesRepository;
import org.technew.linkedin2.model.repositories.collaborator.CollaboratorRepository;
import org.technew.linkedin2.services.security.UserLoggedService;
import org.technew.linkedin2.services.jobs.DTOs.VacancyDTO;

@RequiredArgsConstructor
@Service
public class VacanciesService {

    private final VacanciesRepository vacanciesRepository;
    private final JobsRepository jobsRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final UserLoggedService userLoggedService;

    public void newVacancy(VacancyDTO dto) {
        var user = userLoggedService.getLoggedUser();
        var collaborator = collaboratorRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User does not have a collaborator profile"));

        var job = jobsRepository.findById(dto.jobId()).orElseThrow(()
                -> new RuntimeException("Job not found"));

        var enterprise = job.getEnterprise();
        if (enterprise == null || enterprise.getCollaborator() == null || !enterprise.getCollaborator().getUserId().equals(collaborator.getUserId())) {
            throw new RuntimeException("Job does not belong to the current collaborator's enterprise");
        }

        Vacancies vacancy = new Vacancies();
        vacancy.setVacanciesNumber(dto.vacanciesNumber());
        vacancy.setJobs(job);

        vacanciesRepository.save(vacancy);
    }
}
