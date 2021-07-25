create database banco_idat; 
use banco_idat;

CREATE TABLE cliente ( n_cuenta int(11) NOT NULL, nombre varchar(30) NOT NULL, apellido varchar(40) NOT NULL, dni varchar(8) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- -- Volcado de datos para la tabla cliente
INSERT INTO cliente (n_cuenta, nombre, apellido, dni) VALUES (1, 'daniel', 'calzada', '25805514'), (2, 'cecilia', 'arias', '09903285'), (3, 'juan', 'perez', '23568947'), (4, 'julio', 'iglesias', '89562325'), (5, 'maria', 'quispe', '09903285');

-- -- Estructura de tabla para la tabla depositos
CREATE TABLE depositos ( id int(11) NOT NULL, fecha date NOT NULL, monto int(11) NOT NULL, cliente int(11) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- -- Volcado de datos para la tabla depositos
INSERT INTO depositos (id, fecha, monto, cliente) VALUES (1, '2017-02-01', 1000, 1), (2, '2017-02-02', 500, 1), (3, '2017-02-01', 2500, 2), (4, '2017-02-02', 500, 2), (13, '2017-02-01', 666, 3), (14, '2017-02-10', 333, 4), (15, '2017-02-01', 500, 3), (16, '2017-02-01', 300, 2);

-- -- Estructura de tabla para la tabla retiros
CREATE TABLE retiros ( id int(11) NOT NULL, fecha date NOT NULL, monto int(11) NOT NULL, cliente int(11) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- -- Volcado de datos para la tabla retiros
INSERT INTO retiros (id, fecha, monto, cliente) VALUES (1, '2017-02-18', 100, 1), (2, '2017-02-25', 100, 1), (3, '2017-02-18', 500, 2), (4, '2017-02-25', 100, 2);

-- -- Índices para tablas volcadas
-- -- Indices de la tabla cliente
ALTER TABLE cliente ADD PRIMARY KEY (n_cuenta);

-- -- Indices de la tabla depositos
ALTER TABLE depositos ADD PRIMARY KEY (id), ADD KEY cliente (cliente), ADD KEY cliente_2 (cliente);

-- -- Indices de la tabla retiros
ALTER TABLE retiros ADD PRIMARY KEY (id), ADD KEY cliente (cliente), ADD KEY cliente_2 (cliente);

-- -- AUTO_INCREMENT de las tablas volcadas
-- -- AUTO_INCREMENT de la tabla depositos
ALTER TABLE depositos MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

-- -- AUTO_INCREMENT de la tabla retiros
ALTER TABLE retiros MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

-- -- Restricciones para tablas volcadas
-- -- Filtros para la tabla depositos
ALTER TABLE depositos ADD CONSTRAINT depositos_ibfk_1 FOREIGN KEY (cliente) REFERENCES cliente (n_cuenta) ON DELETE CASCADE ON UPDATE CASCADE;

-- -- Filtros para la tabla retiros
ALTER TABLE retiros ADD CONSTRAINT retiros_ibfk_1 FOREIGN KEY (cliente) REFERENCES cliente (n_cuenta) ON DELETE CASCADE ON UPDATE CASCADE; COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT /; 
/!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS /; 
/!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
