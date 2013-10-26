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



-- Articulos

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO CHILDREN",220,12);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO CANADIENSE",260,12);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO AL PLATO (PARA DOS PERSONAS)",400,12);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHIVITO DE LA CASA",240,12);

-- Hambuguresas

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("HAMBURGUESA CON FRITAS",150,11);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHISBUGER",200,11);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("HAMBUERGUESA COMPLETA",260,11);

-- Muzzrella 

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("PIZZA",50,13);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MUZZARELLA",80,13);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MUZZARELLA CON JAMON",100,13);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MUZZARELLA CON PANCETA",100,13);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("FAINA",50,13);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("FAINA CON MUZZARELLA",70,13);

 -- Minutas

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA",180,14);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA CON PROVOLONE",220,14);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("NAPOLITANA",250,14);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA RELLENA",250,14);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("MILANESA DE LA CASA (PARA DOS)",350,14);

-- Bebidas

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("AGUA (CON/SIN)",50,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("REFRESCO CHICO (300ML)",60,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("REFRESCO GRANDE (1.5L)",110,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("WHISKEY NACIONAL",80,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("RED BULL",80,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("GATORADE",60,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("COCKTAIL SECRETO DE LA CASA",100,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CERVEZA 1L",120,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CHOPP",80,15);

INSERT INTO `Info2`.`Articles`
(`NAME`,`PRICE`,`Categorias_idCategorias`)
VALUES
("CAFE COLOMBIANO",60,15);

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
("MatiasG","789456123",1);

INSERT INTO `Info2`.`Users`(`Username`,`Password`,`Admin`)
VALUES
("FacundoL","uss",1);

INSERT INTO `Info2`.`Users`(`Username`,`Password`,`Admin`)
VALUES
("Bernardo","bern",0);