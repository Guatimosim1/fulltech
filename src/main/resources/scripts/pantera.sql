CREATE DATABASE IF NOT EXISTS `DB_PANTERA`;
USE DB_PANTERA;

CREATE TABLE `sessoes` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `horario_inicio` VARCHAR(5),
    `horario_fim` VARCHAR(5),

    PRIMARY KEY (id)
);

CREATE TABLE `cadeiras` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `id_sessao` INT NOT NULL,
    `nome_cliente` VARCHAR(255),
    `status` BOOLEAN NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (id_sessao) REFERENCES `sessoes` (`id`)
);