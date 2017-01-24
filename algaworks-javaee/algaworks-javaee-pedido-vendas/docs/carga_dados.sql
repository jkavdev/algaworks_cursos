delete from categoria where categoria_pai_id is not null;
delete from categoria;

alter table categoria auto_increment = 1;

insert into categoria (descricao) values ('Informática');
insert into categoria (descricao) values ('Eletrodomésticos');
insert into categoria (descricao) values ('Móveis');

insert into categoria (descricao, categoria_pai_id) values ('Computadores', 1);
insert into categoria (descricao, categoria_pai_id) values ('Notebooks', 1);
insert into categoria (descricao, categoria_pai_id) values ('Tablets', 1);
insert into categoria (descricao, categoria_pai_id) values ('Monitores', 1);
insert into categoria (descricao, categoria_pai_id) values ('Impressoras', 1);
insert into categoria (descricao, categoria_pai_id) values ('Acessórios', 1);

insert into categoria (descricao, categoria_pai_id) values ('Ar condicionados', 2);
insert into categoria (descricao, categoria_pai_id) values ('Fogões', 2);
insert into categoria (descricao, categoria_pai_id) values ('Fornos elétricos', 2);
insert into categoria (descricao, categoria_pai_id) values ('Microondas', 2);
insert into categoria (descricao, categoria_pai_id) values ('Refrigeradores', 2);

insert into categoria (descricao, categoria_pai_id) values ('Cadeiras', 3);
insert into categoria (descricao, categoria_pai_id) values ('Mesas', 3);
insert into categoria (descricao, categoria_pai_id) values ('Racks', 3);
insert into categoria (descricao, categoria_pai_id) values ('Sofás', 3);

insert into cliente (doc_receita_federal, email, nome, tipo) values
	('321456', 'jhonatan@gmail.com', 'jhonatan', 'FISICA'),
	('321441', 'douglas@gmail.com', 'douglas', 'FISICA'),
	('321256', 'lucas@gmail.com', 'lucas', 'FISICA'),
	('325456', 'ismael@gmail.com', 'ismael', 'FISICA'),
	('321449', 'jessica@gmail.com', 'jessica', 'FISICA'),
	('2454477', 'belica@gmail.com', 'belica', 'JURIDICA'),
	('2154477', 'paoesal@gmail.com', 'pao e sal', 'JURIDICA');

insert into usuario (email, nome, senha) values
	('jhonatan@gmail.com', 'jhonatan', '321456'),
	('douglas@gmail.com', 'douglas', '321441'),
	('lucas@gmail.com', 'lucas', '321256'),
	('ismael@gmail.com', 'ismael', '325456'),
	('jessica@gmail.com', 'jessica', '321449'),
	('belica@gmail.com', 'belica', '2454477'),
	('paoesal@gmail.com', 'pao e sal', '2154477');	