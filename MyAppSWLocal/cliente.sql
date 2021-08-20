CREATE DATABASE bd_cliente;
USE bd_cliente;
CREATE TABLE tbl_cliente(
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
	nombre_cliente VARCHAR(25) NOT NULL,
	apellido_cliente VARCHAR(25) NOT NULL,
	telefono_cliente INT NOT NULL,
	direccion_cliente VARCHAR(55)
);

SELECT * FROM tbl_cliente;