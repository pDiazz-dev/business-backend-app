create table topics (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    topic_type ENUM('LANGUAGE', 'TECHNOLOGY', 'SOFT_SKILLS') NOT NULL,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);