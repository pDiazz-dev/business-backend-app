package org.technew.linkedin2.model.entities.collaborator.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.technew.linkedin2.model.entities.collaborator.Enterprise;

@Entity
@Table(name = "address_enterprise")
@Setter
@Getter
public class Address {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Enterprise enterprise;

    private String street;
    private String number;
    private String zipCode;
    private String complement;
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities cities;
}
