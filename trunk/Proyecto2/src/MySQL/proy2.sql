DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Categoria;

CREATE TABLE Usuario (
       usuario_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
       usuario VARCHAR (15),
       contrasenia VARCHAR (15),
       PRIMARY KEY (usuario_id)
) ENGINE=InnoDB;

CREATE TABLE Categoria (
       categoria_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
       tc1 VARCHAR (15),
       tc2 VARCHAR (15),
       tc3 VARCHAR (15),
       tc4 VARCHAR (15),
       tc5 VARCHAR (15),
       tc6 VARCHAR (15),
       PRIMARY KEY (categoria_id)
) ENGINE=InnoDB;

CREATE TABLE Cuenta (
       cuenta_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
       user_id SMALLINT UNSIGNED NOT NULL,
       cat_id SMALLINT UNSIGNED NOT NULL,
       titulo VARCHAR (15),
       usuario VARCHAR (15),
       pass VARCHAR (15),
       c1 VARCHAR (15),
       c2 VARCHAR (15),
       c3 VARCHAR (15),
       c4 VARCHAR (15),
       c5 VARCHAR (15),
       c6 VARCHAR (15),
       PRIMARY KEY (cuenta_id)
)ENGINE=InnoDB;

ALTER TABLE Cuenta
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES Usuario (usuario_id),
    ADD CONSTRAINT cat_fk FOREIGN KEY (cat_id) REFERENCES Categoria (categoria_id)