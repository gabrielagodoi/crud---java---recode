CREATE DATABASE api_spring;
 
USE api_spring;
 
DROP DATABASE landingpage; 
 
SELECT * FROM crud.pessoas;
 
INSERT INTO crud.pessoas VALUES (1, "Gabriela",25,"Branca");
  
CREATE TABLE pessoas(
id int not null auto_increment primary key,
nome varchar(30), 
idade int,
etnia varchar(30)
);
