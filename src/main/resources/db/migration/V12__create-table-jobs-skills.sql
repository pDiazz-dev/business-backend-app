create table jobs_skills (
    job_id BIGINT not null,
    skill_id BIGINT not null,
    primary key (job_id, skill_id),
    constraint fk_jobs_skills_job
        foreign key (job_id) references jobs(id) on delete cascade,
    constraint fk_jobs_skills_skill
        foreign key (skill_id) references skills(id) on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);