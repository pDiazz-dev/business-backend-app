package org.technew.linkedin2.model.entities.collaborator.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cities")
@Setter
@Getter
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private States states;
    @OneToMany(mappedBy = "cities", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
}
