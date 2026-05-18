create table refresh_tokens(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    token TEXT not null,
    expires_at timestamp not null,
    user_id integer not null,
    foreign key (user_id) references users(id) on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);