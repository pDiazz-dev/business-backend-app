package org.technew.linkedin2.services.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.technew.linkedin2.model.entities.jobs.Jobs;
import org.technew.linkedin2.model.entities.collaborator.Enterprise;
import org.technew.linkedin2.model.repositories.collaborator.CollaboratorRepository;
import org.technew.linkedin2.model.repositories.collaborator.EnterpriseRepository;
import org.technew.linkedin2.model.repositories.jobs.JobsRepository;
import org.technew.linkedin2.model.repositories.jobs.skills.SkillsRepository;
import org.technew.linkedin2.services.security.UserLoggedService;
import org.technew.linkedin2.services.jobs.DTOs.JobDTO;

@RequiredArgsConstructor
@Service
public class JobsService {

    private final JobsRepository jobsRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final CollaboratorRepository collaboratorRepository;
    private final UserLoggedService userLoggedService;
    private final SkillsRepository skillsRepository;

    public void newJob(JobDTO dto) {
        var user = userLoggedService.getLoggedUser();
        var collaborator = collaboratorRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User does not have a collaborator profile"));

        var enterprise = enterpriseRepository.findById(dto.enterpriseId())
                .orElseThrow(() -> new RuntimeException("Enterprise not found"));

        if (enterprise.getCollaborator() == null || !enterprise.getCollaborator().getUserId().equals(collaborator.getUserId())) {
            throw new RuntimeException("Enterprise does not belong to the current collaborator");
        }

        if (dto.skillIds() == null || dto.skillIds().isEmpty()) {
            throw new RuntimeException("At least one skill must be provided for a job");
        }

        var skills = skillsRepository.findAllById(dto.skillIds());
        if (skills.size() != dto.skillIds().size()) {
            throw new RuntimeException("One or more skills not found");
        }

        Jobs job = new Jobs();
        job.setPosition(dto.position().trim().toUpperCase());
        job.setDescription(dto.description().trim().toUpperCase());
        job.setEnterprise(enterprise);
        job.setSkills(skills);

        jobsRepository.save(job);
    }
}
