package org.technew.linkedin2.model.repositories.jobs.skills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.jobs.skills.Topics;

public interface TopicsRepository extends JpaRepository<Topics, Long> {
}
