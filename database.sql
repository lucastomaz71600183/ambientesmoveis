create database ejc_db;
use ejc_db;

create table encontrista (
id int unsigned auto_increment primary key,
nome varchar(30) not null,
sobrenome varchar(60) not null,
telefone varchar(14),
celular varchar(14) not null,
data_nascimento date not null,
edicao int not null,
email varchar(100) not null,
senha varchar(80) not null,
foto varchar(200) not null,
data_atualizacao datetime default current_timestamp on update current_timestamp,
data_cadastro datetime DEFAULT NOW()
);

create table noticia (
id int unsigned auto_increment primary key,
titulo varchar(80) not null,
descricao varchar(240) not null,
imagem varchar(200),
autor_id int unsigned not null,
data_atualizacao datetime default current_timestamp on update current_timestamp,
data_cadastro datetime DEFAULT NOW(),
foreign key(autor_id) references encontrista(id)
);
