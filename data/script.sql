-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2017 a las 08:36:02
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concesionario`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `comprobarIntegridad` (IN `pEmail` VARCHAR(255), IN `pDni` VARCHAR(9), IN `pId` INT)  NO SQL
BEGIN

SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` 
FROM `usuario` 
WHERE ( `id` <> pId ) AND ( `dni` = pDni OR `email` = pEmail );

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `usuarioBuscarByDni` (IN `pDni` VARCHAR(9) CHARSET utf8)  NO SQL
    COMMENT 'Rutina para buscar una persona por dni'
BEGIN

SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` 
FROM `usuario` 
WHERE `dni` = pDni;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellido1` varchar(150) NOT NULL,
  `apellido2` varchar(150) NOT NULL,
  `edad` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `puesto` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`, `password`, `imagen`) VALUES
(1, 'Mongomeri', 'Burn', 'Burn', 123, 'admin@admin.com', '00000000T', 'ADMINISTRADOR', '123', 'http://journeyhomeburke.files.wordpress.com/2007/05/350729-mrburns.gif'),
(2, 'Homer', 'Simpsom2', 'Simpsom2', 42, 'homer@homar.com', '11111111H', 'EMPLEADO', '123', 'https://s3.amazonaws.com/rapgenius/Homer_Simpson_Vector_by_bark2008.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id` int(11) NOT NULL,
  `modelo` varchar(250) NOT NULL,
  `plazas` int(11) NOT NULL,
  `potencia` float NOT NULL COMMENT 'potencia del vehiculo en cv'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES
(1, 'seat', 5, 100),
(2, 'opel astra', 5, 500),
(3, 'Ferrari F40', 5, 1500),
(5, 'Sinca 1000', 5, 1500),
(6, 'Lamborgini', 2, 5000),
(7, 'creado', 3, 450),
(8, 'Nissan Vanette', 10, 120);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
