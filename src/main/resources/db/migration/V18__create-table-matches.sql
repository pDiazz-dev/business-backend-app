create table matches (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    worker_id BIGINT not null,
    vacancies_id BIGINT not null,
    status_matches ENUM('PENDING', 'ACCEPTED', 'REJECTED') NOT NULL default 'PENDING',
    constraint fk_matches_worker
        foreign key (worker_id) references worker(id) on delete cascade,
    constraint fk_matches_vacancies
        foreign key (vacancies_id) references vacancies(id) on delete cascade,
    expires_at TIMESTAMP NOT NULL,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    deleted_at timestamp null default null
);