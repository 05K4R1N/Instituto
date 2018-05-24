-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2018 a las 04:24:53
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `instituto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activity`
--

CREATE TABLE IF NOT EXISTS `activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `classroom_id` bigint(20) unsigned NOT NULL,
  `activity_name` varchar(64) NOT NULL,
  `description` text NOT NULL,
  `activity_date` date NOT NULL,
  `activity_time` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `activity`
--

INSERT INTO `activity` (`id`, `classroom_id`, `activity_name`, `description`, `activity_date`, `activity_time`) VALUES
(1, 2, 'Actividad 1', 'Descripcion de la actividad', '2017-01-01', '03:15:00'),
(2, 1, 'Otra actividad', 'Descripcion de la actividad que es nueva.', '2017-01-01', '02:20:00'),
(3, 1, 'Otra actividad', 'Descripcion de la actividad que es nueva.', '2017-01-01', '03:20:00'),
(4, 1, 'acrtividad', 'descripcion', '2017-01-01', '03:20:00'),
(5, 3, 'Actividad', 'descripcion	', '2017-01-01', '04:35:00'),
(6, 1, 'activiad', 'descripcion', '2017-01-01', '03:35:00'),
(7, 2, 'registrado', 'descripcion	', '2017-01-18', '03:25:00'),
(8, 2, 'aldnasd', 'sdfsdf', '2017-01-01', '02:10:00'),
(9, 1, 'ACTIVIDAD', 'DESCRIPC', '2017-01-19', '09:40:00'),
(10, 3, 'Act', 'descripcion', '2017-10-05', '03:20:00'),
(11, 2, 'Actividad de Ejemplo', 'Este es una actividAD DE EJEMPLO', '2018-05-13', '02:30:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type_personal` varchar(64) NOT NULL,
  `personal_id` int(11) unsigned NOT NULL,
  `attendance_status` varchar(64) NOT NULL,
  `time_enter` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `attendance`
--

INSERT INTO `attendance` (`id`, `type_personal`, `personal_id`, `attendance_status`, `time_enter`) VALUES
(1, 'principal', 1, 'Asistido', '2018-05-24 02:11:43'),
(2, 'principal', 1, 'Asistido', '2018-05-24 02:15:04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `classroom`
--

CREATE TABLE IF NOT EXISTS `classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `occupied` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `classroom`
--

INSERT INTO `classroom` (`id`, `name`, `capacity`, `occupied`) VALUES
(1, 'AULA A', 50, 20),
(2, 'AULA B', 70, 35),
(3, 'AULA C', 100, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `classroom_id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `moment` datetime NOT NULL,
  `resend` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `classroom_id` (`classroom_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `message`
--

INSERT INTO `message` (`id`, `teacher_id`, `classroom_id`, `title`, `content`, `moment`, `resend`) VALUES
(1, 2, 2, 'Mensaje de Urgencia', 'Este es un ,mensaje de urgenvcia para Jose Figueroa!! RESPONDE!', '2018-05-11 02:48:57', 2),
(2, 1, 3, 'Buenos Dias', 'Este es un mensaje para utede deseandole un buen dia para usted y sus alumnos para que todo este en orden. Saludos!', '2018-05-11 02:55:54', 0),
(3, 1, 3, 'LOL', 'este es una prueba nada mas', '2018-05-11 03:05:07', 3),
(8, 2, 2, 'Titulo', '', '2018-05-11 03:09:09', 1),
(9, 2, 2, 'correccion', 'esto fue una correccion', '2018-05-11 03:16:05', 3),
(10, 2, 2, 'lol', 'sdfs', '2018-05-11 03:17:06', 2),
(12, 1, 1, 'new tedt', 'dsfsdf', '2018-05-11 03:19:34', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `identity` int(11) NOT NULL,
  `birthplace` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `principal`
--

CREATE TABLE IF NOT EXISTS `principal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `address` varchar(256) NOT NULL,
  `date_of_birth` date NOT NULL,
  `ci` int(16) NOT NULL,
  `code` int(11) unsigned NOT NULL,
  `photo` varchar(128) DEFAULT NULL,
  `username` varchar(128) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `principal`
--

INSERT INTO `principal` (`id`, `name`, `lastname`, `sex`, `address`, `date_of_birth`, `ci`, `code`, `photo`, `username`, `password`) VALUES
(1, 'Roberto Carlos', 'Villegas Laure', 'M', 'C. Tumusla #433', '2014-05-07', 2222, 235, 'director_1.jpg', 'aaa', 'bbb');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `birthday` date NOT NULL,
  `ci` int(11) NOT NULL,
  `code` int(11) unsigned NOT NULL,
  `address` varchar(64) NOT NULL,
  `phone` int(11) NOT NULL,
  `cellphone` int(11) NOT NULL,
  `classroom` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `student`
--

INSERT INTO `student` (`id`, `name`, `lastname`, `birthday`, `ci`, `code`, `address`, `phone`, `cellphone`, `classroom`) VALUES
(1, 'Mariela', 'Vargas', '2009-05-22', 4554883, 0, 'C. Jordan #432', 3435353, 79483822, 'AULA A'),
(2, 'Mijail', 'Tordoya', '2008-03-29', 4857383, 0, 'Av. Heroinas #4323', 34833211, 694839392, 'AULA B'),
(3, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(4, 'Miguelina', 'Sanchez', '2004-02-11', 958321, 0, 'Av. Heroina #212', 9583202, 5968483, 'AULA A'),
(5, 'Sonia', 'Hidalgo', '2007-05-10', 4214212, 0, 'C. Suipacha #211', 6483292, 354442, 'AULA A'),
(6, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(7, 'Miguelina', 'Sanchez', '2004-02-11', 95128321, 0, 'Av. Heroina #212', 9533202, 54343283, 'AULA A'),
(8, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(9, 'Miguelina', 'Sanchez', '2004-02-11', 95128321, 0, 'Av. Heroina #212', 9533202, 54343283, 'AULA A'),
(10, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(11, 'Miguelina', 'Sanchez', '2004-02-11', 95128321, 0, 'Av. Heroina #212', 9533202, 54343283, 'AULA A'),
(12, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(13, 'Miguelina', 'Sanchez', '2004-02-11', 95128321, 0, 'Av. Heroina #212', 9533202, 54343283, 'AULA A'),
(14, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(15, 'Miguelina', 'Sanchez', '2004-02-11', 95128321, 0, 'Av. Heroina #212', 9533202, 54343283, 'AULA A'),
(16, 'Patricia', 'Foronda', '2007-03-30', 4833992, 0, 'C. Tumusla #421', 3948392, 5068499, 'AULA A'),
(17, 'Miguelina', 'Sanchez', '2004-02-11', 95128321, 0, 'Av. Heroina #212', 9533202, 54343283, 'AULA A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `schedules` varchar(512) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `subject`
--

INSERT INTO `subject` (`id`, `teacher_id`, `name`, `description`, `schedules`) VALUES
(1, 1, 'Matematicas', '...................', ''),
(2, 1, 'Literatura', '...................', ''),
(3, 1, 'Geologia', '...................', ''),
(4, 1, 'Geologia', '...................', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `code` int(11) unsigned NOT NULL,
  `place_birth` varchar(25) NOT NULL,
  `photo` longtext,
  `username` varchar(128) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `teacher`
--

INSERT INTO `teacher` (`id`, `first_name`, `last_name`, `address`, `birthday`, `code`, `place_birth`, `photo`, `username`, `password`) VALUES
(1, 'Edgar', 'Montanio', 'Av. Villazon #231', '2015-11-12', 111, 'Cochabamba', 'photo1.jpg', 'xxx', '111'),
(2, 'Jose', 'Figueroa', 'C. Tumusla #433', '2005-05-12', 0, 'Sucre', 'photo2.jpg', 'yyy', '222');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher_classroom`
--

CREATE TABLE IF NOT EXISTS `teacher_classroom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `classroom_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `classroom_id` (`classroom_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `teacher_classroom`
--

INSERT INTO `teacher_classroom` (`id`, `teacher_id`, `classroom_id`) VALUES
(1, 1, 1),
(2, 1, 3),
(3, 2, 1),
(4, 2, 2),
(5, 2, 3);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`);

--
-- Filtros para la tabla `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`);

--
-- Filtros para la tabla `teacher_classroom`
--
ALTER TABLE `teacher_classroom`
  ADD CONSTRAINT `teacher_classroom_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  ADD CONSTRAINT `teacher_classroom_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
