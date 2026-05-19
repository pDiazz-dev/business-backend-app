package org.technew.linkedin2.model.repositories.collaborator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.collaborator.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
