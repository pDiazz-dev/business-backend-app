package org.technew.linkedin2.model.entities.jobs.skills;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic_type")
    @Enumerated(EnumType.STRING)
    private TopicType topicType;

    @OneToMany(mappedBy = "topics")
    private List<Skills> skills;
}
