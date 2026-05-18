package org.technew.linkedin2.model.entities.user.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.technew.linkedin2.model.entities.user.Users;

import java.time.Instant;

@Entity
@Table(name = "refresh_tokens")
@Getter
@Setter
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
