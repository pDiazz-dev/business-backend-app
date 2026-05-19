package org.technew.linkedin2.model.entities.collaborator.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "countries")
@Setter
@Getter
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @OneToMany(mappedBy = "countries", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<States> states;
}
