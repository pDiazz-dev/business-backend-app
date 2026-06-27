create table worker (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    phone VARCHAR(20),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);