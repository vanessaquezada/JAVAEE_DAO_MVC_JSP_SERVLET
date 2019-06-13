-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.37-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para empleadoscds
CREATE DATABASE IF NOT EXISTS `empleadoscds` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `empleadoscds`;

-- Volcando estructura para tabla empleadoscds.personas
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT '0',
  `apellidos` varchar(50) DEFAULT '0',
  `edad` int(11) DEFAULT '0',
  `direccion` varchar(100) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla empleadoscds.personas: ~2 rows (aproximadamente)
DELETE FROM `personas`;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`id`, `nombre`, `apellidos`, `edad`, `direccion`) VALUES
	(1, 'Juan', 'Perez', 18, 'nada'),
	(2, 'Emily', 'Diaz', 19, 'nada');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;

-- Volcando estructura para tabla empleadoscds.trabajador
CREATE TABLE IF NOT EXISTS `trabajador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  `email` varchar(100) NOT NULL DEFAULT '0',
  `cargo` varchar(100) NOT NULL DEFAULT '0',
  `direccion` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='tabla que contiene todos los empleados';

-- Volcando datos para la tabla empleadoscds.trabajador: ~12 rows (aproximadamente)
DELETE FROM `trabajador`;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` (`id`, `nombre`, `email`, `cargo`, `direccion`) VALUES
	(1, 'Luis', 'luis.rodriguez@gmail.com', 'Alferes', 'Bo. El Centro, 2-6'),
	(2, 'karina', 'karina.russell@popffets.org', 'vendedora', 'col.santa rita #22'),
	(3, 'katheryn', 'kathy.martinez@procesal.sv', 'rectora', 'paseo General Escalon N523'),
	(4, 'Josselyn', 'josselyn.herrera@financiera.com', 'cajera', 'colonia altos del pino'),
	(6, 'Yeimi', 'yeimi.martinez@muni.sv', 'inspectora', 'pacifica n23'),
	(7, 'keyla', 'keyla.maria@telux.com', 'recepcionista', 'residencial universitaria'),
	(8, 'Eunice', 'eunice.rosas@interchange.org', 'Interpolador', 'colonia masfererr'),
	(9, 'Michelle', 'michelle.moran@pilotos.sv', 'piloto de riesgo', 'bo la vega'),
	(10, 'Johanna', 'johanna.merino@oneclick.sv', 'interlocutora', 'colonia el trebol'),
	(11, 'Libny', 'libny.azurdia@docentes.org', 'docente', 'zona 6 chimaltenango'),
	(12, 'Sindy', 'sindy.azurdia@clinica.org', 'enfermera', 'zona 6 chimaltenango'),
	(16, 'Jessica', 'jessica.hernandez@comercial.com', 'Rutera', 'santa gertrudis');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
