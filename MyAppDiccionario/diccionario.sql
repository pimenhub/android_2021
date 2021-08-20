CREATE DATABASE bd_diccionario;
USE bd_diccionario;
CREATE TABLE tbl_palabra(
	id_palabra INT PRIMARY KEY AUTO_INCREMENT,
	termino_palabra VARCHAR(35) NOT NULL,
	significado_palabra VARCHAR(100) NOT NULL
);
INSERT INTO tbl_palabra (termino_palabra, significado_palabra) VALUES
('Motherboard','La placa base, también conocida como tarjeta madre, placa madre o placa principal, es una tarjeta de circuito impreso a la que se conectan los componentes que constituyen la computadora.'),
('Fuente de Poder','Es un componente del computador que se encarga de transformar una corriente eléctrica alterna en una corriente eléctrica continua para el computador'),
('RAM','La memoria de acceso aleatorio (Random Access Memory, RAM) se utiliza como memoria de trabajo de computadoras y otros dispositivos para el sistema operativo, los programas y la mayor parte del software. '),
('SSD','La unidad de estado sólido o SSD (acrónimo inglés de solid-state drive), también llamado a veces disco de estado sólido pese a carecer de discos físicos, es un tipo de dispositivo de almacenamiento de datos que utiliza memoria no volátil.'),
('CPU','La unidad central de procesamiento es el hardware dentro de una computadora u otros dispositivos programables.');