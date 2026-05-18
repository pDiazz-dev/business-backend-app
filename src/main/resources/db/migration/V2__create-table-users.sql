create table users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    status boolean not null default true,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);