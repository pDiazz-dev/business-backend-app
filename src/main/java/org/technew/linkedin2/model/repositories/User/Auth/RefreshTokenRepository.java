package org.technew.linkedin2.model.repositories.User.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technew.linkedin2.model.entities.user.auth.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
