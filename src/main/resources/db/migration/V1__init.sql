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


insert into person (id, tenant_id, first_name, last_name, address_id, version) values ('5d9b79e0-c3da-4d7c-a411-6eb2ea6207e6', '0', 'Homer', 'Simpson', '999020de-a7db-49eb-8849-6dcbcab088e4', 0);
insert into person (id, tenant_id, first_name, last_name, address_id, version) values ('84b27449-3ac5-4e3f-81b7-345d25c56210', '0', 'Bart', 'Simpson', 'b6df6f5b-62b4-45d3-a3c8-d42ec5483220', 0);
insert into person (id, tenant_id, first_name, last_name, address_id, version) values ('145482e6-b174-4a83-b9af-60856dcacb1a', '0', 'Monty', 'Burns', 'a443ecec-d90f-4f02-9b31-dac34150e278', 0);

insert into address (id, tenant_id, street, city, version) values ('999020de-a7db-49eb-8849-6dcbcab088e4', '0', 'Evergreen Terrace 1', 'Springfield', 0);
insert into address (id, tenant_id, street, city, version) values ('b6df6f5b-62b4-45d3-a3c8-d42ec5483220', '0', 'Everblue Terrace 1', 'Springfield', 0);
insert into address (id, tenant_id, street, city, version) values ('a443ecec-d90f-4f02-9b31-dac34150e278', '0', 'Monty Mansion', 'Springfield', 0);

