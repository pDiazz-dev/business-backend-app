create table matches_response(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    matches_id BIGINT not null,
    response varchar(500) NOT NULL,
    constraint fk_matches_response_matches
        foreign key (matches_id) references matches(id) on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    deleted_at timestamp null default null
);