create table skills (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(120) not null,
    description varchar(160),
    topic_id BIGINT not null,
    foreign key(topic_id)
        references topics(id),
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);