package org.technew.linkedin2.model.repositories.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.user.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
}
