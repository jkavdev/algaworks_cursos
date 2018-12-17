insert into cliente(id, nome) values (1, 'Stream Company');
insert into cliente(id, nome) values (2, 'Java Community');
insert into cliente(id, nome) values (3, 'OCA Exam');

insert into produto(id, nome, valor) values (1, 'Cadeira de Couro', 130.0);
insert into produto(id, nome, valor) values (2, 'Mouse Hazer', 79.0);
insert into produto(id, nome, valor) values (3, 'Desktop Dell', 1500.0);

insert into venda(id, cliente_id, frete, total, cadastro) values (1, 1, 50.0, 2400, sysdate())

insert into item(id, venda_id, produto_id, quantidade) values (1, 1, 1, 1);