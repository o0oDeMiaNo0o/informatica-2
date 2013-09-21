-- Base de Datos para Informatica 2,
-- Manejo de Local de Comidas

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


CREATE DATABASE IF NOT EXISTS Info2;
USE Info2;

-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS Articles;

CREATE TABLE IF NOT EXISTS Articles (`id` INT NOT NULL , `product num` INT NOT NULL,
	`nombre` VARCHAR(255) NOT NULL,`precio` INT, PRIMARY KEY(`id`))
	ENGINE=MyISAM DEFAULT CHARSET=latin1 TYPE=innodb;