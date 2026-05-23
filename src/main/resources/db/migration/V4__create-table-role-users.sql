create table role_users (
    users_id BIGINT not null,
    role_id BIGINT not null,
    primary key (role_id, users_id),
    constraint fk_users_role_users
        foreign key (users_id) references users(id) on delete cascade,
    constraint fk_users_role_role
        foreign key (role_id) references roles(id) on delete cascade,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);