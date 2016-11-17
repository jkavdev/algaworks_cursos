create table vinhos (

	codigo bigint(20) primary key auto_increment,
	nome varchar(50) not null,
	tipo varchar(50) not null,
	safra int not null,
	volume int not null,
	valor decimal(10, 2) not null
	

) engine=innodb default charset=utf8;