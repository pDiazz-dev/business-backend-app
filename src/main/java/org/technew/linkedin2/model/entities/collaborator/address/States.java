package org.technew.linkedin2.model.entities.collaborator.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "states")
@Getter
@Setter
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;

    private String name;

    @OneToMany(mappedBy = "states", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cities> cities;
}
