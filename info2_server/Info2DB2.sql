CREATE DATABASE `info2` /*!40100 DEFAULT CHARACTER SET latin1 */;



CREATE TABLE `Articles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROD_N` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `PRICE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;


CREATE TABLE `Clientes` (
  `CI` int(11) NOT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Apellido` varchar(255) DEFAULT NULL,
  `Mail` varchar(255) DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`CI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Pedido` (
  `idpedido` int(11) NOT NULL,
  `HoraPedido` datetime DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpedido`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Pedido/Producto` (
  `idPedido` int(11) NOT NULL,
  `idArticle` int(11) NOT NULL,
  `Especificaciones` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPedido`,`idArticle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `Users` (
  `idUsers` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Admin` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idUsers`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

