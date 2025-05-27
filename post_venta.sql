-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2025 a las 10:08:47
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `post_venta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devoluciones`
--

CREATE TABLE `devoluciones` (
  `id_devoluciones` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `devoluciones`
--

INSERT INTO `devoluciones` (`id_devoluciones`, `descripcion`, `estado`, `fecha`, `id_venta`) VALUES
(1, 'El producto llegó dañado en el empaque y el contenido derramado.', 1, '2025-05-27', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`) VALUES
(1, 'Chanel N°5 Eau de Parfum'),
(2, 'Dior Sauvage Eau de Toilette'),
(3, 'Versace Eros Eau de Parfum'),
(4, 'Giorgio Armani Acqua di Gio Profumo'),
(5, 'Yves Saint Laurent Black Opium'),
(6, 'Gucci Bloom Eau de Parfum'),
(7, 'Tom Ford Black Orchid'),
(8, 'Paco Rabanne 1 Million'),
(9, 'Carolina Herrera Good Girl'),
(10, 'Jo Malone English Pear & Freesia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reclamos`
--

CREATE TABLE `reclamos` (
  `id_reclamos` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reclamos`
--

INSERT INTO `reclamos` (`id_reclamos`, `descripcion`, `fecha`, `id_usuario`) VALUES
(2, 'El frasco del perfume llegó roto o con fugas.', '2025-05-26', 1),
(3, 'El tamaño del perfume es menor al indicado en la descripción.', '2025-05-26', 2),
(4, 'La fragancia no dura el tiempo esperado en la piel.', '2025-05-26', 3),
(5, 'El pedido de perfume llegó con un retraso significativo.', '2025-05-26', 4),
(6, 'Falta la caja original del perfume o viene dañada.', '2025-05-26', 10),
(7, 'Recibí un perfume que parece ser una imitación.', '2025-05-26', 7),
(8, 'Problemas con el atomizador del perfume, no rocía bien.', '2025-05-26', 6),
(9, 'El perfume causó una reacción alérgica.', '2025-05-26', 3),
(10, 'No se incluyó la muestra gratuita prometida con la compra.', '2025-05-26', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `contrasenna` varchar(40) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `p_apellido` varchar(30) NOT NULL,
  `permiso` int(11) NOT NULL,
  `rut` varchar(13) NOT NULL,
  `s_apellido` varchar(30) NOT NULL,
  `usuario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `contrasenna`, `correo`, `direccion`, `nombre`, `p_apellido`, `permiso`, `rut`, `s_apellido`, `usuario`) VALUES
(1, 'pass_user1', 'user1@example.com', '101 Maple St', 'Alice', 'Smith', 0, '11111111-1', 'Jones', 'alice_s'),
(2, 'pass_user2', 'user2@example.com', '202 Oak Ave', 'Bob', 'Johnson', 0, '22222222-2', 'Davis', 'bob_j'),
(3, 'pass_user3', 'user3@example.com', '303 Pine Rd', 'Charlie', 'Brown', 0, '33333333-3', 'Miller', 'charlie_b'),
(4, 'pass_user4', 'user4@example.com', '404 Birch Ln', 'Diana', 'Garcia', 0, '44444444-4', 'Wilson', 'diana_g'),
(5, 'pass_user5', 'user5@example.com', '505 Cedar Ct', 'Eve', 'Martinez', 0, '55555555-5', 'Taylor', 'eve_m'),
(6, 'pass_user6', 'user6@example.com', '606 Elm St', 'Frank', 'Rodriguez', 0, '66666666-6', 'Anderson', 'frank_r'),
(7, 'pass_user7', 'user7@example.com', '707 Fir Ave', 'Grace', 'Hernandez', 0, '77777777-7', 'Thomas', 'grace_h'),
(8, 'pass_user8', 'user8@example.com', '808 Spruce Rd', 'Harry', 'Lopez', 0, '88888888-8', 'Jackson', 'harry_l'),
(9, 'pass_user9', 'user9@example.com', '909 Willow Ln', 'Ivy', 'Gonzalez', 0, '99999999-9', 'White', 'ivy_g'),
(10, 'pass_user10', 'user10@example.com', '1010 Poplar Ct', 'Jack', 'Perez', 0, '10101010-0', 'Harris', 'jack_p');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_venta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `fecha`, `id_producto`, `id_usuario`) VALUES
(1, '2025-05-27', 9, 1),
(2, '2025-05-26', 3, 2),
(4, '2025-05-25', 7, 3),
(5, '2025-05-27', 2, 4),
(6, '2025-05-25', 3, 3),
(7, '2025-05-25', 3, 3),
(8, '2025-05-27', 2, 4),
(9, '2025-05-24', 10, 2),
(10, '2025-05-26', 5, 1),
(11, '2025-05-27', 1, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD PRIMARY KEY (`id_devoluciones`),
  ADD KEY `FK2ehd61fdvcsqsukmrsb92mxeo` (`id_venta`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `reclamos`
--
ALTER TABLE `reclamos`
  ADD PRIMARY KEY (`id_reclamos`),
  ADD KEY `FK2y74hj0cxwise318v3egcj5ku` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `FKtdy58b433j3dwlmi6o68veq5s` (`id_producto`),
  ADD KEY `FKs1e24qvpvrwawa5flxlj4r594` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  MODIFY `id_devoluciones` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `reclamos`
--
ALTER TABLE `reclamos`
  MODIFY `id_reclamos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD CONSTRAINT `FK2ehd61fdvcsqsukmrsb92mxeo` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`);

--
-- Filtros para la tabla `reclamos`
--
ALTER TABLE `reclamos`
  ADD CONSTRAINT `FK2y74hj0cxwise318v3egcj5ku` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FKs1e24qvpvrwawa5flxlj4r594` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `FKtdy58b433j3dwlmi6o68veq5s` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
