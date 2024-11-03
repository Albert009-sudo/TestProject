--------------------------------------CUSTOMERS
create table customers
(
    id         bigint not null
        constraint customers_id_pk
            primary key,
    name     varchar
        constraint customers_user_name_pk
            unique,
    phone  varchar,
    email     varchar
);

alter table customers
    owner to test;

create unique index customers_id_uindex
    on customers (id);

create sequence "customers_seq";

alter sequence "customers_seq" owned by customers.id;

alter table customers
    alter column id set default nextval('customers_seq'::regclass);




--------------------------------------ADDRESSES
create table addresses
(
    id         bigint not null
        constraint addresses_id_pk
            primary key,
    type     varchar
        constraint addresses_user_name_pk
            unique,
    value  varchar,
    customer_id bigint not null,
        CONSTRAINT fk_customer_id FOREIGN KEY(customer_id) REFERENCES customers(id)
);

alter table addresses
    owner to test;

create unique index addresses_id_uindex
    on addresses (id);

create sequence "address_seq";

alter sequence "address_seq" owned by addresses.id;

alter table addresses
    alter column id set default nextval('address_seq'::regclass);