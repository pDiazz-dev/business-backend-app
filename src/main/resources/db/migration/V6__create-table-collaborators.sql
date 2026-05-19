create table collaborators (
    user_id BIGINT PRIMARY KEY,
    foreign key(user_id)
        references users(id)
        on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);