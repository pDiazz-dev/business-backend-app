package org.technew.linkedin2.model.repositories.collaborator.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.collaborator.address.States;
import java.util.Optional;

public interface StatesRepository extends JpaRepository<States, Long> {
    boolean existsByName(String name);
    Optional<States> findByName(String name);
}
