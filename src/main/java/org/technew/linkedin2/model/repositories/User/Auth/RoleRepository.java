package org.technew.linkedin2.model.repositories.User.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
