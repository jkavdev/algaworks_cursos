use algaworks_osworks;

show tables;

select * from flyway_schema_history;

select * from cliente;

insert into cliente(nome, email, fone) values
	('Jhonatan', 'jhonatan@email.com', '12345678'),
    ('Lucas', 'lucas@email.com', '12345678'),
    ('Douglas', 'douglas@email.com', '12345678');

drop database algaworks_osworks;