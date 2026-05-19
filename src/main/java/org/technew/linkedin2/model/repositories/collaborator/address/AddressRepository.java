package org.technew.linkedin2.model.repositories.collaborator.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.collaborator.address.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
