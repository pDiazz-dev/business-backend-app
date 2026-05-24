package org.technew.linkedin2.model.entities.collaborator;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.technew.linkedin2.model.entities.collaborator.address.Address;

@Entity
@Table(name = "enterprise")
@Getter
@Setter
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private Collaborator collaborator;
}
