drop table if exists person;

create table person
(
	id varchar(36) not null
		constraint pk_person
			primary key,
    tenant_id varchar(36),

	first_name varchar(255),
	last_name varchar(255),

    address_id varchar(36) NOT NULL,
    version bigint default 0
);


drop table if exists address;

create table address
(
	id varchar(36) not null
		constraint pk_address
			primary key,

    tenant_id varchar(36),

	street varchar(255) NULL,
	city varchar(255) NULL,
	version bigint default 0
);
