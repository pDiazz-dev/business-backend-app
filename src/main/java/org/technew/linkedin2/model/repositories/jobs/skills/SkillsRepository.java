package org.technew.linkedin2.model.repositories.jobs.skills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.jobs.skills.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
}
