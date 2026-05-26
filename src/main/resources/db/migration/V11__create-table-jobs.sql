create table jobs (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    position VARCHAR(255) NOT NULL,
    enterprise_id BIGINT NOT NULL,
    description TEXT not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    foreign key(enterprise_id)
        references enterprise(id)
        on delete cascade
);