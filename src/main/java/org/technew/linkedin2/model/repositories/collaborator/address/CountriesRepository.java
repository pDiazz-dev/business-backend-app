package org.technew.linkedin2.model.repositories.collaborator.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.collaborator.address.Countries;

import java.util.Optional;

public interface CountriesRepository extends JpaRepository<Countries, Long> {
    boolean existsByName(String name);
    Optional<Countries> findByName(String name);
}
