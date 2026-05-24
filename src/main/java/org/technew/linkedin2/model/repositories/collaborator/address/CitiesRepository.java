package org.technew.linkedin2.model.repositories.collaborator.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.collaborator.address.Cities;
import java.util.Optional;

public interface CitiesRepository extends JpaRepository<Cities, Long> {
    boolean existsByName(String name);
    Optional<Cities> findByName(String name);
}
