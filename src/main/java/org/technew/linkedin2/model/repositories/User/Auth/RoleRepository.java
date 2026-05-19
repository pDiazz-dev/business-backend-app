package org.technew.linkedin2.model.repositories.User.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technew.linkedin2.model.entities.user.Roles;
import org.technew.linkedin2.model.entities.user.RoleType;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRoleType(RoleType roleType);
}
