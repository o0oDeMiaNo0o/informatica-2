SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Info2` ;
USE `Info2` ;

CREATE TABLE `Articles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `PRICE` int(11) NOT NULL,
  `Categorias_idCategorias` int(11) NOT NULL,
  `Estado` enum('Activo','Eliminado') NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`ID`),
  KEY `fk_Articles_Categorias1_idx` (`Categorias_idCategorias`)
) ENGINE=MyISAM AUTO_INCREMENT=121 DEFAULT CHARSET=latin1;

CREATE TABLE `Categorias` (
  `idCategorias` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategorias`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

CREATE TABLE `Clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ci` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Descuento` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`,`Ci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Facturas` (
  `idFacturas` int(11) NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Importe Total` decimal(5,2) NOT NULL,
  `Mesa_idMesa` int(11) DEFAULT NULL,
  `Pagos_idPagos` int(11) NOT NULL,
  `Clientes_id` int(11) DEFAULT NULL,
  `Clientes_Ci` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFacturas`),
  KEY `fk_Facturas_Mesa1_idx` (`Mesa_idMesa`),
  KEY `fk_Facturas_Pagos1_idx` (`Pagos_idPagos`),
  KEY `fk_Facturas_Clientes1_idx` (`Clientes_id`,`Clientes_Ci`),
  CONSTRAINT `fk_Facturas_Clientes1` FOREIGN KEY (`Clientes_id`, `Clientes_Ci`) REFERENCES `clientes` (`id`, `Ci`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Facturas_Mesa1` FOREIGN KEY (`Mesa_idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Facturas_Pagos1` FOREIGN KEY (`Pagos_idPagos`) REFERENCES `pagos` (`idPagos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Linea de Factura` (
  `Nro de Linea` int(11) NOT NULL,
  `Facturas_idFacturas` int(11) NOT NULL,
  `Articles_ID` int(11) NOT NULL,
  `Cantidad` int(4) NOT NULL,
  `Precio Unitario` decimal(5,2) NOT NULL,
  `Precio Total` decimal(6,2) NOT NULL,
  PRIMARY KEY (`Nro de Linea`,`Facturas_idFacturas`),
  KEY `fk_Linea de Factura_Articles1_idx` (`Articles_ID`),
  KEY `fk_Linea de Factura_Facturas1_idx` (`Facturas_idFacturas`),
  CONSTRAINT `fk_Linea de Factura_Articles1` FOREIGN KEY (`Articles_ID`) REFERENCES `articles` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Linea de Factura_Facturas1` FOREIGN KEY (`Facturas_idFacturas`) REFERENCES `facturas` (`idFacturas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Mesa` (
  `idMesa` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` enum('Ocupado','Libre') DEFAULT 'Libre',
  PRIMARY KEY (`idMesa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

CREATE TABLE `Pagos` (
  `idPagos` int(11) NOT NULL AUTO_INCREMENT,
  `ImporteRecibido` decimal(6,2) NOT NULL,
  `Vuelto` decimal(6,2) NOT NULL,
  `Tipos de Pagos_idTiposdePagos` int(2) NOT NULL,
  PRIMARY KEY (`idPagos`),
  KEY `fk_Pagos_Tipos de Pagos1_idx` (`Tipos de Pagos_idTiposdePagos`),
  CONSTRAINT `fk_Pagos_Tipos de Pagos1` FOREIGN KEY (`Tipos de Pagos_idTiposdePagos`) REFERENCES `tipos de pagos` (`idTiposdePagos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `HoraPedido` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Mesa_idMesa` int(11) DEFAULT NULL,
  `Estado` enum('En Preparacion','Entregado','Rechazado','Delivery') DEFAULT 'En Preparacion',
  `Facturas_idFacturas` int(11) DEFAULT NULL,
  `Users_Username` varchar(45) DEFAULT NULL,
  `Especificaciones` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `fk_pedido_Mesa1_idx` (`Mesa_idMesa`),
  KEY `fk_pedido_Facturas1_idx` (`Facturas_idFacturas`),
  KEY `fk_pedido_Users1_idx` (`Users_Username`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE `Pedido/Articulos` (
  `pedido_idpedido` int(11) NOT NULL,
  `Articles_ID` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`pedido_idpedido`,`Articles_ID`),
  KEY `fk_Pedido/Producto_pedido_idx` (`pedido_idpedido`),
  KEY `fk_Pedido/Producto_Articles1_idx` (`Articles_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Tipos de Pagos` (
  `idTiposdePagos` int(2) NOT NULL,
  `NombreTipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTiposdePagos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Users` (
  `idUsers` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Admin` int(1) NOT NULL,
  `Vigente` enum('Activo','Eliminado') NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idUsers`,`Username`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
