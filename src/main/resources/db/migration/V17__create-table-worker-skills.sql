create table worker_skills (
    worker_id BIGINT not null,
    skill_id BIGINT not null,
    primary key (worker_id, skill_id),
    status boolean not null default true,
    constraint fk_worker_skills_worker
        foreign key (worker_id) references worker(id) on delete cascade,
    constraint fk_worker_skills_skill
        foreign key (skill_id) references skills(id) on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);