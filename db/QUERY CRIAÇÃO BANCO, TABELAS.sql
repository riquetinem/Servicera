-- comentários
-- a linha abaixo cria um banco de dados

create database dbinfox;

-- a linha abaixo escolhe o banco de dados a ser utilizado;

use dbinfox;
-- o bloco de instruções abaixo cria uma tabela

create table tbusuarios(
iduser int primary key,
usuario varchar(50) not null,
fone varchar(15),
login varchar(15) not null UNIQUE,
senha varchar(15) not null
);

-- o comando abaixo descreve a tablea
describe tbusuarios;

-- a linha abaixo insere dados na tabela (CRUD)
-- create (INSERT)
use dbinfox;

insert into tbusuarios(iduser, usuario, fone, login, senha)
values(1,'José de Assis','9999-9999','joseassis','123456');

insert into tbusuarios(iduser, usuario, fone, login, senha)
values(2,'ADMISTRADOR','3333-3333','admin','admin');

insert into tbusuarios (iduser, usuario,fone,login,senha)
values (3,'Gabriel Ribello','77872876','gab','123');

select * from tbusuarios;


-- a linha abaixo exibe os dados da tabela
 select * from tbusuarios;
 
 -- a linha abaixo modifica dados da tabela	(CRUD)
 -- update (UPDATE)
 
 update tbusuarios set fone = '8888-8888' where iduser=2;
 
 -- a linha abaixo apaga um registro da tabela
 -- delete (DELETE)
 
 delete from tbusuarios where iduser = 3;
 
 create table tbclientes (
 idcli int primary key auto_increment,
 nomecli varchar(50) not null,
 endcli varchar(100),
 fonecli varchar(50) not null,
 emailcli varchar (50) 
 );
 
 -- o comando abaixo descreve a tabela
 
 describe tbclientes;
 
 -- o comando abaixo insere valores na tabela
 
 insert into tbclientes(nomecli,endcli,fonecli,emailcli)
 values('Linus Torvalds','Rua Tux, 2015','9999-9999','linus@linus.com');
 
 select * from tbclientes;
 
 -- esse comando cria a tabela de ordem de serviço
 
 create table tbos (
 os int primary key auto_increment,
 dataos timestamp default current_timestamp,
 equipamento varchar(150) not null,
 defeito varchar(150) not null,
 servico varchar(150),
 tecnico varchar(30),
 valor decimal (10,2),
 idcli int not null,
 foreign key (idcli) references tbclientes (idcli)
 );
 
 -- timestamp default current_timestamp (Automaticamente no insert você insere a data e hora);
 
 describe tbos;
 
 insert into tbos (equipamento,defeito,servico,tecnico,valor,idcli)
 values ('Notebook', 'Não Liga','Troca da Fonte', 'Zé',87.50,1);
 
 select * from tbos; -- select de *ESTAGIARIO*
 
 select os,dataos,equipamento,defeito,servico,tecnico,valor,idcli from tbos; -- select correto
 
 -- o codigo abaixo traz informações de duas tabelas
 
 select 
 O.os, equipamento,defeito,servico,valor,
 C.nomecli,fonecli
 from tbos as O
 inner join tbclientes as C
 on (O.idcli = C.idcli);
 
 -- inner join (Comando que une duas tabelas em um select)
 
 use dbinfox;
 describe tbusuarios;
 
 -- a linha abaixo altera a tabela para a adição de mais um campo
 
 alter table tbusuarios add column perfil varchar(20) not null;
 
 -- a linha abaixo remove um campo de uma tabela
 
 alter table tbusuarios drop column perfil;
 
 -- a linha abaixo atualiza a tabela
 
 update tbusuarios set perfil = 'admin' where iduser = 3;
 update tbusuarios set usuario = 'Administrador' where iduser = 2;
 update tbusuarios set perfil = 'user' where iduser = 1;
 
 select * from tbusuarios;
 
 
 
 
 
 
 
 
 
