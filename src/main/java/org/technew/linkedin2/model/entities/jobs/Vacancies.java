package org.technew.linkedin2.model.entities.jobs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "vacancies")
@Getter
@Setter
public class Vacancies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_vacancies")
    private Integer numberVacancies;

    private Boolean status = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Jobs jobs;
}
