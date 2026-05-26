create table vacancies (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    job_id BIGINT not null,
    vacancies_number integer not null,
    status boolean not null default true,
        foreign key (job_id) references jobs(id) on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);