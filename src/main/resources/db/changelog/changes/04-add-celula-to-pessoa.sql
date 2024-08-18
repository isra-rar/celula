--liquibase formatted sql

--changeset seu-nome:04
ALTER TABLE pessoa ADD celula_id BIGINT;
