create table enterprise (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) not null,
    cnpj varchar(20) not null unique,
    collaborator_id BIGINT not null,
    foreign key(collaborator_id)
        references collaborators(user_id)
        on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);