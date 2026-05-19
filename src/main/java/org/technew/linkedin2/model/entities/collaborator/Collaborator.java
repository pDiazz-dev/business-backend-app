package org.technew.linkedin2.model.entities.collaborator;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.technew.linkedin2.model.entities.user.Users;

import java.util.List;

@Entity
@Table(name = "collaborators")
@Setter
@Getter
public class Collaborator {
    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "collaborator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enterprise> enterprises;
}
