create table users
(
    id         bigint not null
        constraint users_id_pk
            primary key,
    user_name     varchar
        constraint users_user_name_pk
            unique,
    password  varchar,
    active     boolean default true
);

alter table users
    owner to test;

create unique index users_id_uindex
    on users (id);

