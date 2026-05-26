package org.technew.linkedin2.model.repositories.jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.jobs.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
