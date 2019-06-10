# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.1.46-community
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3731
# Date/time:                    2011-10-24 14:32:44
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for sistematrajes
CREATE DATABASE IF NOT EXISTS `sistematrajes` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistematrajes`;


# Dumping structure for table sistematrajes.accesorios
CREATE TABLE IF NOT EXISTS `accesorios` (
  `ID` int(10) NOT NULL,
  `NUM_EJEMPLAR` int(5) NOT NULL,
  `TALLA` varchar(5) DEFAULT NULL,
  `TARO_ID` int(2) NOT NULL,
  `FARO_ID` int(2) NOT NULL,
  `CARO_ID` int(2) NOT NULL,
  `MARO_ID` int(2) NOT NULL,
  `UBN_ID` int(2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_accesorios_tipo_accesorios` (`TARO_ID`),
  KEY `FK_accesorios_forma_accesorios` (`FARO_ID`),
  KEY `FK_accesorios_color_accesorios` (`CARO_ID`),
  KEY `FK_accesorios_marca_accesorios` (`MARO_ID`),
  KEY `FK_accesorios_ubicaciones` (`UBN_ID`),
  CONSTRAINT `FK_accesorios_color_accesorios` FOREIGN KEY (`CARO_ID`) REFERENCES `color_accesorios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_accesorios_forma_accesorios` FOREIGN KEY (`FARO_ID`) REFERENCES `forma_accesorios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_accesorios_marca_accesorios` FOREIGN KEY (`MARO_ID`) REFERENCES `marca_accesorios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_accesorios_tipo_accesorios` FOREIGN KEY (`TARO_ID`) REFERENCES `tipo_accesorios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_accesorios_ubicaciones` FOREIGN KEY (`UBN_ID`) REFERENCES `ubicaciones` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `CEDULA` varchar(10) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `DIRECCION` varchar(100) NOT NULL,
  `TELEFONO1` varchar(15) NOT NULL,
  `TELEFONO2` varchar(15) DEFAULT '',
  `CORREO` varchar(50) DEFAULT '',
  `RIF` varchar(15) DEFAULT '',
  PRIMARY KEY (`CEDULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.color_accesorios
CREATE TABLE IF NOT EXISTS `color_accesorios` (
  `ID` int(2) NOT NULL,
  `COLOR1` varchar(20) NOT NULL,
  `COLOR2` varchar(20) DEFAULT NULL,
  `COLOR3` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.contratos
CREATE TABLE IF NOT EXISTS `contratos` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `FECHA_EMISION` date DEFAULT NULL,
  `FECHA_ENTREGA` date DEFAULT NULL,
  `FECHA_DEVOLUCION` date DEFAULT NULL,
  `TOTAL_PAGAR` float(15,3) DEFAULT NULL,
  `ESTADO` varchar(50) NOT NULL,
  `CTE_CEDULA` varchar(10) NOT NULL,
  `TDA_ID` int(2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_contratos_clientes` (`CTE_CEDULA`),
  KEY `FK_contratos_tiendas` (`TDA_ID`),
  CONSTRAINT `FK_contratos_clientes` FOREIGN KEY (`CTE_CEDULA`) REFERENCES `clientes` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_contratos_tiendas` FOREIGN KEY (`TDA_ID`) REFERENCES `tiendas` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.forma_accesorios
CREATE TABLE IF NOT EXISTS `forma_accesorios` (
  `ID` int(2) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.items
CREATE TABLE IF NOT EXISTS `items` (
  `ID` int(10) NOT NULL,
  `CANTIDAD` int(3) NOT NULL,
  `PRECIO` float(10,3) NOT NULL,
  `CTO_ID` int(10) NOT NULL,
  `ARO_ID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_items_contratos` (`CTO_ID`),
  KEY `FK_items_accesorios` (`ARO_ID`),
  CONSTRAINT `FK_items_contratos` FOREIGN KEY (`CTO_ID`) REFERENCES `contratos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_items_accesorios` FOREIGN KEY (`ARO_ID`) REFERENCES `accesorios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.marca_accesorios
CREATE TABLE IF NOT EXISTS `marca_accesorios` (
  `ID` int(2) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.motivos
CREATE TABLE IF NOT EXISTS `motivos` (
  `ID` int(2) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.observaciones
CREATE TABLE IF NOT EXISTS `observaciones` (
  `ID` int(10) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  `CTO_ID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_observaciones_contratos` (`CTO_ID`),
  CONSTRAINT `FK_observaciones_contratos` FOREIGN KEY (`CTO_ID`) REFERENCES `contratos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.pagos
CREATE TABLE IF NOT EXISTS `pagos` (
  `ID` int(10) NOT NULL,
  `OBSERVACION` varchar(100) DEFAULT NULL,
  `MONTO` float(10,3) DEFAULT NULL,
  `FECHA` date NOT NULL,
  `CTO_ID` int(10) NOT NULL,
  `TPGO_ID` int(2) NOT NULL,
  `MVO_ID` int(2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_pagos_contratos` (`CTO_ID`),
  KEY `FK_pagos_tipos_pago` (`TPGO_ID`),
  KEY `FK_pagos_motivos` (`MVO_ID`),
  CONSTRAINT `FK_pagos_contratos` FOREIGN KEY (`CTO_ID`) REFERENCES `contratos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pagos_tipos_pago` FOREIGN KEY (`TPGO_ID`) REFERENCES `tipos_pago` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_pagos_motivos` FOREIGN KEY (`MVO_ID`) REFERENCES `motivos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.tiendas
CREATE TABLE IF NOT EXISTS `tiendas` (
  `ID` int(2) NOT NULL,
  `NOMBRE` varchar(25) NOT NULL,
  `RIF` varchar(15) NOT NULL,
  `DIRECCION` varchar(100) NOT NULL,
  `TELEFONO1` varchar(15) NOT NULL,
  `TELEFONO2` varchar(15) DEFAULT NULL,
  `CORREO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NOMBRE` (`NOMBRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.tipos_pago
CREATE TABLE IF NOT EXISTS `tipos_pago` (
  `ID` int(2) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.tipo_accesorios
CREATE TABLE IF NOT EXISTS `tipo_accesorios` (
  `ID` int(2) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table sistematrajes.ubicaciones
CREATE TABLE IF NOT EXISTS `ubicaciones` (
  `ID` int(2) NOT NULL,
  `DESCRIPCION` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
