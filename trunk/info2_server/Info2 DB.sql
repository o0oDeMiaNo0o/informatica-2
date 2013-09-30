-- Base de Datos para Informatica 2,
-- Manejo de Local de Comidas

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


CREATE DATABASE IF NOT EXISTS Info2;
USE Info2;

-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS Articles;
Drop TABLE IF EXISTS Clientes;

CREATE TABLE IF NOT EXISTS Articles (`ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY , `PROD_N` INT NOT NULL,
	`NAME` VARCHAR(255) NOT NULL,`PRICE` INT)
	ENGINE=MyISAM DEFAULT CHARSET=latin1;

create table if not exists Clientes (`CI` int not null primary key, `Nombre` varchar(255), `Apellido` varchar(255),
	`Mail`varchar(255), `Direccion` varchar(255), `Telefono` int )
	ENGINE=MyISAM DEFAULT CHARSET=latin1;


