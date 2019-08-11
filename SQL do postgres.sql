create table usuario(
nome varchar(50),
cpf varchar(15) unique,
telefone varchar(20),
email varchar(30),
id serial,
id_conta int not null,
foreign key(id_conta) references conta(id),
primary key(id)
);

create table conta(
numero int unique,
saldo float,
id serial,
primary key(id)
);

create table moeda(
nome varchar(30),
valor decimal(10,3),
id serial,
primary key(id)
);

create table meta(
id_usuario int not null,
nome varchar(30),
data_inicio date default now(),
data_final date,
id serial,
primary key(id),
foreign key(id_usuario) references usuario(id)
);

create table investimento(
id_meta int not null,
id_moeda int not null,
status varchar(10),
valor decimal(10,3),
data_inicio date default now(),
data_fim date,
id serial,
foreign key(id_meta) references meta(id),
foreign key(id_moeda) references moeda(id),
primary key(id)
);
