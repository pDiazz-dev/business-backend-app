package org.technew.linkedin2.model.entities.jobs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.technew.linkedin2.model.entities.collaborator.Enterprise;
import org.technew.linkedin2.model.entities.jobs.skills.Skills;

import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @ManyToMany
    @JoinTable(
        name = "jobs_skills",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skills> skills;

    @OneToMany(mappedBy = "jobs")
    private List<Vacancies> vacancies;
}
