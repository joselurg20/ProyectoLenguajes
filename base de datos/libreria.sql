-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2023 a las 10:34:43
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estanteria`
--

CREATE TABLE `estanteria` (
  `isbn` int(11) NOT NULL,
  `genero` varchar(255) NOT NULL,
  `idoma` double DEFAULT NULL,
  `isbn_libro` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estanteria_libro`
--

CREATE TABLE `estanteria_libro` (
  `estanteria_isbn` int(11) NOT NULL,
  `libro_ibsn` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `isbn` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `nombre`, `precio`) VALUES
(1, 'El quijote', 15.3),
(2, 'La celestina', 30.5),
(3, 'Lazarillo de tormes', 40),
(4, 'La chica del tren\r\n', 6.95);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_estanteria`
--

CREATE TABLE `libro_estanteria` (
  `libro_isbn` int(11) NOT NULL,
  `estanteria_isbn` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estanteria`
--
ALTER TABLE `estanteria`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `estanteria_libro`
--
ALTER TABLE `estanteria_libro`
  ADD PRIMARY KEY (`estanteria_isbn`,`libro_ibsn`),
  ADD KEY `FKq9aqvqibd54qaq5t47j4gyoro` (`libro_ibsn`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `libro_estanteria`
--
ALTER TABLE `libro_estanteria`
  ADD KEY `FKci7st8ulcse69xoxrgn9guq8i` (`estanteria_isbn`),
  ADD KEY `FKjjqfda4e4oydn6d3h1mte7dyb` (`libro_isbn`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estanteria`
--
ALTER TABLE `estanteria`
  MODIFY `isbn` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `isbn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
