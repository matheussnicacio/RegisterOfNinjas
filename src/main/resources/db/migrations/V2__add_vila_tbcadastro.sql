-- V2: Migrations para adicionar a coluna de VILA na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN vila VARCHAR(255);