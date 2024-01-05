<h1>Intruções de como rodar o projeto</h1>
<h2>Backend em Node v20.10.0</h2>
Na pasta raiz do projeto entrar no diretorio api e rodar o seguinte comando: yarn start
Backend vai rodar na porta 8800

<h2>Frontend em Vue 3</h2>
Na pasta raiz do projeto entrar no diretorio api e rodar o seguinte comando: yarn start
Frontend vai rodar na porta 8080

<h2>Bando de dados MySql</h2>
Criar um novo banco chamado: db_vue_node
Criar uma nova tabela chamada: users
CREATE TABLE IF NOT EXISTS users(
	  id int auto_increment primary key,
    nome varchar(100) NOT NULL,
    email varchar(50) NOT NULL,
    telefone varchar(20) NOT NULL,
    idade int NOT NULL
)
*Colocar a senha do mysql no arquivo api/db.js
