create table worker (
    user_id BIGINT PRIMARY KEY,
    foreign key(user_id)
        references users(id)
        on delete cascade,
    phone VARCHAR(20),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);