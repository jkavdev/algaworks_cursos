create table comentarios (
	id bigint auto_increment primary key,
	descricao varchar(60) not null,
	horario_envio datetime not null,
	ordem_servico_id bigint not null
);

alter table comentarios add constraint fk_ordem_servico_id
	foreign key (ordem_servico_id) references  ordem_servico(id);