--liquibase formatted sql

--changeset seu-nome:05
ALTER TABLE pessoa ADD CONSTRAINT fk_celula FOREIGN KEY (celula_id) REFERENCES celula(id);
