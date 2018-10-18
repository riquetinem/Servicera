use dbinfox;

-- o bloco de instruções abaixo faz a seleção e união de dados de duas tabelas
-- OSER é uma variavel que contem os campos desejados da tabela OS
-- Cli é outra variavel que contem os campos desejados da tabela Clientes

select 
OSER.os,dataos,tipo,situacao,equipamento,valor,
CLI.nomecli,fonecli 
from tbos as OSER
inner join tbclientes as CLI
on (CLI.idcli = OSER.idcli);

