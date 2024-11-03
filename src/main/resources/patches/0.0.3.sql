create unique index users_id_uindex
    on users (id);

create sequence "users_id_seq";

alter sequence "users_id_seq" owned by users.id;

alter table users
    alter column id set default nextval('users_id_seq'::regclass);