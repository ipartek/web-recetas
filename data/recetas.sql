-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: recetas
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
-- Temporary view structure for view `checff_recetas_left_join`
--

DROP TABLE IF EXISTS `checff_recetas_left_join`;
/*!50001 DROP VIEW IF EXISTS `checff_recetas_left_join`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `checff_recetas_left_join` AS SELECT 
 1 AS `cheff`,
 1 AS `receta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cheff_recetas_inner_join`
--

DROP TABLE IF EXISTS `cheff_recetas_inner_join`;
/*!50001 DROP VIEW IF EXISTS `cheff_recetas_inner_join`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cheff_recetas_inner_join` AS SELECT 
 1 AS `cheff`,
 1 AS `receta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cheff_recetas_sin_inner_join`
--

DROP TABLE IF EXISTS `cheff_recetas_sin_inner_join`;
/*!50001 DROP VIEW IF EXISTS `cheff_recetas_sin_inner_join`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `cheff_recetas_sin_inner_join` AS SELECT 
 1 AS `cheff`,
 1 AS `receta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `contar_recetas`
--

DROP TABLE IF EXISTS `contar_recetas`;
/*!50001 DROP VIEW IF EXISTS `contar_recetas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `contar_recetas` AS SELECT 
 1 AS `COUNT(*)`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `gluten` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idtable1_UNIQUE` (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,'garbanzos',0),(2,'muslo de pollo',0),(3,'carcasa de pollo',0),(4,'cebollas',0),(5,'cebolletas',0),(6,'dientes de ajo',0),(7,'queso gruyer',0),(8,'aceite de oliva virgen extra',0),(9,'tomillo',0),(10,'sal',0),(11,'perejil',0),(12,'solomillo de ternera',0),(13,'hojaldre',0),(14,'huevo',0),(15,'paté a las finas hierbas',0),(16,'zanahoria',0),(17,'puerro',0),(18,'apio',0),(19,'vino tinto',0),(20,'sésamo blanco y negro',1),(21,'harina',1),(22,'pimienta',0),(23,'anchoas abiertas en libro',0),(24,'pimientos verdes',0),(25,'vinagre de sidra',0);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `ingrediente_sopa_cebolla`
--

DROP TABLE IF EXISTS `ingrediente_sopa_cebolla`;
/*!50001 DROP VIEW IF EXISTS `ingrediente_sopa_cebolla`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ingrediente_sopa_cebolla` AS SELECT 
 1 AS `ingrediente`,
 1 AS `cantidad`,
 1 AS `gluten`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `descripcion` text NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_receta_usuario_idx` (`usuario_id`),
  CONSTRAINT `fk_receta_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,'Sopa de cebolla','http://tucocinafacil.net/wp-content/uploads/2011/04/sopa-cebolla.jpg','Pon los garbanzos a remojo de víspera.<br>Para hacer el caldo, pon abundante agua a calentar en la olla rápida. Cuando empiece a hervir, agrega los garbanzos escurridos y la rama de tomillo. Pela y trocea las cebollas y los dientes de ajo y añádelos. Incorpora el muslo de pollo, la carcasa y unas ramas de perejil. Pon apunto de sal. Coloca la tapa y cuece todo durante 20 minutos. Cuela el caldo y resérvalo. (Reserva el pollo y los garbanzos para otra ocasión).<br>Pela y pica las cebolletas en juliana fina y ponlas a pochar en una cazuela grande con un chorrito de aceite. Cocínalas hasta que queden bien pochadas. Sazona, vierte el caldo y cocina todo durante 20 minutos más.<br>Reparte la sopa en 4 cuencos aptos para el horno. Ralla encima el queso y gratínalos. Sirve y adorna unas hojas de perejil.',1),(2,'Solomillo en hojaldre','http://recetariosecreto.com/wp-content/uploads/2013/12/solomillo-al-hojaldre-4_tn.jpg','Limpia el solomillo, corta 4 filetes gruesos y salpimiéntalos. Pon a calentar un chorrito de aceite en una sartén grande. Dóralos, retira y deja que se enfríen. Úntalos con el paté de finas hierbas y resérvalos.<br>Estira una lámina de hojaldre y córtala por la mitad de manera que te queden dos rectángulos. Corta 4 tiras finas de cada mitad y resérvalas. Coloca un solomillo en un extremo de cada trozo de hojaldre y tápalos de manera que queden perfectamente cubiertos. Sella los bordes con un tenedor y úntalos con huevo batido. Coloca las tiras en forma de aspa y úntalas con huevo batido. Decora la superficie con sésamo blanco y negro. Realiza la misma operación con la otra lámina de hojaldre de manera que queden los 4 solomillos envueltos. Colócalos en una bandeja de horno forrada con papel de horno y hornea a 200ºC durante 15 minutos.<br>Para la salsa, pela y pica los ajos, la cebolla, el puerro, la zanahoria y el apio en dados y ponlos a pochar en una cazuela con un chorrito de aceite. Sazona. Cuando la verdura esté dorada, agrega la harina y rehógala un poco. Vierte el vino tinto y dale un hervor. Vierte 300 ml de agua y mezcla bien. Deja reducir la salsa y tritúrala.<br>Sirve el solomillo y salsea. Decora con una ramita de perejil.\n\n\n',1),(3,'Anchoas a la papillote','http://www.robinfoodtv.com/documentos/recetas/835.jpg','Pochar en aceite cebolleta + pimiento verde + sal. <br>Limpiar bien las anchoas, quitándoles la cabeza, los interiores y las espinas. <br>Limpiar bien las anchoas, quitándoles la cabeza, los interiores y las espinas. <br> Limpiar bien las anchoas, quitándoles la cabeza, los interiores y las espinas. <br>En una sartén hacer un refrito de aceite + ajos, verterlo sobre las anchoas, desglasar con el vinagre y rociar. <br>Tapar la cazuela y cocer durante 5 minutos a fuego suave. <br>Dejarlas reposar 2 minutos, tapadas y fuera del fuego. <br>Espolvorear con perejil. <br>Servir rápidamente.',3),(4,'tortilla patatas','http://www.recetasderechupete.com/wp-content/uploads/2015/07/TORTILLA-002-525x360.jpg','8 huevos camperos o 10 huevos normales.',4);
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_ingrediente`
--

DROP TABLE IF EXISTS `receta_ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receta_ingrediente` (
  `receta_id` int(11) NOT NULL,
  `ingrediente_id` int(11) NOT NULL,
  `cantidad` varchar(45) NOT NULL DEFAULT 'a ojimetro...',
  PRIMARY KEY (`receta_id`,`ingrediente_id`),
  KEY `fk_receta_has_ingrediente_ingrediente1_idx` (`ingrediente_id`),
  KEY `fk_receta_has_ingrediente_receta1_idx` (`receta_id`),
  CONSTRAINT `fk_receta_has_ingrediente_ingrediente1` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingrediente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receta_has_ingrediente_receta1` FOREIGN KEY (`receta_id`) REFERENCES `receta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_ingrediente`
--

LOCK TABLES `receta_ingrediente` WRITE;
/*!40000 ALTER TABLE `receta_ingrediente` DISABLE KEYS */;
INSERT INTO `receta_ingrediente` VALUES (1,1,'150 gr'),(1,2,'1'),(1,3,'1'),(1,4,'2'),(1,5,'7'),(1,6,'4'),(1,7,'250 gr'),(1,8,'a ojimetro...'),(1,9,'a ojimetro...'),(1,10,'a ojimetro...'),(1,11,'a ojimetro...'),(2,4,'1'),(2,6,'3'),(2,8,'a ojimetro...'),(2,10,'a ojimetro...'),(2,11,'a ojimetro...'),(2,12,'600 gr'),(2,13,'2 láminas'),(2,14,'1'),(2,15,'100 gr'),(2,16,'1'),(2,17,'1'),(2,18,'1'),(2,19,'150 ml'),(2,20,'30 gr'),(2,21,'15 gr'),(2,22,'a ojimetro...'),(3,5,'6'),(3,6,'3'),(3,8,'a ojimetro...'),(3,10,'a ojimetro...'),(3,11,'a ojimetro...'),(3,23,'1 kg'),(3,24,'6'),(3,25,'3 soperas');
/*!40000 ALTER TABLE `receta_ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `recetas_mas_de_5_ingredientes`
--

DROP TABLE IF EXISTS `recetas_mas_de_5_ingredientes`;
/*!50001 DROP VIEW IF EXISTS `recetas_mas_de_5_ingredientes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `recetas_mas_de_5_ingredientes` AS SELECT 
 1 AS `r_nombre`,
 1 AS `numero_ingredientes`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `recetas_sin_gluten`
--

DROP TABLE IF EXISTS `recetas_sin_gluten`;
/*!50001 DROP VIEW IF EXISTS `recetas_sin_gluten`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `recetas_sin_gluten` AS SELECT 
 1 AS `r_nombre`,
 1 AS `ingredientes_con_gluten`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `rectas_con_gluten`
--

DROP TABLE IF EXISTS `rectas_con_gluten`;
/*!50001 DROP VIEW IF EXISTS `rectas_con_gluten`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `rectas_con_gluten` AS SELECT 
 1 AS `r_nombre`,
 1 AS `ingredientes_con_gluten`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ultima_receta`
--

DROP TABLE IF EXISTS `ultima_receta`;
/*!50001 DROP VIEW IF EXISTS `ultima_receta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ultima_receta` AS SELECT 
 1 AS `id`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `ultima_receta_subconsulta`
--

DROP TABLE IF EXISTS `ultima_receta_subconsulta`;
/*!50001 DROP VIEW IF EXISTS `ultima_receta_subconsulta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `ultima_receta_subconsulta` AS SELECT 
 1 AS `id`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL DEFAULT 'https://pbs.twimg.com/profile_images/617295207202209792/P8kGVpP-_reasonably_small.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Karlos Arguiñano','karlos.arguiñano@email.com','123456','http://www.estrelladigital.es/media/estrelladigital/images/2010/06/24/2014022421075998200.jpg'),(2,'Ferran Adria','ferran.adria@email.com','123456','http://www.vivelohoy.com/wp-content/uploads/2011/07/bulli.jpg.jpg'),(3,'Robin Food','robin.food@email.com','123456','http://www.oletusfogones.es/wp-content/uploads/2012/11/robinfood.jpg'),(4,'pinche','pinche@pinche.com','123456','http://estaticos.sport.es/resources/jpg/4/4/los-jugadores-roja-transforman-1398678225044.jpg');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `checff_recetas_left_join`
--

/*!50001 DROP VIEW IF EXISTS `checff_recetas_left_join`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `checff_recetas_left_join` AS select `u`.`nombre` AS `cheff`,`r`.`nombre` AS `receta` from (`usuario` `u` left join `receta` `r` on((`u`.`id` = `r`.`usuario_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cheff_recetas_inner_join`
--

/*!50001 DROP VIEW IF EXISTS `cheff_recetas_inner_join`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cheff_recetas_inner_join` AS select `u`.`nombre` AS `cheff`,`r`.`nombre` AS `receta` from (`usuario` `u` join `receta` `r` on((`u`.`id` = `r`.`usuario_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cheff_recetas_sin_inner_join`
--

/*!50001 DROP VIEW IF EXISTS `cheff_recetas_sin_inner_join`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cheff_recetas_sin_inner_join` AS select `u`.`nombre` AS `cheff`,`r`.`nombre` AS `receta` from (`usuario` `u` join `receta` `r`) where (`u`.`id` = `r`.`usuario_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `contar_recetas`
--

/*!50001 DROP VIEW IF EXISTS `contar_recetas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `contar_recetas` AS select count(0) AS `COUNT(*)` from `receta` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ingrediente_sopa_cebolla`
--

/*!50001 DROP VIEW IF EXISTS `ingrediente_sopa_cebolla`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ingrediente_sopa_cebolla` AS select `i`.`nombre` AS `ingrediente`,`ri`.`cantidad` AS `cantidad`,`i`.`gluten` AS `gluten` from ((`receta` `r` join `ingrediente` `i`) join `receta_ingrediente` `ri`) where ((`r`.`id` = 1) and (`r`.`id` = `ri`.`receta_id`) and (`ri`.`ingrediente_id` = `i`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `recetas_mas_de_5_ingredientes`
--

/*!50001 DROP VIEW IF EXISTS `recetas_mas_de_5_ingredientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `recetas_mas_de_5_ingredientes` AS select `receta`.`nombre` AS `r_nombre`,count(`ingrediente`.`id`) AS `numero_ingredientes` from ((`receta` join `receta_ingrediente`) join `ingrediente`) where ((`receta`.`id` = `receta_ingrediente`.`receta_id`) and (`receta_ingrediente`.`ingrediente_id` = `ingrediente`.`id`)) group by `receta`.`nombre` having (`numero_ingredientes` > 5) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `recetas_sin_gluten`
--

/*!50001 DROP VIEW IF EXISTS `recetas_sin_gluten`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `recetas_sin_gluten` AS select `receta`.`nombre` AS `r_nombre`,sum(`ingrediente`.`gluten`) AS `ingredientes_con_gluten` from ((`receta` join `receta_ingrediente`) join `ingrediente`) where ((`receta`.`id` = `receta_ingrediente`.`receta_id`) and (`receta_ingrediente`.`ingrediente_id` = `ingrediente`.`id`)) group by `receta`.`nombre` having (`ingredientes_con_gluten` <= 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rectas_con_gluten`
--

/*!50001 DROP VIEW IF EXISTS `rectas_con_gluten`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rectas_con_gluten` AS select `receta`.`nombre` AS `r_nombre`,sum(`ingrediente`.`gluten`) AS `ingredientes_con_gluten` from ((`receta` join `receta_ingrediente`) join `ingrediente`) where ((`receta`.`id` = `receta_ingrediente`.`receta_id`) and (`receta_ingrediente`.`ingrediente_id` = `ingrediente`.`id`)) group by `receta`.`nombre` having (`ingredientes_con_gluten` > 0) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ultima_receta`
--

/*!50001 DROP VIEW IF EXISTS `ultima_receta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ultima_receta` AS select `receta`.`id` AS `id`,`receta`.`nombre` AS `nombre` from `receta` order by `receta`.`id` desc limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ultima_receta_subconsulta`
--

/*!50001 DROP VIEW IF EXISTS `ultima_receta_subconsulta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ultima_receta_subconsulta` AS select `receta`.`id` AS `id`,`receta`.`nombre` AS `nombre` from `receta` where (`receta`.`id` = (select max(`receta`.`id`) from `receta`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-16  9:28:51
