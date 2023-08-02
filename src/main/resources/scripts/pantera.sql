CREATE DATABASE IF NOT EXISTS `DB_PANTERA`;
USE DB_PANTERA;

CREATE TABLE `tb_sessoes` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `horario_inicio` VARCHAR(5),
    `horario_fim` VARCHAR(5),

    PRIMARY KEY (id)
);

CREATE TABLE `tb_cadeiras` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `id_sessao` INT NOT NULL,
    `nome_cliente` VARCHAR(255),
    `status` BOOLEAN NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (id_sessao) REFERENCES `tb_sessoes` (`id`)
);