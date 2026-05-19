package org.technew.linkedin2.model.repositories.collaborator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.collaborator.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
}
