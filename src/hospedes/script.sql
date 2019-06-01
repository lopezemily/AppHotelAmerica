CREATE DATABASE fornecedores;
USE fornecedores;
CREATE TABLE T_fornecedores (
	Codigo int(5) AUTO_INCREMENT , 
	Nome varchar(50),
	Sobrenome varchar(50),
	Endereco varchar(100),
	Cidade varchar(30),
	Estado varchar(30),
	Cep varchar(12), 
	primary key(Codigo)
);