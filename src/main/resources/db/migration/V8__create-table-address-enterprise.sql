create table countries(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(255) not null,
    code varchar(10) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);
create table states(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(3) not null,
    country_id BIGINT not null,
    foreign key(country_id)
        references countries(id)
        on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);

create table cities(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(200) not null,
    state_id BIGINT not null,
    foreign key(state_id)
        references states(id)
        on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);

create table address_enterprise (
    id BIGINT PRIMARY KEY,
    foreign key (id)
        references enterprise(id)
        on delete cascade,
    street varchar(255) not null,
    zip_code varchar(20) not null,
    number varchar(20) not null,
    complement varchar(255),
    neighborhood varchar(255) not null,
    city_id BIGINT not null,
    foreign key(city_id)
        references cities(id)
        on delete cascade,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);