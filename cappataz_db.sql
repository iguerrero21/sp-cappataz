-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sp_cappataz
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animales`
--

DROP TABLE IF EXISTS `animales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animales` (
  `idAnimal` int NOT NULL AUTO_INCREMENT,
  `tagIdentificacion` varchar(100) NOT NULL,
  `tagRFID` varchar(100) DEFAULT NULL,
  `especie` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `raza` varchar(50) NOT NULL,
  `castrado` tinyint(1) NOT NULL DEFAULT '0',
  `idCategoria` int DEFAULT NULL,
  `idLote` int DEFAULT NULL,
  `idPropietario` int DEFAULT NULL,
  PRIMARY KEY (`idAnimal`),
  UNIQUE KEY `tagIdentificacion` (`tagIdentificacion`),
  UNIQUE KEY `tagRFID` (`tagRFID`),
  KEY `fechaNacimiento` (`fechaNacimiento`),
  KEY `idCategoria` (`idCategoria`),
  KEY `idLote` (`idLote`),
  KEY `idPropietario` (`idPropietario`),
  CONSTRAINT `animales_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`),
  CONSTRAINT `animales_ibfk_2` FOREIGN KEY (`idLote`) REFERENCES `lotes` (`idLote`) ON DELETE SET NULL,
  CONSTRAINT `animales_ibfk_3` FOREIGN KEY (`idPropietario`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `animales_chk_1` CHECK ((`sexo` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB AUTO_INCREMENT=1420 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animales`
--

LOCK TABLES `animales` WRITE;
/*!40000 ALTER TABLE `animales` DISABLE KEYS */;
INSERT INTO `animales` VALUES (1,'TagACV001','RFIDACV001','Bovino','2020-09-09','F','Angus Colorado',0,1,1,3),(2,'TagACV002','RFIDACV002','Bovino','2021-04-10','F','Angus Colorado',0,1,1,3),(3,'TagACV003','RFIDACV003','Bovino','2019-04-21','F','Angus Colorado',0,1,1,3),(4,'TagACV004','RFIDACV004','Bovino','2019-09-07','F','Angus Colorado',0,1,1,3),(5,'TagACV005','RFIDACV005','Bovino','2021-07-06','F','Angus Colorado',0,1,1,3),(6,'TagACV006','RFIDACV006','Bovino','2020-07-06','F','Angus Colorado',0,1,1,3),(7,'TagACV007','RFIDACV007','Bovino','2019-01-09','F','Angus Colorado',0,1,1,3),(8,'TagACV008','RFIDACV008','Bovino','2020-07-31','F','Angus Colorado',0,1,1,3),(9,'TagACV009','RFIDACV009','Bovino','2020-11-04','F','Angus Colorado',0,1,1,3),(10,'TagACV010','RFIDACV010','Bovino','2020-06-21','F','Angus Colorado',0,1,1,3),(11,'TagACV011','RFIDACV011','Bovino','2020-10-28','F','Angus Colorado',0,1,1,3),(12,'TagACV012','RFIDACV012','Bovino','2020-09-18','F','Angus Colorado',0,1,1,3),(13,'TagACV013','RFIDACV013','Bovino','2019-02-08','F','Angus Colorado',0,1,1,3),(14,'TagACV014','RFIDACV014','Bovino','2020-05-15','F','Angus Colorado',0,1,1,3),(15,'TagACV015','RFIDACV015','Bovino','2019-07-18','F','Angus Colorado',0,1,1,3),(16,'TagACV016','RFIDACV016','Bovino','2020-08-09','F','Angus Colorado',0,1,1,3),(17,'TagACV017','RFIDACV017','Bovino','2019-05-26','F','Angus Colorado',0,1,1,3),(18,'TagACV018','RFIDACV018','Bovino','2019-03-05','F','Angus Colorado',0,1,1,3),(19,'TagACV019','RFIDACV019','Bovino','2021-09-02','F','Angus Colorado',0,1,1,3),(20,'TagACV020','RFIDACV020','Bovino','2019-11-05','F','Angus Colorado',0,1,1,3),(21,'TagACV021','RFIDACV021','Bovino','2021-03-16','F','Angus Colorado',0,1,1,3),(22,'TagACV022','RFIDACV022','Bovino','2021-07-01','F','Angus Colorado',0,1,1,3),(23,'TagACV023','RFIDACV023','Bovino','2021-11-17','F','Angus Colorado',0,1,1,3),(24,'TagACV024','RFIDACV024','Bovino','2019-11-27','F','Angus Colorado',0,1,1,3),(25,'TagACV025','RFIDACV025','Bovino','2020-11-18','F','Angus Colorado',0,1,1,3),(26,'TagACV026','RFIDACV026','Bovino','2019-09-15','F','Angus Colorado',0,1,1,3),(27,'TagACV027','RFIDACV027','Bovino','2019-11-15','F','Angus Colorado',0,1,1,3),(28,'TagACV028','RFIDACV028','Bovino','2021-04-01','F','Angus Colorado',0,1,1,3),(29,'TagACV029','RFIDACV029','Bovino','2021-08-18','F','Angus Colorado',0,1,1,3),(30,'TagACV030','RFIDACV030','Bovino','2019-05-29','F','Angus Colorado',0,1,1,3),(31,'TagACV031','RFIDACV031','Bovino','2019-02-21','F','Angus Colorado',0,1,1,3),(32,'TagACV032','RFIDACV032','Bovino','2021-06-23','F','Angus Colorado',0,1,1,3),(33,'TagACV033','RFIDACV033','Bovino','2021-12-22','F','Angus Colorado',0,1,1,3),(34,'TagACV034','RFIDACV034','Bovino','2020-06-09','F','Angus Colorado',0,1,1,3),(35,'TagACV035','RFIDACV035','Bovino','2020-04-09','F','Angus Colorado',0,1,1,3),(36,'TagACV036','RFIDACV036','Bovino','2021-01-18','F','Angus Colorado',0,1,1,3),(37,'TagACV037','RFIDACV037','Bovino','2019-06-05','F','Angus Colorado',0,1,1,3),(38,'TagACV038','RFIDACV038','Bovino','2020-12-22','F','Angus Colorado',0,1,1,3),(39,'TagACV039','RFIDACV039','Bovino','2021-08-10','F','Angus Colorado',0,1,1,3),(40,'TagACV040','RFIDACV040','Bovino','2020-02-12','F','Angus Colorado',0,1,1,3),(41,'TagACV041','RFIDACV041','Bovino','2019-10-02','F','Angus Colorado',0,1,1,3),(42,'TagACV042','RFIDACV042','Bovino','2019-05-30','F','Angus Colorado',0,1,1,3),(43,'TagACV043','RFIDACV043','Bovino','2021-10-17','F','Angus Colorado',0,1,1,3),(44,'TagACV044','RFIDACV044','Bovino','2019-10-01','F','Angus Colorado',0,1,1,3),(45,'TagACV045','RFIDACV045','Bovino','2020-05-10','F','Angus Colorado',0,1,1,3),(46,'TagACV046','RFIDACV046','Bovino','2020-07-14','F','Angus Colorado',0,1,1,3),(47,'TagACV047','RFIDACV047','Bovino','2019-08-11','F','Angus Colorado',0,1,1,3),(48,'TagACV048','RFIDACV048','Bovino','2020-06-10','F','Angus Colorado',0,1,1,3),(49,'TagACV049','RFIDACV049','Bovino','2021-05-18','F','Angus Colorado',0,1,1,3),(50,'TagACV050','RFIDACV050','Bovino','2020-07-29','F','Angus Colorado',0,1,1,3),(51,'TagACV051','RFIDACV051','Bovino','2019-09-28','F','Angus Colorado',0,1,1,3),(52,'TagACV052','RFIDACV052','Bovino','2020-12-21','F','Angus Colorado',0,1,1,3),(53,'TagACV053','RFIDACV053','Bovino','2020-08-23','F','Angus Colorado',0,1,1,3),(54,'TagACV054','RFIDACV054','Bovino','2021-04-20','F','Angus Colorado',0,1,1,3),(55,'TagACV055','RFIDACV055','Bovino','2019-07-31','F','Angus Colorado',0,1,1,3),(56,'TagACV056','RFIDACV056','Bovino','2020-12-27','F','Angus Colorado',0,1,1,3),(57,'TagACV057','RFIDACV057','Bovino','2021-03-17','F','Angus Colorado',0,1,1,3),(58,'TagACV058','RFIDACV058','Bovino','2021-01-30','F','Angus Colorado',0,1,1,3),(59,'TagACV059','RFIDACV059','Bovino','2019-10-12','F','Angus Colorado',0,1,1,3),(60,'TagACV060','RFIDACV060','Bovino','2019-08-28','F','Angus Colorado',0,1,1,3),(61,'TagACV061','RFIDACV061','Bovino','2019-12-08','F','Angus Colorado',0,1,1,3),(62,'TagACV062','RFIDACV062','Bovino','2021-09-16','F','Angus Colorado',0,1,1,3),(63,'TagACV063','RFIDACV063','Bovino','2020-10-01','F','Angus Colorado',0,1,1,3),(64,'TagACV064','RFIDACV064','Bovino','2019-08-16','F','Angus Colorado',0,1,1,3),(65,'TagACV065','RFIDACV065','Bovino','2019-11-10','F','Angus Colorado',0,1,1,3),(66,'TagACV066','RFIDACV066','Bovino','2021-06-06','F','Angus Colorado',0,1,1,3),(67,'TagACV067','RFIDACV067','Bovino','2019-07-29','F','Angus Colorado',0,1,1,3),(68,'TagACV068','RFIDACV068','Bovino','2020-07-30','F','Angus Colorado',0,1,1,3),(69,'TagACV069','RFIDACV069','Bovino','2019-03-03','F','Angus Colorado',0,1,1,3),(70,'TagACV070','RFIDACV070','Bovino','2021-02-08','F','Angus Colorado',0,1,1,3),(71,'TagACV071','RFIDACV071','Bovino','2020-01-15','F','Angus Colorado',0,1,1,3),(72,'TagACV072','RFIDACV072','Bovino','2020-11-13','F','Angus Colorado',0,1,1,3),(73,'TagACV073','RFIDACV073','Bovino','2019-03-26','F','Angus Colorado',0,1,1,3),(74,'TagACV074','RFIDACV074','Bovino','2020-07-18','F','Angus Colorado',0,1,1,3),(75,'TagACV075','RFIDACV075','Bovino','2020-01-15','F','Angus Colorado',0,1,1,3),(76,'TagACV076','RFIDACV076','Bovino','2019-07-22','F','Angus Colorado',0,1,1,3),(77,'TagACV077','RFIDACV077','Bovino','2021-08-26','F','Angus Colorado',0,1,1,3),(78,'TagACV078','RFIDACV078','Bovino','2021-08-10','F','Angus Colorado',0,1,1,3),(79,'TagACV079','RFIDACV079','Bovino','2021-02-01','F','Angus Colorado',0,1,1,3),(80,'TagACV080','RFIDACV080','Bovino','2021-08-11','F','Angus Colorado',0,1,1,3),(81,'TagACV081','RFIDACV081','Bovino','2019-10-19','F','Angus Colorado',0,1,1,3),(82,'TagACV082','RFIDACV082','Bovino','2021-02-23','F','Angus Colorado',0,1,1,3),(83,'TagACV083','RFIDACV083','Bovino','2021-05-07','F','Angus Colorado',0,1,1,3),(84,'TagACV084','RFIDACV084','Bovino','2021-04-18','F','Angus Colorado',0,1,1,3),(85,'TagACV085','RFIDACV085','Bovino','2020-06-11','F','Angus Colorado',0,1,1,3),(86,'TagACV086','RFIDACV086','Bovino','2019-05-01','F','Angus Colorado',0,1,1,3),(87,'TagACV087','RFIDACV087','Bovino','2019-04-26','F','Angus Colorado',0,1,1,3),(88,'TagACV088','RFIDACV088','Bovino','2019-08-05','F','Angus Colorado',0,1,1,3),(89,'TagACV089','RFIDACV089','Bovino','2021-01-04','F','Angus Colorado',0,1,1,3),(90,'TagACV090','RFIDACV090','Bovino','2021-04-12','F','Angus Colorado',0,1,1,3),(91,'TagACV091','RFIDACV091','Bovino','2021-05-14','F','Angus Colorado',0,1,1,3),(92,'TagACV092','RFIDACV092','Bovino','2020-12-29','F','Angus Colorado',0,1,1,3),(93,'TagACV093','RFIDACV093','Bovino','2021-11-17','F','Angus Colorado',0,1,1,3),(94,'TagACV094','RFIDACV094','Bovino','2021-05-31','F','Angus Colorado',0,1,1,3),(95,'TagACV095','RFIDACV095','Bovino','2019-06-08','F','Angus Colorado',0,1,1,3),(96,'TagACV096','RFIDACV096','Bovino','2019-12-03','F','Angus Colorado',0,1,1,3),(97,'TagACV097','RFIDACV097','Bovino','2019-04-22','F','Angus Colorado',0,1,1,3),(98,'TagACV098','RFIDACV098','Bovino','2020-10-07','F','Angus Colorado',0,1,1,3),(99,'TagACV099','RFIDACV099','Bovino','2020-12-02','F','Angus Colorado',0,1,1,3),(100,'TagACV100','RFIDACV100','Bovino','2020-04-20','F','Angus Colorado',0,1,1,3),(101,'TagACV101','RFIDACV101','Bovino','2019-10-01','F','Angus Colorado',0,1,1,3),(102,'TagACV102','RFIDACV102','Bovino','2021-10-30','F','Angus Colorado',0,1,1,3),(103,'TagACV103','RFIDACV103','Bovino','2021-12-01','F','Angus Colorado',0,1,1,3),(104,'TagACV104','RFIDACV104','Bovino','2019-02-05','F','Angus Colorado',0,1,1,3),(105,'TagACV105','RFIDACV105','Bovino','2019-09-25','F','Angus Colorado',0,1,1,3),(106,'TagACV106','RFIDACV106','Bovino','2019-05-16','F','Angus Colorado',0,1,1,3),(107,'TagACV107','RFIDACV107','Bovino','2021-08-28','F','Angus Colorado',0,1,1,3),(108,'TagACV108','RFIDACV108','Bovino','2019-03-09','F','Angus Colorado',0,1,1,3),(109,'TagACV109','RFIDACV109','Bovino','2020-12-10','F','Angus Colorado',0,1,1,3),(110,'TagACV110','RFIDACV110','Bovino','2019-03-01','F','Angus Colorado',0,1,1,3),(111,'TagACV111','RFIDACV111','Bovino','2019-12-24','F','Angus Colorado',0,1,1,3),(112,'TagACV112','RFIDACV112','Bovino','2020-06-01','F','Angus Colorado',0,1,1,3),(113,'TagACV113','RFIDACV113','Bovino','2020-02-22','F','Angus Colorado',0,1,1,3),(114,'TagACV114','RFIDACV114','Bovino','2020-06-19','F','Angus Colorado',0,1,1,3),(115,'TagACV115','RFIDACV115','Bovino','2019-11-26','F','Angus Colorado',0,1,1,3),(116,'TagACV116','RFIDACV116','Bovino','2019-02-11','F','Angus Colorado',0,1,1,3),(117,'TagACV117','RFIDACV117','Bovino','2019-11-10','F','Angus Colorado',0,1,1,3),(118,'TagACV118','RFIDACV118','Bovino','2019-12-15','F','Angus Colorado',0,1,1,3),(119,'TagACV119','RFIDACV119','Bovino','2021-03-10','F','Angus Colorado',0,1,1,3),(120,'TagACV120','RFIDACV120','Bovino','2021-02-03','F','Angus Colorado',0,1,1,3),(121,'TagACV121','RFIDACV121','Bovino','2019-11-27','F','Angus Colorado',0,1,1,3),(122,'TagACV122','RFIDACV122','Bovino','2020-03-27','F','Angus Colorado',0,1,1,3),(123,'TagACV123','RFIDACV123','Bovino','2019-06-20','F','Angus Colorado',0,1,1,3),(124,'TagACV124','RFIDACV124','Bovino','2020-08-14','F','Angus Colorado',0,1,1,3),(125,'TagACV125','RFIDACV125','Bovino','2019-09-16','F','Angus Colorado',0,1,1,3),(126,'TagACV126','RFIDACV126','Bovino','2020-09-05','F','Angus Colorado',0,1,1,3),(127,'TagACV127','RFIDACV127','Bovino','2019-04-12','F','Angus Colorado',0,1,1,3),(128,'TagACV128','RFIDACV128','Bovino','2021-05-06','F','Angus Colorado',0,1,1,3),(129,'TagACV129','RFIDACV129','Bovino','2020-11-24','F','Angus Colorado',0,1,1,3),(130,'TagACV130','RFIDACV130','Bovino','2021-06-15','F','Angus Colorado',0,1,1,3),(131,'TagACV131','RFIDACV131','Bovino','2019-07-31','F','Angus Colorado',0,1,1,3),(132,'TagACV132','RFIDACV132','Bovino','2020-07-15','F','Angus Colorado',0,1,1,3),(133,'TagACV133','RFIDACV133','Bovino','2021-12-10','F','Angus Colorado',0,1,1,3),(134,'TagACV134','RFIDACV134','Bovino','2020-02-09','F','Angus Colorado',0,1,1,3),(135,'TagACV135','RFIDACV135','Bovino','2021-09-14','F','Angus Colorado',0,1,1,3),(136,'TagACV136','RFIDACV136','Bovino','2020-03-14','F','Angus Colorado',0,1,1,3),(137,'TagACV137','RFIDACV137','Bovino','2019-11-24','F','Angus Colorado',0,1,1,3),(138,'TagACV138','RFIDACV138','Bovino','2019-11-16','F','Angus Colorado',0,1,1,3),(139,'TagACV139','RFIDACV139','Bovino','2020-09-10','F','Angus Colorado',0,1,1,3),(140,'TagACV140','RFIDACV140','Bovino','2021-11-01','F','Angus Colorado',0,1,1,3),(141,'TagACV141','RFIDACV141','Bovino','2019-02-07','F','Angus Colorado',0,1,1,3),(142,'TagACV142','RFIDACV142','Bovino','2020-01-02','F','Angus Colorado',0,1,1,3),(143,'TagACV143','RFIDACV143','Bovino','2020-09-16','F','Angus Colorado',0,1,1,3),(144,'TagACV144','RFIDACV144','Bovino','2021-07-16','F','Angus Colorado',0,1,1,3),(145,'TagACV145','RFIDACV145','Bovino','2020-07-27','F','Angus Colorado',0,1,1,3),(146,'TagACV146','RFIDACV146','Bovino','2019-03-27','F','Angus Colorado',0,1,1,3),(147,'TagACV147','RFIDACV147','Bovino','2021-06-16','F','Angus Colorado',0,1,1,3),(148,'TagACV148','RFIDACV148','Bovino','2021-08-04','F','Angus Colorado',0,1,1,3),(149,'TagACV149','RFIDACV149','Bovino','2021-07-31','F','Angus Colorado',0,1,1,3),(150,'TagACV150','RFIDACV150','Bovino','2021-02-18','F','Angus Colorado',0,1,1,3),(256,'TagACT001','RFIDACT001','Bovino','2020-12-03','M','Angus Colorado',0,2,1,3),(257,'TagACT002','RFIDACT002','Bovino','2020-03-22','M','Angus Colorado',0,2,1,3),(258,'TagACT003','RFIDACT003','Bovino','2020-05-06','M','Angus Colorado',0,2,1,3),(259,'TagACT004','RFIDACT004','Bovino','2020-01-22','M','Angus Colorado',0,2,1,3),(260,'TagACT005','RFIDACT005','Bovino','2018-04-03','M','Angus Colorado',0,2,1,3),(261,'TagACT006','RFIDACT006','Bovino','2019-02-04','M','Angus Colorado',0,2,1,3),(262,'TagACT007','RFIDACT007','Bovino','2019-09-17','M','Angus Colorado',0,2,1,3),(263,'TagACT008','RFIDACT008','Bovino','2020-04-09','M','Angus Colorado',0,2,1,3),(264,'TagACT009','RFIDACT009','Bovino','2018-03-23','M','Angus Colorado',0,2,1,3),(265,'TagACT010','RFIDACT010','Bovino','2018-04-22','M','Angus Colorado',0,2,1,3),(266,'TagACT011','RFIDACT011','Bovino','2018-11-09','M','Angus Colorado',0,2,1,3),(267,'TagACT012','RFIDACT012','Bovino','2018-05-15','M','Angus Colorado',0,2,1,3),(268,'TagACT013','RFIDACT013','Bovino','2020-04-10','M','Angus Colorado',0,2,1,3),(269,'TagACT014','RFIDACT014','Bovino','2019-04-09','M','Angus Colorado',0,2,1,3),(270,'TagACT015','RFIDACT015','Bovino','2020-07-08','M','Angus Colorado',0,2,1,3),(271,'TagHFV001','RFIDHFV001','Bovino','2020-10-15','F','Hereford',0,1,2,3),(272,'TagHFV002','RFIDHFV002','Bovino','2018-05-25','F','Hereford',0,1,2,3),(273,'TagHFV003','RFIDHFV003','Bovino','2020-08-09','F','Hereford',0,1,2,3),(274,'TagHFV004','RFIDHFV004','Bovino','2020-11-06','F','Hereford',0,1,2,3),(275,'TagHFV005','RFIDHFV005','Bovino','2018-06-08','F','Hereford',0,1,2,3),(276,'TagHFV006','RFIDHFV006','Bovino','2020-08-13','F','Hereford',0,1,2,3),(277,'TagHFV007','RFIDHFV007','Bovino','2020-10-14','F','Hereford',0,1,2,3),(278,'TagHFV008','RFIDHFV008','Bovino','2018-01-31','F','Hereford',0,1,2,3),(279,'TagHFV009','RFIDHFV009','Bovino','2019-01-20','F','Hereford',0,1,2,3),(280,'TagHFV010','RFIDHFV010','Bovino','2020-01-05','F','Hereford',0,1,2,3),(281,'TagHFV011','RFIDHFV011','Bovino','2018-11-26','F','Hereford',0,1,2,3),(282,'TagHFV012','RFIDHFV012','Bovino','2019-06-25','F','Hereford',0,1,2,3),(283,'TagHFV013','RFIDHFV013','Bovino','2019-09-13','F','Hereford',0,1,2,3),(284,'TagHFV014','RFIDHFV014','Bovino','2019-01-19','F','Hereford',0,1,2,3),(285,'TagHFV015','RFIDHFV015','Bovino','2018-02-26','F','Hereford',0,1,2,3),(286,'TagHFV016','RFIDHFV016','Bovino','2018-08-17','F','Hereford',0,1,2,3),(287,'TagHFV017','RFIDHFV017','Bovino','2020-08-28','F','Hereford',0,1,2,3),(288,'TagHFV018','RFIDHFV018','Bovino','2020-06-02','F','Hereford',0,1,2,3),(289,'TagHFV019','RFIDHFV019','Bovino','2019-02-17','F','Hereford',0,1,2,3),(290,'TagHFV020','RFIDHFV020','Bovino','2019-05-20','F','Hereford',0,1,2,3),(291,'TagHFV021','RFIDHFV021','Bovino','2018-07-09','F','Hereford',0,1,2,3),(292,'TagHFV022','RFIDHFV022','Bovino','2019-06-13','F','Hereford',0,1,2,3),(293,'TagHFV023','RFIDHFV023','Bovino','2020-09-05','F','Hereford',0,1,2,3),(294,'TagHFV024','RFIDHFV024','Bovino','2018-01-22','F','Hereford',0,1,2,3),(295,'TagHFV025','RFIDHFV025','Bovino','2019-04-04','F','Hereford',0,1,2,3),(296,'TagHFV026','RFIDHFV026','Bovino','2018-02-05','F','Hereford',0,1,2,3),(297,'TagHFV027','RFIDHFV027','Bovino','2020-09-21','F','Hereford',0,1,2,3),(298,'TagHFV028','RFIDHFV028','Bovino','2019-05-01','F','Hereford',0,1,2,3),(299,'TagHFV029','RFIDHFV029','Bovino','2019-06-23','F','Hereford',0,1,2,3),(300,'TagHFV030','RFIDHFV030','Bovino','2018-05-20','F','Hereford',0,1,2,3),(301,'TagHFV031','RFIDHFV031','Bovino','2018-06-28','F','Hereford',0,1,2,3),(302,'TagHFV032','RFIDHFV032','Bovino','2019-04-19','F','Hereford',0,1,2,3),(303,'TagHFV033','RFIDHFV033','Bovino','2020-01-07','F','Hereford',0,1,2,3),(304,'TagHFV034','RFIDHFV034','Bovino','2018-03-13','F','Hereford',0,1,2,3),(305,'TagHFV035','RFIDHFV035','Bovino','2018-12-05','F','Hereford',0,1,2,3),(306,'TagHFV036','RFIDHFV036','Bovino','2019-01-20','F','Hereford',0,1,2,3),(307,'TagHFV037','RFIDHFV037','Bovino','2020-06-26','F','Hereford',0,1,2,3),(308,'TagHFV038','RFIDHFV038','Bovino','2018-04-06','F','Hereford',0,1,2,3),(309,'TagHFV039','RFIDHFV039','Bovino','2020-11-09','F','Hereford',0,1,2,3),(310,'TagHFV040','RFIDHFV040','Bovino','2019-07-05','F','Hereford',0,1,2,3),(311,'TagHFV041','RFIDHFV041','Bovino','2019-12-20','F','Hereford',0,1,2,3),(312,'TagHFV042','RFIDHFV042','Bovino','2020-04-23','F','Hereford',0,1,2,3),(313,'TagHFV043','RFIDHFV043','Bovino','2020-08-25','F','Hereford',0,1,2,3),(314,'TagHFV044','RFIDHFV044','Bovino','2018-04-28','F','Hereford',0,1,2,3),(315,'TagHFV045','RFIDHFV045','Bovino','2020-08-27','F','Hereford',0,1,2,3),(316,'TagHFV046','RFIDHFV046','Bovino','2018-04-24','F','Hereford',0,1,2,3),(317,'TagHFV047','RFIDHFV047','Bovino','2020-08-01','F','Hereford',0,1,2,3),(318,'TagHFV048','RFIDHFV048','Bovino','2020-12-28','F','Hereford',0,1,2,3),(319,'TagHFV049','RFIDHFV049','Bovino','2019-03-19','F','Hereford',0,1,2,3),(320,'TagHFV050','RFIDHFV050','Bovino','2018-02-01','F','Hereford',0,1,2,3),(321,'TagHFV051','RFIDHFV051','Bovino','2020-10-16','F','Hereford',0,1,2,3),(322,'TagHFV052','RFIDHFV052','Bovino','2019-09-15','F','Hereford',0,1,2,3),(323,'TagHFV053','RFIDHFV053','Bovino','2018-02-23','F','Hereford',0,1,2,3),(324,'TagHFV054','RFIDHFV054','Bovino','2019-08-15','F','Hereford',0,1,2,3),(325,'TagHFV055','RFIDHFV055','Bovino','2019-08-28','F','Hereford',0,1,2,3),(326,'TagHFV056','RFIDHFV056','Bovino','2018-06-03','F','Hereford',0,1,2,3),(327,'TagHFV057','RFIDHFV057','Bovino','2018-02-19','F','Hereford',0,1,2,3),(328,'TagHFV058','RFIDHFV058','Bovino','2020-05-30','F','Hereford',0,1,2,3),(329,'TagHFV059','RFIDHFV059','Bovino','2020-08-27','F','Hereford',0,1,2,3),(330,'TagHFV060','RFIDHFV060','Bovino','2018-01-16','F','Hereford',0,1,2,3),(331,'TagHFV061','RFIDHFV061','Bovino','2019-03-31','F','Hereford',0,1,2,3),(332,'TagHFV062','RFIDHFV062','Bovino','2018-02-05','F','Hereford',0,1,2,3),(333,'TagHFV063','RFIDHFV063','Bovino','2020-10-02','F','Hereford',0,1,2,3),(334,'TagHFV064','RFIDHFV064','Bovino','2019-06-23','F','Hereford',0,1,2,3),(335,'TagHFV065','RFIDHFV065','Bovino','2020-02-12','F','Hereford',0,1,2,3),(336,'TagHFV066','RFIDHFV066','Bovino','2018-02-25','F','Hereford',0,1,2,3),(337,'TagHFV067','RFIDHFV067','Bovino','2018-05-30','F','Hereford',0,1,2,3),(338,'TagHFV068','RFIDHFV068','Bovino','2019-08-05','F','Hereford',0,1,2,3),(339,'TagHFV069','RFIDHFV069','Bovino','2018-09-27','F','Hereford',0,1,2,3),(340,'TagHFV070','RFIDHFV070','Bovino','2019-11-29','F','Hereford',0,1,2,3),(341,'TagHFV071','RFIDHFV071','Bovino','2019-05-04','F','Hereford',0,1,2,3),(342,'TagHFV072','RFIDHFV072','Bovino','2018-12-19','F','Hereford',0,1,2,3),(343,'TagHFV073','RFIDHFV073','Bovino','2018-10-24','F','Hereford',0,1,2,3),(344,'TagHFV074','RFIDHFV074','Bovino','2019-02-28','F','Hereford',0,1,2,3),(345,'TagHFV075','RFIDHFV075','Bovino','2018-05-14','F','Hereford',0,1,2,3),(346,'TagHFV076','RFIDHFV076','Bovino','2019-05-07','F','Hereford',0,1,2,3),(347,'TagHFV077','RFIDHFV077','Bovino','2020-08-21','F','Hereford',0,1,2,3),(348,'TagHFV078','RFIDHFV078','Bovino','2018-02-26','F','Hereford',0,1,2,3),(349,'TagHFV079','RFIDHFV079','Bovino','2019-11-09','F','Hereford',0,1,2,3),(350,'TagHFV080','RFIDHFV080','Bovino','2020-10-25','F','Hereford',0,1,2,3),(351,'TagHFV081','RFIDHFV081','Bovino','2020-07-06','F','Hereford',0,1,2,3),(352,'TagHFV082','RFIDHFV082','Bovino','2019-02-14','F','Hereford',0,1,2,3),(353,'TagHFV083','RFIDHFV083','Bovino','2019-01-26','F','Hereford',0,1,2,3),(354,'TagHFV084','RFIDHFV084','Bovino','2019-12-25','F','Hereford',0,1,2,3),(355,'TagHFV085','RFIDHFV085','Bovino','2018-09-14','F','Hereford',0,1,2,3),(356,'TagHFV086','RFIDHFV086','Bovino','2018-07-24','F','Hereford',0,1,2,3),(357,'TagHFV087','RFIDHFV087','Bovino','2018-09-13','F','Hereford',0,1,2,3),(358,'TagHFV088','RFIDHFV088','Bovino','2019-10-27','F','Hereford',0,1,2,3),(359,'TagHFV089','RFIDHFV089','Bovino','2018-12-30','F','Hereford',0,1,2,3),(360,'TagHFV090','RFIDHFV090','Bovino','2020-07-10','F','Hereford',0,1,2,3),(361,'TagHFV091','RFIDHFV091','Bovino','2018-08-21','F','Hereford',0,1,2,3),(362,'TagHFV092','RFIDHFV092','Bovino','2019-08-12','F','Hereford',0,1,2,3),(363,'TagHFV093','RFIDHFV093','Bovino','2018-02-21','F','Hereford',0,1,2,3),(364,'TagHFV094','RFIDHFV094','Bovino','2019-11-17','F','Hereford',0,1,2,3),(365,'TagHFV095','RFIDHFV095','Bovino','2020-12-17','F','Hereford',0,1,2,3),(366,'TagHFV096','RFIDHFV096','Bovino','2018-03-09','F','Hereford',0,1,2,3),(367,'TagHFV097','RFIDHFV097','Bovino','2019-01-14','F','Hereford',0,1,2,3),(368,'TagHFV098','RFIDHFV098','Bovino','2019-08-20','F','Hereford',0,1,2,3),(369,'TagHFV099','RFIDHFV099','Bovino','2020-01-19','F','Hereford',0,1,2,3),(370,'TagHFV100','RFIDHFV100','Bovino','2020-05-09','F','Hereford',0,1,2,3),(371,'TagHFV101','RFIDHFV101','Bovino','2020-08-16','F','Hereford',0,1,2,3),(372,'TagHFV102','RFIDHFV102','Bovino','2018-01-23','F','Hereford',0,1,2,3),(373,'TagHFV103','RFIDHFV103','Bovino','2019-06-08','F','Hereford',0,1,2,3),(374,'TagHFV104','RFIDHFV104','Bovino','2018-12-27','F','Hereford',0,1,2,3),(375,'TagHFV105','RFIDHFV105','Bovino','2018-08-20','F','Hereford',0,1,2,3),(376,'TagHFV106','RFIDHFV106','Bovino','2018-03-18','F','Hereford',0,1,2,3),(377,'TagHFV107','RFIDHFV107','Bovino','2020-02-23','F','Hereford',0,1,2,3),(378,'TagHFV108','RFIDHFV108','Bovino','2019-02-08','F','Hereford',0,1,2,3),(379,'TagHFV109','RFIDHFV109','Bovino','2020-01-30','F','Hereford',0,1,2,3),(380,'TagHFV110','RFIDHFV110','Bovino','2019-02-01','F','Hereford',0,1,2,3),(381,'TagHFV111','RFIDHFV111','Bovino','2020-03-09','F','Hereford',0,1,2,3),(382,'TagHFV112','RFIDHFV112','Bovino','2019-09-05','F','Hereford',0,1,2,3),(383,'TagHFV113','RFIDHFV113','Bovino','2019-10-29','F','Hereford',0,1,2,3),(384,'TagHFV114','RFIDHFV114','Bovino','2019-02-04','F','Hereford',0,1,2,3),(385,'TagHFV115','RFIDHFV115','Bovino','2018-01-01','F','Hereford',0,1,2,3),(386,'TagHFV116','RFIDHFV116','Bovino','2020-09-20','F','Hereford',0,1,2,3),(387,'TagHFV117','RFIDHFV117','Bovino','2019-08-11','F','Hereford',0,1,2,3),(388,'TagHFV118','RFIDHFV118','Bovino','2020-11-17','F','Hereford',0,1,2,3),(389,'TagHFV119','RFIDHFV119','Bovino','2018-07-27','F','Hereford',0,1,2,3),(390,'TagHFV120','RFIDHFV120','Bovino','2018-03-15','F','Hereford',0,1,2,3),(391,'TagHFV121','RFIDHFV121','Bovino','2020-04-21','F','Hereford',0,1,2,3),(392,'TagHFV122','RFIDHFV122','Bovino','2019-12-03','F','Hereford',0,1,2,3),(393,'TagHFV123','RFIDHFV123','Bovino','2020-09-11','F','Hereford',0,1,2,3),(394,'TagHFV124','RFIDHFV124','Bovino','2019-09-20','F','Hereford',0,1,2,3),(395,'TagHFV125','RFIDHFV125','Bovino','2018-07-03','F','Hereford',0,1,2,3),(396,'TagHFV126','RFIDHFV126','Bovino','2018-05-12','F','Hereford',0,1,2,3),(397,'TagHFV127','RFIDHFV127','Bovino','2018-04-15','F','Hereford',0,1,2,3),(398,'TagHFV128','RFIDHFV128','Bovino','2018-05-09','F','Hereford',0,1,2,3),(399,'TagHFV129','RFIDHFV129','Bovino','2018-11-25','F','Hereford',0,1,2,3),(400,'TagHFV130','RFIDHFV130','Bovino','2018-06-10','F','Hereford',0,1,2,3),(401,'TagHFV131','RFIDHFV131','Bovino','2020-07-03','F','Hereford',0,1,2,3),(402,'TagHFV132','RFIDHFV132','Bovino','2020-03-17','F','Hereford',0,1,2,3),(403,'TagHFV133','RFIDHFV133','Bovino','2018-07-14','F','Hereford',0,1,2,3),(404,'TagHFV134','RFIDHFV134','Bovino','2020-01-12','F','Hereford',0,1,2,3),(405,'TagHFV135','RFIDHFV135','Bovino','2020-07-22','F','Hereford',0,1,2,3),(406,'TagHFV136','RFIDHFV136','Bovino','2018-09-10','F','Hereford',0,1,2,3),(407,'TagHFV137','RFIDHFV137','Bovino','2019-10-15','F','Hereford',0,1,2,3),(408,'TagHFV138','RFIDHFV138','Bovino','2018-11-11','F','Hereford',0,1,2,3),(409,'TagHFV139','RFIDHFV139','Bovino','2019-12-10','F','Hereford',0,1,2,3),(410,'TagHFV140','RFIDHFV140','Bovino','2019-02-15','F','Hereford',0,1,2,3),(411,'TagHFV141','RFIDHFV141','Bovino','2020-10-20','F','Hereford',0,1,2,3),(412,'TagHFV142','RFIDHFV142','Bovino','2019-08-25','F','Hereford',0,1,2,3),(413,'TagHFV143','RFIDHFV143','Bovino','2020-10-26','F','Hereford',0,1,2,3),(414,'TagHFV144','RFIDHFV144','Bovino','2018-03-02','F','Hereford',0,1,2,3),(415,'TagHFV145','RFIDHFV145','Bovino','2019-05-12','F','Hereford',0,1,2,3),(416,'TagHFV146','RFIDHFV146','Bovino','2018-04-23','F','Hereford',0,1,2,3),(417,'TagHFV147','RFIDHFV147','Bovino','2018-06-15','F','Hereford',0,1,2,3),(418,'TagHFV148','RFIDHFV148','Bovino','2019-05-09','F','Hereford',0,1,2,3),(419,'TagHFV149','RFIDHFV149','Bovino','2020-05-23','F','Hereford',0,1,2,3),(420,'TagHFV150','RFIDHFV150','Bovino','2019-11-29','F','Hereford',0,1,2,3),(526,'TagHFT001','RFIDHFT001','Bovino','2020-05-18','M','Hereford',0,2,2,3),(527,'TagHFT002','RFIDHFT002','Bovino','2018-02-27','M','Hereford',0,2,2,3),(528,'TagHFT003','RFIDHFT003','Bovino','2020-08-26','M','Hereford',0,2,2,3),(529,'TagHFT004','RFIDHFT004','Bovino','2018-10-18','M','Hereford',0,2,2,3),(530,'TagHFT005','RFIDHFT005','Bovino','2020-01-05','M','Hereford',0,2,2,3),(531,'TagHFT006','RFIDHFT006','Bovino','2019-09-07','M','Hereford',0,2,2,3),(532,'TagHFT007','RFIDHFT007','Bovino','2020-05-16','M','Hereford',0,2,2,3),(533,'TagHFT008','RFIDHFT008','Bovino','2018-10-29','M','Hereford',0,2,2,3),(534,'TagHFT009','RFIDHFT009','Bovino','2020-12-30','M','Hereford',0,2,2,3),(535,'TagHFT010','RFIDHFT010','Bovino','2018-07-10','M','Hereford',0,2,2,3),(536,'TagHFT011','RFIDHFT011','Bovino','2020-08-11','M','Hereford',0,2,2,3),(537,'TagHFT012','RFIDHFT012','Bovino','2020-06-29','M','Hereford',0,2,2,3),(538,'TagHFT013','RFIDHFT013','Bovino','2019-08-21','M','Hereford',0,2,2,3),(539,'TagHFT014','RFIDHFT014','Bovino','2018-09-12','M','Hereford',0,2,2,3),(540,'TagHFT015','RFIDHFT015','Bovino','2019-07-29','M','Hereford',0,2,2,3),(541,'TagANV001','RFIDANV001','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(542,'TagANV002','RFIDANV002','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(543,'TagANV003','RFIDANV003','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(544,'TagANV004','RFIDANV004','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(545,'TagANV005','RFIDANV005','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(546,'TagANV006','RFIDANV006','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(547,'TagANV007','RFIDANV007','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(548,'TagANV008','RFIDANV008','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(549,'TagANV009','RFIDANV009','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(550,'TagANV010','RFIDANV010','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(551,'TagANV011','RFIDANV011','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(552,'TagANV012','RFIDANV012','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(553,'TagANV013','RFIDANV013','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(554,'TagANV014','RFIDANV014','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(555,'TagANV015','RFIDANV015','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(556,'TagANV016','RFIDANV016','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(557,'TagANV017','RFIDANV017','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(558,'TagANV018','RFIDANV018','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(559,'TagANV019','RFIDANV019','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(560,'TagANV020','RFIDANV020','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(561,'TagANV021','RFIDANV021','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(562,'TagANV022','RFIDANV022','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(563,'TagANV023','RFIDANV023','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(564,'TagANV024','RFIDANV024','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(565,'TagANV025','RFIDANV025','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(566,'TagANV026','RFIDANV026','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(567,'TagANV027','RFIDANV027','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(568,'TagANV028','RFIDANV028','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(569,'TagANV029','RFIDANV029','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(570,'TagANV030','RFIDANV030','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(571,'TagANV031','RFIDANV031','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(572,'TagANV032','RFIDANV032','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(573,'TagANV033','RFIDANV033','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(574,'TagANV034','RFIDANV034','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(575,'TagANV035','RFIDANV035','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(576,'TagANV036','RFIDANV036','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(577,'TagANV037','RFIDANV037','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(578,'TagANV038','RFIDANV038','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(579,'TagANV039','RFIDANV039','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(580,'TagANV040','RFIDANV040','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(581,'TagANV041','RFIDANV041','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(582,'TagANV042','RFIDANV042','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(583,'TagANV043','RFIDANV043','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(584,'TagANV044','RFIDANV044','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(585,'TagANV045','RFIDANV045','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(586,'TagANV046','RFIDANV046','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(587,'TagANV047','RFIDANV047','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(588,'TagANV048','RFIDANV048','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(589,'TagANV049','RFIDANV049','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(590,'TagANV050','RFIDANV050','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(591,'TagANV051','RFIDANV051','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(592,'TagANV052','RFIDANV052','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(593,'TagANV053','RFIDANV053','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(594,'TagANV054','RFIDANV054','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(595,'TagANV055','RFIDANV055','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(596,'TagANV056','RFIDANV056','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(597,'TagANV057','RFIDANV057','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(598,'TagANV058','RFIDANV058','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(599,'TagANV059','RFIDANV059','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(600,'TagANV060','RFIDANV060','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(601,'TagANV061','RFIDANV061','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(602,'TagANV062','RFIDANV062','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(603,'TagANV063','RFIDANV063','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(604,'TagANV064','RFIDANV064','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(605,'TagANV065','RFIDANV065','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(606,'TagANV066','RFIDANV066','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(607,'TagANV067','RFIDANV067','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(608,'TagANV068','RFIDANV068','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(609,'TagANV069','RFIDANV069','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(610,'TagANV070','RFIDANV070','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(611,'TagANV071','RFIDANV071','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(612,'TagANV072','RFIDANV072','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(613,'TagANV073','RFIDANV073','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(614,'TagANV074','RFIDANV074','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(615,'TagANV075','RFIDANV075','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(616,'TagANV076','RFIDANV076','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(617,'TagANV077','RFIDANV077','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(618,'TagANV078','RFIDANV078','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(619,'TagANV079','RFIDANV079','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(620,'TagANV080','RFIDANV080','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(621,'TagANV081','RFIDANV081','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(622,'TagANV082','RFIDANV082','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(623,'TagANV083','RFIDANV083','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(624,'TagANV084','RFIDANV084','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(625,'TagANV085','RFIDANV085','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(626,'TagANV086','RFIDANV086','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(627,'TagANV087','RFIDANV087','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(628,'TagANV088','RFIDANV088','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(629,'TagANV089','RFIDANV089','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(630,'TagANV090','RFIDANV090','Bovino','2022-01-01','M','Angus Negro',0,5,3,3),(668,'TagSHV001','RFIDSHV001','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(669,'TagSHV002','RFIDSHV002','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(670,'TagSHV003','RFIDSHV003','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(671,'TagSHV004','RFIDSHV004','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(672,'TagSHV005','RFIDSHV005','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(673,'TagSHV006','RFIDSHV006','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(674,'TagSHV007','RFIDSHV007','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(675,'TagSHV008','RFIDSHV008','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(676,'TagSHV009','RFIDSHV009','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(677,'TagSHV010','RFIDSHV010','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(678,'TagSHV011','RFIDSHV011','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(679,'TagSHV012','RFIDSHV012','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(680,'TagSHV013','RFIDSHV013','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(681,'TagSHV014','RFIDSHV014','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(682,'TagSHV015','RFIDSHV015','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(683,'TagSHV016','RFIDSHV016','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(684,'TagSHV017','RFIDSHV017','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(685,'TagSHV018','RFIDSHV018','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(686,'TagSHV019','RFIDSHV019','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(687,'TagSHV020','RFIDSHV020','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(688,'TagSHV021','RFIDSHV021','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(689,'TagSHV022','RFIDSHV022','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(690,'TagSHV023','RFIDSHV023','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(691,'TagSHV024','RFIDSHV024','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(692,'TagSHV025','RFIDSHV025','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(693,'TagSHV026','RFIDSHV026','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(694,'TagSHV027','RFIDSHV027','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(695,'TagSHV028','RFIDSHV028','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(696,'TagSHV029','RFIDSHV029','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(697,'TagSHV030','RFIDSHV030','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(698,'TagSHV031','RFIDSHV031','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(699,'TagSHV032','RFIDSHV032','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(700,'TagSHV033','RFIDSHV033','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(701,'TagSHV034','RFIDSHV034','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(702,'TagSHV035','RFIDSHV035','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(703,'TagSHV036','RFIDSHV036','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(704,'TagSHV037','RFIDSHV037','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(705,'TagSHV038','RFIDSHV038','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(706,'TagSHV039','RFIDSHV039','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(707,'TagSHV040','RFIDSHV040','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(708,'TagSHV041','RFIDSHV041','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(709,'TagSHV042','RFIDSHV042','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(710,'TagSHV043','RFIDSHV043','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(711,'TagSHV044','RFIDSHV044','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(712,'TagSHV045','RFIDSHV045','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(713,'TagSHV046','RFIDSHV046','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(714,'TagSHV047','RFIDSHV047','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(715,'TagSHV048','RFIDSHV048','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(716,'TagSHV049','RFIDSHV049','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(717,'TagSHV050','RFIDSHV050','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(718,'TagSHV051','RFIDSHV051','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(719,'TagSHV052','RFIDSHV052','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(720,'TagSHV053','RFIDSHV053','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(721,'TagSHV054','RFIDSHV054','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(722,'TagSHV055','RFIDSHV055','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(723,'TagSHV056','RFIDSHV056','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(724,'TagSHV057','RFIDSHV057','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(725,'TagSHV058','RFIDSHV058','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(726,'TagSHV059','RFIDSHV059','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(727,'TagSHV060','RFIDSHV060','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(728,'TagSHV061','RFIDSHV061','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(729,'TagSHV062','RFIDSHV062','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(730,'TagSHV063','RFIDSHV063','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(731,'TagSHV064','RFIDSHV064','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(732,'TagSHV065','RFIDSHV065','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(733,'TagSHV066','RFIDSHV066','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(734,'TagSHV067','RFIDSHV067','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(735,'TagSHV068','RFIDSHV068','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(736,'TagSHV069','RFIDSHV069','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(737,'TagSHV070','RFIDSHV070','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(738,'TagSHV071','RFIDSHV071','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(739,'TagSHV072','RFIDSHV072','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(740,'TagSHV073','RFIDSHV073','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(741,'TagSHV074','RFIDSHV074','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(742,'TagSHV075','RFIDSHV075','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(743,'TagSHV076','RFIDSHV076','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(744,'TagSHV077','RFIDSHV077','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(745,'TagSHV078','RFIDSHV078','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(746,'TagSHV079','RFIDSHV079','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(747,'TagSHV080','RFIDSHV080','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(748,'TagSHV081','RFIDSHV081','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(749,'TagSHV082','RFIDSHV082','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(750,'TagSHV083','RFIDSHV083','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(751,'TagSHV084','RFIDSHV084','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(752,'TagSHV085','RFIDSHV085','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(753,'TagSHV086','RFIDSHV086','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(754,'TagSHV087','RFIDSHV087','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(755,'TagSHV088','RFIDSHV088','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(756,'TagSHV089','RFIDSHV089','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(757,'TagSHV090','RFIDSHV090','Bovino','2022-01-01','M','Shorthorn',0,5,4,3),(795,'TagHFQ001','RFIDHFQ001','Bovino','2022-01-01','F','Hereford',0,4,5,3),(796,'TagHFQ002','RFIDHFQ002','Bovino','2022-01-01','F','Hereford',0,4,5,3),(797,'TagHFQ003','RFIDHFQ003','Bovino','2022-01-01','F','Hereford',0,4,5,3),(798,'TagHFQ004','RFIDHFQ004','Bovino','2022-01-01','F','Hereford',0,4,5,3),(799,'TagHFQ005','RFIDHFQ005','Bovino','2022-01-01','F','Hereford',0,4,5,3),(800,'TagHFQ006','RFIDHFQ006','Bovino','2022-01-01','F','Hereford',0,4,5,3),(801,'TagHFQ007','RFIDHFQ007','Bovino','2022-01-01','F','Hereford',0,4,5,3),(802,'TagHFQ008','RFIDHFQ008','Bovino','2022-01-01','F','Hereford',0,4,5,3),(803,'TagHFQ009','RFIDHFQ009','Bovino','2022-01-01','F','Hereford',0,4,5,3),(804,'TagHFQ010','RFIDHFQ010','Bovino','2022-01-01','F','Hereford',0,4,5,3),(805,'TagHFQ011','RFIDHFQ011','Bovino','2022-01-01','F','Hereford',0,4,5,3),(806,'TagHFQ012','RFIDHFQ012','Bovino','2022-01-01','F','Hereford',0,4,5,3),(807,'TagHFQ013','RFIDHFQ013','Bovino','2022-01-01','F','Hereford',0,4,5,3),(808,'TagHFQ014','RFIDHFQ014','Bovino','2022-01-01','F','Hereford',0,4,5,3),(809,'TagHFQ015','RFIDHFQ015','Bovino','2022-01-01','F','Hereford',0,4,5,3),(810,'TagHFQ016','RFIDHFQ016','Bovino','2022-01-01','F','Hereford',0,4,5,3),(811,'TagHFQ017','RFIDHFQ017','Bovino','2022-01-01','F','Hereford',0,4,5,3),(812,'TagHFQ018','RFIDHFQ018','Bovino','2022-01-01','F','Hereford',0,4,5,3),(813,'TagHFQ019','RFIDHFQ019','Bovino','2022-01-01','F','Hereford',0,4,5,3),(814,'TagHFQ020','RFIDHFQ020','Bovino','2022-01-01','F','Hereford',0,4,5,3),(815,'TagHFQ021','RFIDHFQ021','Bovino','2022-01-01','F','Hereford',0,4,5,3),(816,'TagHFQ022','RFIDHFQ022','Bovino','2022-01-01','F','Hereford',0,4,5,3),(817,'TagHFQ023','RFIDHFQ023','Bovino','2022-01-01','F','Hereford',0,4,5,3),(818,'TagHFQ024','RFIDHFQ024','Bovino','2022-01-01','F','Hereford',0,4,5,3),(819,'TagHFQ025','RFIDHFQ025','Bovino','2022-01-01','F','Hereford',0,4,5,3),(820,'TagHFQ026','RFIDHFQ026','Bovino','2022-01-01','F','Hereford',0,4,5,3),(821,'TagHFQ027','RFIDHFQ027','Bovino','2022-01-01','F','Hereford',0,4,5,3),(822,'TagHFQ028','RFIDHFQ028','Bovino','2022-01-01','F','Hereford',0,4,5,3),(823,'TagHFQ029','RFIDHFQ029','Bovino','2022-01-01','F','Hereford',0,4,5,3),(824,'TagHFQ030','RFIDHFQ030','Bovino','2022-01-01','F','Hereford',0,4,5,3),(825,'TagHFQ031','RFIDHFQ031','Bovino','2022-01-01','F','Hereford',0,4,5,3),(826,'TagHFQ032','RFIDHFQ032','Bovino','2022-01-01','F','Hereford',0,4,5,3),(827,'TagHFQ033','RFIDHFQ033','Bovino','2022-01-01','F','Hereford',0,4,5,3),(828,'TagHFQ034','RFIDHFQ034','Bovino','2022-01-01','F','Hereford',0,4,5,3),(829,'TagHFQ035','RFIDHFQ035','Bovino','2022-01-01','F','Hereford',0,4,5,3),(830,'TagHFQ036','RFIDHFQ036','Bovino','2022-01-01','F','Hereford',0,4,5,3),(831,'TagHFQ037','RFIDHFQ037','Bovino','2022-01-01','F','Hereford',0,4,5,3),(832,'TagHFQ038','RFIDHFQ038','Bovino','2022-01-01','F','Hereford',0,4,5,3),(833,'TagHFQ039','RFIDHFQ039','Bovino','2022-01-01','F','Hereford',0,4,5,3),(834,'TagHFQ040','RFIDHFQ040','Bovino','2022-01-01','F','Hereford',0,4,5,3),(835,'TagHFQ041','RFIDHFQ041','Bovino','2022-01-01','F','Hereford',0,4,5,3),(836,'TagHFQ042','RFIDHFQ042','Bovino','2022-01-01','F','Hereford',0,4,5,3),(837,'TagHFQ043','RFIDHFQ043','Bovino','2022-01-01','F','Hereford',0,4,5,3),(838,'TagHFQ044','RFIDHFQ044','Bovino','2022-01-01','F','Hereford',0,4,5,3),(839,'TagHFQ045','RFIDHFQ045','Bovino','2022-01-01','F','Hereford',0,4,5,3),(840,'TagHFQ046','RFIDHFQ046','Bovino','2022-01-01','F','Hereford',0,4,5,3),(841,'TagHFQ047','RFIDHFQ047','Bovino','2022-01-01','F','Hereford',0,4,5,3),(842,'TagHFQ048','RFIDHFQ048','Bovino','2022-01-01','F','Hereford',0,4,5,3),(843,'TagHFQ049','RFIDHFQ049','Bovino','2022-01-01','F','Hereford',0,4,5,3),(844,'TagHFQ050','RFIDHFQ050','Bovino','2022-01-01','F','Hereford',0,4,5,3),(845,'TagHFQ051','RFIDHFQ051','Bovino','2022-01-01','F','Hereford',0,4,5,3),(846,'TagHFQ052','RFIDHFQ052','Bovino','2022-01-01','F','Hereford',0,4,5,3),(847,'TagHFQ053','RFIDHFQ053','Bovino','2022-01-01','F','Hereford',0,4,5,3),(848,'TagHFQ054','RFIDHFQ054','Bovino','2022-01-01','F','Hereford',0,4,5,3),(849,'TagHFQ055','RFIDHFQ055','Bovino','2022-01-01','F','Hereford',0,4,5,3),(850,'TagHFQ056','RFIDHFQ056','Bovino','2022-01-01','F','Hereford',0,4,5,3),(851,'TagHFQ057','RFIDHFQ057','Bovino','2022-01-01','F','Hereford',0,4,5,3),(852,'TagHFQ058','RFIDHFQ058','Bovino','2022-01-01','F','Hereford',0,4,5,3),(853,'TagHFQ059','RFIDHFQ059','Bovino','2022-01-01','F','Hereford',0,4,5,3),(854,'TagHFQ060','RFIDHFQ060','Bovino','2022-01-01','F','Hereford',0,4,5,3),(855,'TagHFQ061','RFIDHFQ061','Bovino','2022-01-01','F','Hereford',0,4,5,3),(856,'TagHFQ062','RFIDHFQ062','Bovino','2022-01-01','F','Hereford',0,4,5,3),(857,'TagHFQ063','RFIDHFQ063','Bovino','2022-01-01','F','Hereford',0,4,5,3),(858,'TagHFQ064','RFIDHFQ064','Bovino','2022-01-01','F','Hereford',0,4,5,3),(859,'TagHFQ065','RFIDHFQ065','Bovino','2022-01-01','F','Hereford',0,4,5,3),(860,'TagHFQ066','RFIDHFQ066','Bovino','2022-01-01','F','Hereford',0,4,5,3),(861,'TagHFQ067','RFIDHFQ067','Bovino','2022-01-01','F','Hereford',0,4,5,3),(862,'TagHFQ068','RFIDHFQ068','Bovino','2022-01-01','F','Hereford',0,4,5,3),(863,'TagHFQ069','RFIDHFQ069','Bovino','2022-01-01','F','Hereford',0,4,5,3),(864,'TagHFQ070','RFIDHFQ070','Bovino','2022-01-01','F','Hereford',0,4,5,3),(865,'TagHFQ071','RFIDHFQ071','Bovino','2022-01-01','F','Hereford',0,4,5,3),(866,'TagHFQ072','RFIDHFQ072','Bovino','2022-01-01','F','Hereford',0,4,5,3),(867,'TagHFQ073','RFIDHFQ073','Bovino','2022-01-01','F','Hereford',0,4,5,3),(868,'TagHFQ074','RFIDHFQ074','Bovino','2022-01-01','F','Hereford',0,4,5,3),(869,'TagHFQ075','RFIDHFQ075','Bovino','2022-01-01','F','Hereford',0,4,5,3),(870,'TagHFQ076','RFIDHFQ076','Bovino','2022-01-01','F','Hereford',0,4,5,3),(871,'TagHFQ077','RFIDHFQ077','Bovino','2022-01-01','F','Hereford',0,4,5,3),(872,'TagHFQ078','RFIDHFQ078','Bovino','2022-01-01','F','Hereford',0,4,5,3),(873,'TagHFQ079','RFIDHFQ079','Bovino','2022-01-01','F','Hereford',0,4,5,3),(874,'TagHFQ080','RFIDHFQ080','Bovino','2022-01-01','F','Hereford',0,4,5,3),(875,'TagHFQ081','RFIDHFQ081','Bovino','2022-01-01','F','Hereford',0,4,5,3),(876,'TagHFQ082','RFIDHFQ082','Bovino','2022-01-01','F','Hereford',0,4,5,3),(877,'TagHFQ083','RFIDHFQ083','Bovino','2022-01-01','F','Hereford',0,4,5,3),(878,'TagHFQ084','RFIDHFQ084','Bovino','2022-01-01','F','Hereford',0,4,5,3),(879,'TagHFQ085','RFIDHFQ085','Bovino','2022-01-01','F','Hereford',0,4,5,3),(880,'TagHFQ086','RFIDHFQ086','Bovino','2022-01-01','F','Hereford',0,4,5,3),(881,'TagHFQ087','RFIDHFQ087','Bovino','2022-01-01','F','Hereford',0,4,5,3),(882,'TagHFQ088','RFIDHFQ088','Bovino','2022-01-01','F','Hereford',0,4,5,3),(883,'TagHFQ089','RFIDHFQ089','Bovino','2022-01-01','F','Hereford',0,4,5,3),(884,'TagHFQ090','RFIDHFQ090','Bovino','2022-01-01','F','Hereford',0,4,5,3),(922,'TagSHQ001','RFIDSHQ001','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(923,'TagSHQ002','RFIDSHQ002','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(924,'TagSHQ003','RFIDSHQ003','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(925,'TagSHQ004','RFIDSHQ004','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(926,'TagSHQ005','RFIDSHQ005','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(927,'TagSHQ006','RFIDSHQ006','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(928,'TagSHQ007','RFIDSHQ007','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(929,'TagSHQ008','RFIDSHQ008','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(930,'TagSHQ009','RFIDSHQ009','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(931,'TagSHQ010','RFIDSHQ010','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(932,'TagSHQ011','RFIDSHQ011','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(933,'TagSHQ012','RFIDSHQ012','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(934,'TagSHQ013','RFIDSHQ013','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(935,'TagSHQ014','RFIDSHQ014','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(936,'TagSHQ015','RFIDSHQ015','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(937,'TagSHQ016','RFIDSHQ016','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(938,'TagSHQ017','RFIDSHQ017','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(939,'TagSHQ018','RFIDSHQ018','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(940,'TagSHQ019','RFIDSHQ019','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(941,'TagSHQ020','RFIDSHQ020','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(942,'TagSHQ021','RFIDSHQ021','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(943,'TagSHQ022','RFIDSHQ022','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(944,'TagSHQ023','RFIDSHQ023','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(945,'TagSHQ024','RFIDSHQ024','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(946,'TagSHQ025','RFIDSHQ025','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(947,'TagSHQ026','RFIDSHQ026','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(948,'TagSHQ027','RFIDSHQ027','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(949,'TagSHQ028','RFIDSHQ028','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(950,'TagSHQ029','RFIDSHQ029','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(951,'TagSHQ030','RFIDSHQ030','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(952,'TagSHQ031','RFIDSHQ031','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(953,'TagSHQ032','RFIDSHQ032','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(954,'TagSHQ033','RFIDSHQ033','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(955,'TagSHQ034','RFIDSHQ034','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(956,'TagSHQ035','RFIDSHQ035','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(957,'TagSHQ036','RFIDSHQ036','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(958,'TagSHQ037','RFIDSHQ037','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(959,'TagSHQ038','RFIDSHQ038','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(960,'TagSHQ039','RFIDSHQ039','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(961,'TagSHQ040','RFIDSHQ040','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(962,'TagSHQ041','RFIDSHQ041','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(963,'TagSHQ042','RFIDSHQ042','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(964,'TagSHQ043','RFIDSHQ043','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(965,'TagSHQ044','RFIDSHQ044','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(966,'TagSHQ045','RFIDSHQ045','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(967,'TagSHQ046','RFIDSHQ046','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(968,'TagSHQ047','RFIDSHQ047','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(969,'TagSHQ048','RFIDSHQ048','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(970,'TagSHQ049','RFIDSHQ049','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(971,'TagSHQ050','RFIDSHQ050','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(972,'TagSHQ051','RFIDSHQ051','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(973,'TagSHQ052','RFIDSHQ052','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(974,'TagSHQ053','RFIDSHQ053','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(975,'TagSHQ054','RFIDSHQ054','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(976,'TagSHQ055','RFIDSHQ055','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(977,'TagSHQ056','RFIDSHQ056','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(978,'TagSHQ057','RFIDSHQ057','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(979,'TagSHQ058','RFIDSHQ058','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(980,'TagSHQ059','RFIDSHQ059','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(981,'TagSHQ060','RFIDSHQ060','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(982,'TagSHQ061','RFIDSHQ061','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(983,'TagSHQ062','RFIDSHQ062','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(984,'TagSHQ063','RFIDSHQ063','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(985,'TagSHQ064','RFIDSHQ064','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(986,'TagSHQ065','RFIDSHQ065','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(987,'TagSHQ066','RFIDSHQ066','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(988,'TagSHQ067','RFIDSHQ067','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(989,'TagSHQ068','RFIDSHQ068','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(990,'TagSHQ069','RFIDSHQ069','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(991,'TagSHQ070','RFIDSHQ070','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(992,'TagSHQ071','RFIDSHQ071','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(993,'TagSHQ072','RFIDSHQ072','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(994,'TagSHQ073','RFIDSHQ073','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(995,'TagSHQ074','RFIDSHQ074','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(996,'TagSHQ075','RFIDSHQ075','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(997,'TagSHQ076','RFIDSHQ076','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(998,'TagSHQ077','RFIDSHQ077','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(999,'TagSHQ078','RFIDSHQ078','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1000,'TagSHQ079','RFIDSHQ079','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1001,'TagSHQ080','RFIDSHQ080','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1002,'TagSHQ081','RFIDSHQ081','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1003,'TagSHQ082','RFIDSHQ082','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1004,'TagSHQ083','RFIDSHQ083','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1005,'TagSHQ084','RFIDSHQ084','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1006,'TagSHQ085','RFIDSHQ085','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1007,'TagSHQ086','RFIDSHQ086','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1008,'TagSHQ087','RFIDSHQ087','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1009,'TagSHQ088','RFIDSHQ088','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1010,'TagSHQ089','RFIDSHQ089','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1011,'TagSHQ090','RFIDSHQ090','Bovino','2022-01-01','F','Shorthorn',0,4,6,3),(1234,'TAG123456','RFID123456','Bovino','2019-07-16','M','Brangus',0,2,7,3),(1237,'LM001ANN','RFIDLM001','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1238,'LM002ANN','RFIDLM002','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1239,'LM003ANN','RFIDLM003','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1240,'LM004ANN','RFIDLM004','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1241,'LM005ANN','RFIDLM005','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1242,'LM006ANN','RFIDLM006','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1243,'LM007ANN','RFIDLM007','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1244,'LM008ANN','RFIDLM008','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1245,'LM009ANN','RFIDLM009','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1246,'LM010ANN','RFIDLM010','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1247,'LM011ANN','RFIDLM011','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1248,'LM012ANN','RFIDLM012','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1249,'LM013ANN','RFIDLM013','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1250,'LM014ANN','RFIDLM014','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1251,'LM015ANN','RFIDLM015','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1252,'LM016ANN','RFIDLM016','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1253,'LM017ANN','RFIDLM017','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1254,'LM018ANN','RFIDLM018','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1255,'LM019ANN','RFIDLM019','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1256,'LM020ANN','RFIDLM020','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1257,'LM021ANN','RFIDLM021','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1258,'LM022ANN','RFIDLM022','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1259,'LM023ANN','RFIDLM023','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1260,'LM024ANN','RFIDLM024','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1261,'LM025ANN','RFIDLM025','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1262,'LM026ANN','RFIDLM026','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1263,'LM027ANN','RFIDLM027','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1264,'LM028ANN','RFIDLM028','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1265,'LM029ANN','RFIDLM029','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1266,'LM030ANN','RFIDLM030','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1267,'LM031ANN','RFIDLM031','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1268,'LM032ANN','RFIDLM032','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1269,'LM033ANN','RFIDLM033','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1270,'LM034ANN','RFIDLM034','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1271,'LM035ANN','RFIDLM035','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1272,'LM036ANN','RFIDLM036','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1273,'LM037ANN','RFIDLM037','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1274,'LM038ANN','RFIDLM038','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1275,'LM039ANN','RFIDLM039','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1276,'LM040ANN','RFIDLM040','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1277,'LM041ANN','RFIDLM041','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1278,'LM042ANN','RFIDLM042','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1279,'LM043ANN','RFIDLM043','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1280,'LM044ANN','RFIDLM044','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1281,'LM045ANN','RFIDLM045','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1282,'LM046ANN','RFIDLM046','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1283,'LM047ANN','RFIDLM047','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1284,'LM048ANN','RFIDLM048','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1285,'LM049ANN','RFIDLM049','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1286,'LM050ANN','RFIDLM050','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1287,'LM051ANN','RFIDLM051','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1288,'LM052ANN','RFIDLM052','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1289,'LM053ANN','RFIDLM053','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1290,'LM054ANN','RFIDLM054','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1291,'LM055ANN','RFIDLM055','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1292,'LM056ANN','RFIDLM056','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1293,'LM057ANN','RFIDLM057','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1294,'LM058ANN','RFIDLM058','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1295,'LM059ANN','RFIDLM059','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1296,'LM060ANN','RFIDLM060','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1297,'LM061ANN','RFIDLM061','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1298,'LM062ANN','RFIDLM062','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1299,'LM063ANN','RFIDLM063','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1300,'LM064ANN','RFIDLM064','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1301,'LM065ANN','RFIDLM065','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1302,'LM066ANN','RFIDLM066','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1303,'LM067ANN','RFIDLM067','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1304,'LM068ANN','RFIDLM068','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1305,'LM069ANN','RFIDLM069','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1306,'LM070ANN','RFIDLM070','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1307,'LM071ANN','RFIDLM071','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1308,'LM072ANN','RFIDLM072','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1309,'LM073ANN','RFIDLM073','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1310,'LM074ANN','RFIDLM074','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1311,'LM075ANN','RFIDLM075','Bovino','2022-01-01','M','Angus Negro',1,3,11,4),(1365,'LM076ANC','RFIDLM076','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1366,'LM077ANC','RFIDLM077','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1367,'LM078ANC','RFIDLM078','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1368,'LM079ANC','RFIDLM079','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1369,'LM080ANC','RFIDLM080','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1370,'LM081ANC','RFIDLM081','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1371,'LM082ANC','RFIDLM082','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1372,'LM083ANC','RFIDLM083','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1373,'LM084ANC','RFIDLM084','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1374,'LM085ANC','RFIDLM085','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1375,'LM086ANC','RFIDLM086','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1376,'LM087ANC','RFIDLM087','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1377,'LM088ANC','RFIDLM088','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1378,'LM089ANC','RFIDLM089','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1379,'LM090ANC','RFIDLM090','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1380,'LM091ANC','RFIDLM091','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1381,'LM092ANC','RFIDLM092','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1382,'LM093ANC','RFIDLM093','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1383,'LM094ANC','RFIDLM094','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1384,'LM095ANC','RFIDLM095','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1385,'LM096ANC','RFIDLM096','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1386,'LM097ANC','RFIDLM097','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1387,'LM098ANC','RFIDLM098','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1388,'LM099ANC','RFIDLM099','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1389,'LM100ANC','RFIDLM100','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1390,'LM101ANC','RFIDLM101','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1391,'LM102ANC','RFIDLM102','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1392,'LM103ANC','RFIDLM103','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1393,'LM104ANC','RFIDLM104','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1394,'LM105ANC','RFIDLM105','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1395,'LM106ANC','RFIDLM106','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1396,'LM107ANC','RFIDLM107','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1397,'LM108ANC','RFIDLM108','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1398,'LM109ANC','RFIDLM109','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1399,'LM110ANC','RFIDLM110','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1400,'LM111ANC','RFIDLM111','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1401,'LM112ANC','RFIDLM112','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1402,'LM113ANC','RFIDLM113','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1403,'LM114ANC','RFIDLM114','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1404,'LM115ANC','RFIDLM115','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1405,'LM116ANC','RFIDLM116','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1406,'LM117ANC','RFIDLM117','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1407,'LM118ANC','RFIDLM118','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1408,'LM119ANC','RFIDLM119','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1409,'LM120ANC','RFIDLM120','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1410,'LM121ANC','RFIDLM121','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1411,'LM122ANC','RFIDLM122','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1412,'LM123ANC','RFIDLM123','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1413,'LM124ANC','RFIDLM124','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1414,'LM125ANC','RFIDLM125','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1415,'LM126ANC','RFIDLM126','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1416,'LM127ANC','RFIDLM127','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1417,'LM128ANC','RFIDLM128','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1418,'LM129ANC','RFIDLM129','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4),(1419,'LM130ANC','RFIDLM130','Bovino','2022-01-01','M','Angus Colorado',1,3,12,4);
/*!40000 ALTER TABLE `animales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(50) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Vaca',NULL),(2,'Toro',NULL),(3,'Novillo',NULL),(4,'Vaquillona',NULL),(5,'Novillito',NULL),(6,'Torito',NULL),(7,'Ternera',NULL),(8,'Ternero',NULL);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventossalida`
--

DROP TABLE IF EXISTS `eventossalida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventossalida` (
  `idEventoSalida` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int NOT NULL,
  `fechaEvento` date NOT NULL,
  `tipoEvento` varchar(50) NOT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `idCategoria` int NOT NULL,
  `idOperario` int NOT NULL,
  PRIMARY KEY (`idEventoSalida`),
  KEY `fechaEvento` (`fechaEvento`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idOperario` (`idOperario`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `eventossalida_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animales` (`idAnimal`),
  CONSTRAINT `eventossalida_ibfk_2` FOREIGN KEY (`idOperario`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `eventossalida_ibfk_3` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`),
  CONSTRAINT `eventossalida_chk_1` CHECK ((`tipoEvento` in (_utf8mb4'Venta',_utf8mb4'Muerte')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventossalida`
--

LOCK TABLES `eventossalida` WRITE;
/*!40000 ALTER TABLE `eventossalida` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventossalida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialcambioscategoria`
--

DROP TABLE IF EXISTS `historialcambioscategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialcambioscategoria` (
  `idCambio` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int NOT NULL,
  `idCategoriaAnterior` int DEFAULT NULL,
  `idCategoriaNueva` int NOT NULL,
  `fechaCambio` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCambio`),
  KEY `fechaCambio` (`fechaCambio`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idCategoriaAnterior` (`idCategoriaAnterior`),
  KEY `idCategoriaNueva` (`idCategoriaNueva`),
  CONSTRAINT `historialcambioscategoria_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animales` (`idAnimal`),
  CONSTRAINT `historialcambioscategoria_ibfk_2` FOREIGN KEY (`idCategoriaAnterior`) REFERENCES `categorias` (`idCategoria`),
  CONSTRAINT `historialcambioscategoria_ibfk_3` FOREIGN KEY (`idCategoriaNueva`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialcambioscategoria`
--

LOCK TABLES `historialcambioscategoria` WRITE;
/*!40000 ALTER TABLE `historialcambioscategoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialcambioscategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialpesajes`
--

DROP TABLE IF EXISTS `historialpesajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialpesajes` (
  `idPesaje` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int NOT NULL,
  `fechaPesaje` datetime DEFAULT CURRENT_TIMESTAMP,
  `peso` float NOT NULL,
  `idCategoria` int NOT NULL,
  `idOperario` int NOT NULL,
  PRIMARY KEY (`idPesaje`),
  KEY `fechaPesaje` (`fechaPesaje`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idOperario` (`idOperario`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `historialpesajes_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animales` (`idAnimal`),
  CONSTRAINT `historialpesajes_ibfk_2` FOREIGN KEY (`idOperario`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `historialpesajes_ibfk_3` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialpesajes`
--

LOCK TABLES `historialpesajes` WRITE;
/*!40000 ALTER TABLE `historialpesajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialpesajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialreproductivovacas`
--

DROP TABLE IF EXISTS `historialreproductivovacas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialreproductivovacas` (
  `idHistorial` int NOT NULL AUTO_INCREMENT,
  `idVaca` int NOT NULL,
  `estadoReproductivo` varchar(50) DEFAULT NULL,
  `conTerneroAlPie` tinyint(1) DEFAULT '0',
  `descripcionDental` varchar(50) DEFAULT NULL,
  `estadoVenta` varchar(50) DEFAULT NULL,
  `fechaUltimoParto` date DEFAULT NULL,
  `fechaUltimaInseminacion` date DEFAULT NULL,
  PRIMARY KEY (`idHistorial`),
  KEY `idVaca` (`idVaca`),
  CONSTRAINT `historialreproductivovacas_ibfk_1` FOREIGN KEY (`idVaca`) REFERENCES `animales` (`idAnimal`),
  CONSTRAINT `historialreproductivovacas_chk_1` CHECK ((`estadoReproductivo` in (_utf8mb4'Preñada',_utf8mb4'Seca'))),
  CONSTRAINT `historialreproductivovacas_chk_2` CHECK ((`descripcionDental` in (_utf8mb4'Buena',_utf8mb4'Medio diente',_utf8mb4'C.U.T.'))),
  CONSTRAINT `historialreproductivovacas_chk_3` CHECK (((`estadoVenta` in (_utf8mb4'Normal',_utf8mb4'Conserva')) or (`estadoVenta` is null)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialreproductivovacas`
--

LOCK TABLES `historialreproductivovacas` WRITE;
/*!40000 ALTER TABLE `historialreproductivovacas` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialreproductivovacas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historialsalud`
--

DROP TABLE IF EXISTS `historialsalud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historialsalud` (
  `idEventoSalud` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int NOT NULL,
  `fechaEvento` date NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`idEventoSalud`),
  KEY `idAnimal` (`idAnimal`),
  CONSTRAINT `historialsalud_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animales` (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historialsalud`
--

LOCK TABLES `historialsalud` WRITE;
/*!40000 ALTER TABLE `historialsalud` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialsalud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lotes`
--

DROP TABLE IF EXISTS `lotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lotes` (
  `idLote` int NOT NULL AUTO_INCREMENT,
  `nombreLote` varchar(100) NOT NULL,
  `idParcela` int NOT NULL,
  `idPropietario` int NOT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idLote`),
  KEY `idParcela` (`idParcela`),
  KEY `idPropietario` (`idPropietario`),
  CONSTRAINT `lotes_ibfk_1` FOREIGN KEY (`idParcela`) REFERENCES `parcelas` (`idParcela`),
  CONSTRAINT `lotes_ibfk_2` FOREIGN KEY (`idPropietario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lotes`
--

LOCK TABLES `lotes` WRITE;
/*!40000 ALTER TABLE `lotes` DISABLE KEYS */;
INSERT INTO `lotes` VALUES (1,'CF001',1,3,'2024-05-20 23:25:05'),(2,'CF002',4,3,'2024-05-20 23:25:05'),(3,'CF003',5,3,'2024-05-20 23:25:05'),(4,'CF004',6,3,'2024-05-20 23:25:05'),(5,'CF005',8,3,'2024-05-20 23:25:05'),(6,'CF006',9,3,'2024-05-20 23:25:05'),(7,'CF007',10,3,'2024-05-20 23:25:05'),(8,'CF008',11,3,'2024-05-20 23:25:05'),(9,'CF009',13,3,'2024-05-20 23:25:05'),(10,'CF010',14,3,'2024-05-20 23:25:05'),(11,'LM001',21,5,'2024-05-26 19:09:40'),(12,'LM002',23,5,'2024-05-26 19:09:40'),(13,'LM003',20,5,'2024-05-26 19:09:40'),(14,'LM004',19,5,'2024-05-26 19:09:40'),(15,'LM005',19,5,'2024-05-26 19:09:40'),(16,'LM006',24,5,'2024-05-26 19:09:40');
/*!40000 ALTER TABLE `lotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientoshacienda`
--

DROP TABLE IF EXISTS `movimientoshacienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientoshacienda` (
  `idMovimiento` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int NOT NULL,
  `idLoteOrigen` int DEFAULT NULL,
  `idLoteDestino` int NOT NULL,
  `fechaMovimiento` datetime DEFAULT CURRENT_TIMESTAMP,
  `motivo` varchar(255) DEFAULT NULL,
  `idCategoria` int NOT NULL,
  `idOperario` int NOT NULL,
  PRIMARY KEY (`idMovimiento`),
  KEY `fechaMovimiento` (`fechaMovimiento`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idLoteOrigen` (`idLoteOrigen`),
  KEY `idLoteDestino` (`idLoteDestino`),
  KEY `idOperario` (`idOperario`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `movimientoshacienda_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animales` (`idAnimal`),
  CONSTRAINT `movimientoshacienda_ibfk_2` FOREIGN KEY (`idLoteOrigen`) REFERENCES `lotes` (`idLote`) ON DELETE SET NULL,
  CONSTRAINT `movimientoshacienda_ibfk_3` FOREIGN KEY (`idLoteDestino`) REFERENCES `lotes` (`idLote`) ON DELETE RESTRICT,
  CONSTRAINT `movimientoshacienda_ibfk_4` FOREIGN KEY (`idOperario`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `movimientoshacienda_ibfk_5` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientoshacienda`
--

LOCK TABLES `movimientoshacienda` WRITE;
/*!40000 ALTER TABLE `movimientoshacienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientoshacienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numbers`
--

DROP TABLE IF EXISTS `numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `numbers` (
  `number` int NOT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numbers`
--

LOCK TABLES `numbers` WRITE;
/*!40000 ALTER TABLE `numbers` DISABLE KEYS */;
INSERT INTO `numbers` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(18),(19),(20),(21),(22),(23),(24),(25),(26),(27),(28),(29),(30),(31),(32),(33),(34),(35),(36),(37),(38),(39),(40),(41),(42),(43),(44),(45),(46),(47),(48),(49),(50),(51),(52),(53),(54),(55),(56),(57),(58),(59),(60),(61),(62),(63),(64),(65),(66),(67),(68),(69),(70),(71),(72),(73),(74),(75),(76),(77),(78),(79),(80),(81),(82),(83),(84),(85),(86),(87),(88),(89),(90),(91),(92),(93),(94),(95),(96),(97),(98),(99),(100),(101),(102),(103),(104),(105),(106),(107),(108),(109),(110),(111),(112),(113),(114),(115),(116),(117),(118),(119),(120),(121),(122),(123),(124),(125),(126),(127),(128),(129),(130),(131),(132),(133),(134),(135),(136),(137),(138),(139),(140),(141),(142),(143),(144),(145),(146),(147),(148),(149),(150);
/*!40000 ALTER TABLE `numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcelas`
--

DROP TABLE IF EXISTS `parcelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parcelas` (
  `idParcela` int NOT NULL AUTO_INCREMENT,
  `nombreParcela` varchar(100) NOT NULL,
  `ubicacion` varchar(255) NOT NULL,
  `superficie` float NOT NULL,
  `uso` varchar(50) NOT NULL,
  `idPropiedad` int DEFAULT NULL,
  PRIMARY KEY (`idParcela`),
  KEY `idPropiedad` (`idPropiedad`),
  CONSTRAINT `parcelas_ibfk_1` FOREIGN KEY (`idPropiedad`) REFERENCES `propiedades` (`idPropiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcelas`
--

LOCK TABLES `parcelas` WRITE;
/*!40000 ALTER TABLE `parcelas` DISABLE KEYS */;
INSERT INTO `parcelas` VALUES (1,'Parcela 1','Sector Norte',94,'Pastoreo',1),(2,'Parcela 2','Sector Este',98,'Cultivo',1),(3,'Parcela 3','Sector Sur',101,'Cultivo',1),(4,'Parcela 4','Sector Oeste',82,'Pastoreo',1),(5,'Parcela 5','Sector Central',64,'Pastoreo',1),(6,'Parcela 6','Sector Norte',71,'Pastoreo',1),(7,'Parcela 7','Sector Este',103,'Cultivo',1),(8,'Parcela 8','Sector Sur',95,'Pastoreo',1),(9,'Parcela 9','Sector Oeste',87,'Pastoreo',1),(10,'Parcela 10','Sector Central',77,'Pastoreo',1),(11,'Parcela 11','Sector Norte',70,'Pastoreo',1),(12,'Parcela 12','Sector Este',108,'Cultivo',1),(13,'Parcela 13','Sector Sur',79,'Pastoreo',1),(14,'Parcela 14','Sector Oeste',107,'Pastoreo',1),(15,'El alambre','Sector 1',100,'Pastoreo',2),(16,'Cañadón Grande','Sector 1',56,'Pastoreo',2),(17,'Los Teros','Sector 1',70,'Pastoreo',2),(18,'Puesto Viejo','Sector 2',122,'Cultivo',2),(19,'El Caracol','Sector 2',88,'Pastoreo',2),(20,'Los Talitas','Sector 2',67,'Pastoreo',2),(21,'Santa Ana','Sector 3',53,'Pastoreo',2),(22,'La Espadaña','Sector 3',138,'Cultivo',2),(23,'La Efe','Sector 3',109,'Pastoreo',2),(24,'La Sombra','Sector 3',69,'Pastoreo',2),(25,'Callejón 1','Callejón',78.99,'Cultivo',3),(26,'Callejón 2','Callejón',67.78,'Cultivo',3),(27,'Callejón 3','Callejón',44.51,'Cultivo',3),(28,'Callejón 4','Callejón',58.05,'Cultivo',3),(29,'Tacuaras 1','Tacuaras',58.68,'Pastoreo',3),(30,'Tacuaras 2','Tacuaras',86.55,'Pastoreo',3),(31,'Tacuaras 3','Tacuaras',81.93,'Pastoreo',3),(32,'Alfalfa 1','Alfalfa',95.99,'Cultivo',3),(33,'Alfalfa 2','Alfalfa',54.42,'Cultivo',3),(34,'Don Carlos Norte 1','Don Carlos Norte',68.14,'Pastoreo',3),(35,'Don Carlos Norte 2','Don Carlos Norte',54.98,'Pastoreo',3),(36,'Don Carlos Norte 3','Don Carlos Norte',91.09,'Pastoreo',3),(37,'Don Carlos Sur 1','Don Carlos Sur',70.28,'Pastoreo',3),(38,'Don Carlos Sur 2','Don Carlos Sur',56.6,'Pastoreo',3),(39,'Doña Luisa 1','Doña Luisa',79.27,'Pastoreo',3),(40,'Doña Luisa 2','Doña Luisa',45.47,'Pastoreo',3),(41,'Doña Luisa 3','Doña Luisa',96.56,'Pastoreo',3),(42,'Doña Luisa 4','Doña Luisa',71.83,'Pastoreo',3),(43,'Doña Luisa 5','Doña Luisa',68.39,'Pastoreo',3),(44,'Doña Luisa 6','Doña Luisa',158.48,'Pastoreo',3),(45,'El Casco','Casco',12,'Recreativo',3),(46,'Pampa Larga','Sur',87,'Pastoreo',4),(47,'El Mate','Norte',51,'Pastoreo',4),(48,'La Guitarra','Sur',70,'Pastoreo',4),(49,'El Fogón','Norte',82,'Pastoreo',4),(50,'Zaino Zarco','Sur',61,'Pastoreo',4),(51,'La Carreta','Norte',107,'Pastoreo',4),(52,'Las Bolas','Sur',71,'Pastoreo',4),(53,'Las Tropillas','Norte',93,'Pastoreo',4),(54,'Puente Viejo','Sur',74,'Pastoreo',4),(55,'Tolderías','Norte',98,'Pastoreo',4),(56,'El Relincho','Sur',76,'Pastoreo',4),(57,'El Tapón','Norte',91,'Pastoreo',4),(58,'Cimarrón Manco','Sur',60,'Pastoreo',4);
/*!40000 ALTER TABLE `parcelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propiedades`
--

DROP TABLE IF EXISTS `propiedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propiedades` (
  `idPropiedad` int NOT NULL AUTO_INCREMENT,
  `nombrePropiedad` varchar(100) NOT NULL,
  `ubicacion` varchar(255) NOT NULL,
  `superficie` float NOT NULL,
  `tipoPropiedad` varchar(50) NOT NULL,
  `fechaRegistro` datetime DEFAULT CURRENT_TIMESTAMP,
  `idPropietario` int DEFAULT NULL,
  PRIMARY KEY (`idPropiedad`),
  KEY `idPropietario` (`idPropietario`),
  CONSTRAINT `propiedades_ibfk_1` FOREIGN KEY (`idPropietario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propiedades`
--

LOCK TABLES `propiedades` WRITE;
/*!40000 ALTER TABLE `propiedades` DISABLE KEYS */;
INSERT INTO `propiedades` VALUES (1,'Campo Los Alamos','Ruta 40 km 85',1236,'Cría','2024-05-20 23:25:05',3),(2,'Estancia La Merced','Ruta 22 km 182',872,'Mixta','2024-05-20 23:25:05',4),(3,'Campo El Trébol','Ruta 5 km 110',1500,'Engorde','2024-05-20 23:25:05',5),(4,'Estancia San Carlos','Ruta 8 km 200',1021,'Cría','2024-05-20 23:25:05',3);
/*!40000 ALTER TABLE `propiedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(50) NOT NULL,
  PRIMARY KEY (`idRol`),
  CONSTRAINT `roles_chk_1` CHECK ((`nombreRol` in (_utf8mb4'Administrador',_utf8mb4'Propietario',_utf8mb4'Operario')))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Propietario'),(3,'Operario'),(4,'Administrador'),(5,'Propietario'),(6,'Operario');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanidad`
--

DROP TABLE IF EXISTS `sanidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanidad` (
  `idSanidad` int NOT NULL AUTO_INCREMENT,
  `idAnimal` int DEFAULT NULL,
  `idLote` int DEFAULT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date DEFAULT NULL,
  `tratamiento` varchar(255) NOT NULL,
  `resultado` varchar(255) DEFAULT NULL,
  `idCategoria` int NOT NULL,
  `idOperario` int NOT NULL,
  PRIMARY KEY (`idSanidad`),
  KEY `fechaInicio` (`fechaInicio`),
  KEY `idAnimal` (`idAnimal`),
  KEY `idLote` (`idLote`),
  KEY `idOperario` (`idOperario`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `sanidad_ibfk_1` FOREIGN KEY (`idAnimal`) REFERENCES `animales` (`idAnimal`) ON DELETE SET NULL,
  CONSTRAINT `sanidad_ibfk_2` FOREIGN KEY (`idLote`) REFERENCES `lotes` (`idLote`) ON DELETE SET NULL,
  CONSTRAINT `sanidad_ibfk_3` FOREIGN KEY (`idOperario`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `sanidad_ibfk_4` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanidad`
--

LOCK TABLES `sanidad` WRITE;
/*!40000 ALTER TABLE `sanidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `sanidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaActualizacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estaActivo` tinyint(1) NOT NULL DEFAULT '1',
  `idRol` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `email` (`email`),
  KEY `idRol` (`idRol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Juan','Pérez','juan.perez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 09:11:52',1,1),(2,'Laura','García','laura.garcia@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,1),(3,'Carlos','Fernandez','carlos.fernandez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,2),(4,'Lucía','Martinez','lucia.martinez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,2),(5,'Diego','Lopez','diego.lopez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,2),(6,'Mariana','Gomez','mariana.gomez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3),(7,'Sergio','Romero','sergio.romero@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3),(8,'Gabriela','Diaz','gabriela.diaz@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3),(9,'Roberto','Sanchez','roberto.sanchez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3),(10,'Julia','Alvarez','julia.alvarez@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3),(11,'Fernando','Ruiz','fernando.ruiz@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3),(12,'Ana','Morales','ana.morales@example.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','2024-05-20 23:25:05','2024-05-21 10:58:52',1,3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-08 20:11:45
