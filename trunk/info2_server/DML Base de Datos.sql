-- Categorias

INSERT INTO `Info2`.`Categorias` (`Nombre`)
VALUES
("Hamburguesas");

INSERT INTO `Info2`.`Categorias` (`Nombre`)
VALUES
("Chivitos");

INSERT INTO `Info2`.`Categorias` (`Nombre`)
VALUES
('Pizzas');

INSERT INTO `Info2`.`Categorias` (`Nombre`)
VALUES
("Minutas");

INSERT INTO `Info2`.`Categorias` (`Nombre`)
VALUES
('Bebidas');

UPDATE `Info2`.`Categorias`
SET
`idCategorias` = 1
WHERE `Nombre` = 'Hamburguesas';

UPDATE `Info2`.`Categorias`
SET
`idCategorias` = 2
WHERE `Nombre` = 'Chivitos';

UPDATE `Info2`.`Categorias`
SET
`idCategorias` = 3
WHERE `Nombre` = 'Pizzas';

UPDATE `Info2`.`Categorias`
SET
`idCategorias` = 4
WHERE `Nombre` = 'Minutas';

UPDATE `Info2`.`Categorias`
SET
`idCategorias` = 5
WHERE `Nombre` = 'Bebidas';



-- Articulos

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO CHILDREN",220,2);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO CANADIENSE",260,2);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO AL PLATO (PARA DOS PERSONAS)",400,2);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO DE LA CASA",240,2);

-- Hambuguresas

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("HAMBURGUESA CON FRITAS",150,1);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHISBUGER",200,1);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("HAMBUERGUESA COMPLETA",260,1);

-- Muzzrella 

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("PIZZA",50,3);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MUZZARELLA",80,3);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MUZZARELLA CON JAMON",100,3);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MUZZARELLA CON PANCETA",100,3);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("FAINA",50,3);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("FAINA CON MUZZARELLA",70,3);

 -- Minutas

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA",180,4);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA CON PROVOLONE",220,4);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("NAPOLITANA",250,4);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA RELLENA",250,4);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA DE LA CASA (PARA DOS)",350,4);

-- Bebidas

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("AGUA (CON/SIN)",50,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("REFRESCO CHICO (300ML)",60,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("REFRESCO GRANDE (1.5L)",110,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("WHISKY NACIONAL",80,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("RED BULL",80,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("GATORADE",60,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("COCKTAIL SECRETO DE LA CASA",100,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CERVEZA 1L",120,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHOPP",80,5);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CAFE COLOMBIANO",60,5);

-- Mesas

-- Mesa1
INSERT INTO `Info2`.`Mesa`
(`Estado`)
VALUES
(DEFAULT);

-- Mesa2
INSERT INTO `Info2`.`Mesa`
(`Estado`)
VALUES
(DEFAULT);

-- Mesa3
INSERT INTO `Info2`.`Mesa`
(`Estado`)
VALUES
(DEFAULT);



-- Usuarios

INSERT INTO `Info2`.`Users`(`Username`,`Password`,`Admin`)
VALUES
("MatiasG","aaa",1);

INSERT INTO `Info2`.`Users`(`Username`,`Password`,`Admin`)
VALUES
("FacundoL","uss",1);

INSERT INTO `Info2`.`Users`(`Username`,`Password`,`Admin`)
VALUES
("Bernardo","bern",0);