SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Info2` ;
USE `Info2` ;

-- -----------------------------------------------------
-- Table `Info2`.`Categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Categorias` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Categorias` (
  `idCategorias` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategorias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Info2`.`Articles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Articles` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Articles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `PROD_N` INT(11) NOT NULL,
  `NAME` VARCHAR(255) NOT NULL,
  `PRICE` INT(11) NOT NULL,
  `Categorias_idCategorias` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Articles_Categorias1_idx` (`Categorias_idCategorias` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 57
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Info2`.`Mesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Mesa` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Mesa` (
  `idMesa` INT NOT NULL,
  `Estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idMesa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Info2`.`Tipos de Pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Tipos de Pagos` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Tipos de Pagos` (
  `idTiposdePagos` INT(2) NOT NULL,
  `NombreTipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idTiposdePagos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Info2`.`Pagos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Pagos` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Pagos` (
  `idPagos` INT NOT NULL,
  `ImporteRecibido` DECIMAL(6,2) NOT NULL,
  `Vuelto` DECIMAL(6,2) NOT NULL,
  `Tipos de Pagos_idTiposdePagos` INT(2) NOT NULL,
  PRIMARY KEY (`idPagos`),
  INDEX `fk_Pagos_Tipos de Pagos1_idx` (`Tipos de Pagos_idTiposdePagos` ASC),
  CONSTRAINT `fk_Pagos_Tipos de Pagos1`
    FOREIGN KEY (`Tipos de Pagos_idTiposdePagos`)
    REFERENCES `Info2`.`Tipos de Pagos` (`idTiposdePagos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Info2`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Ci` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Mail` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` INT NULL,
  PRIMARY KEY (`id`, `Ci`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Info2`.`Facturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Facturas` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Facturas` (
  `idFacturas` INT NOT NULL,
  `Fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Importe Total` DECIMAL(5,2) NOT NULL,
  `Mesa_idMesa` INT NULL,
  `Pagos_idPagos` INT NOT NULL,
  `Clientes_id` INT NULL,
  `Clientes_Ci` INT NULL,
  PRIMARY KEY (`idFacturas`),
  INDEX `fk_Facturas_Mesa1_idx` (`Mesa_idMesa` ASC),
  INDEX `fk_Facturas_Pagos1_idx` (`Pagos_idPagos` ASC),
  INDEX `fk_Facturas_Clientes1_idx` (`Clientes_id` ASC, `Clientes_Ci` ASC),
  CONSTRAINT `fk_Facturas_Mesa1`
    FOREIGN KEY (`Mesa_idMesa`)
    REFERENCES `Info2`.`Mesa` (`idMesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Facturas_Pagos1`
    FOREIGN KEY (`Pagos_idPagos`)
    REFERENCES `Info2`.`Pagos` (`idPagos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Facturas_Clientes1`
    FOREIGN KEY (`Clientes_id` , `Clientes_Ci`)
    REFERENCES `Info2`.`Clientes` (`id` , `Ci`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Info2`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Users` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Users` (
  `idUsers` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NULL DEFAULT NULL,
  `Admin` TINYINT(4) NULL DEFAULT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsers`, `Username`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Info2`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`pedido` ;

CREATE TABLE IF NOT EXISTS `Info2`.`pedido` (
  `idpedido` INT(11) NOT NULL AUTO_INCREMENT,
  `HoraPedido` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Mesa_idMesa` INT NULL,
  `Estado` VARCHAR(45) NULL,
  `Facturas_idFacturas` INT NULL,
  `Users_Username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpedido`),
  INDEX `fk_pedido_Mesa1_idx` (`Mesa_idMesa` ASC),
  INDEX `fk_pedido_Facturas1_idx` (`Facturas_idFacturas` ASC),
  INDEX `fk_pedido_Users1_idx` (`Users_Username` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Info2`.`Pedido/Articulos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Pedido/Articulos` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Pedido/Articulos` (
  `pedido_idpedido` INT(11) NOT NULL,
  `Articles_ID` INT(11) NOT NULL,
  `Especificaciones` VARCHAR(45) NULL DEFAULT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`pedido_idpedido`, `Articles_ID`),
  INDEX `fk_Pedido/Producto_pedido_idx` (`pedido_idpedido` ASC),
  INDEX `fk_Pedido/Producto_Articles1_idx` (`Articles_ID` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Info2`.`Linea de Factura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Info2`.`Linea de Factura` ;

CREATE TABLE IF NOT EXISTS `Info2`.`Linea de Factura` (
  `Nro de Linea` INT NOT NULL,
  `Facturas_idFacturas` INT NOT NULL,
  `Articles_ID` INT(11) NOT NULL,
  `Cantidad` INT(4) NOT NULL,
  `Precio Unitario` DECIMAL(5,2) NOT NULL,
  `Precio Total` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`Nro de Linea`, `Facturas_idFacturas`),
  INDEX `fk_Linea de Factura_Articles1_idx` (`Articles_ID` ASC),
  INDEX `fk_Linea de Factura_Facturas1_idx` (`Facturas_idFacturas` ASC),
  CONSTRAINT `fk_Linea de Factura_Articles1`
    FOREIGN KEY (`Articles_ID`)
    REFERENCES `Info2`.`Articles` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Linea de Factura_Facturas1`
    FOREIGN KEY (`Facturas_idFacturas`)
    REFERENCES `Info2`.`Facturas` (`idFacturas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
