
CREATE DATABASE  IF NOT EXISTS `pruebas` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pruebas`;

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pruebas
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `empno` int(11) NOT NULL,
  `ename` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `sal` int(11) DEFAULT NULL,
  `comm` int(11) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `idx_empleado_empno` (`empno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Aaron','PINCHE',NULL,'2017-02-15 11:09:47',600,NULL,1),(2,'Eneko','CHEFF',NULL,'2017-02-15 11:09:47',1300,NULL,1),(3,'Itsaso','JEFE COCINA',NULL,'2017-02-15 11:17:41',3000,300,2),(4,'IVAN','REPARTIDOR',NULL,'2017-02-15 11:17:41',2000,500,3),(5,'Guillermo','PINCHE',NULL,'2017-02-15 11:17:41',400,40,1),(6,'Lozoya','COMERCIAL',NULL,'2017-02-15 11:17:41',1500,100,4),(7,'Josu','DIETISTA',NULL,'2017-02-15 11:17:41',2000,250,2),(8,'Ignacio','CAMARERO',NULL,'2017-02-15 11:17:41',1500,200,1),(9,'Gomez','COMERCIAL',NULL,'2017-02-15 11:17:41',1500,100,4),(10,'Nagore','CHEFF',NULL,'2017-02-15 11:17:41',1500,300,1),(11,'Garbiñe','CAMARERO',NULL,'2017-02-15 11:17:41',1800,20,1),(12,'Egoitz','PINCHE',NULL,'2017-02-15 11:17:41',500,0,1),(13,'Pavel','COCINERO',NULL,'2017-02-15 11:17:41',1600,100,1),(14,'Perez','PINCHE',NULL,'2017-02-15 11:17:41',500,0,1),(15,'Ander','EMPRESARIO',NULL,'2017-02-15 11:17:41',3000,500,4),(16,NULL,NULL,NULL,'2017-02-15 11:17:41',NULL,NULL,NULL);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-15 12:18:31
