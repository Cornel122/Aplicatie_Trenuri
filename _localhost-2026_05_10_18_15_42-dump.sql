-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aplicatie_trenuri
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rezervare`
--

DROP TABLE IF EXISTS `rezervare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervare` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email_client` varchar(255) DEFAULT NULL,
  `numar_bilete` int DEFAULT NULL,
  `tren_id` int DEFAULT NULL,
  `utilizator_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkknxuqyu1xcpmx022p6fh7o6e` (`utilizator_id`),
  KEY `FKgc8oco6t0j53b7r7pcah5d6ta` (`tren_id`),
  CONSTRAINT `FKgc8oco6t0j53b7r7pcah5d6ta` FOREIGN KEY (`tren_id`) REFERENCES `trenuri` (`id`),
  CONSTRAINT `FKiaxfatle0nv3b67c5s5fgc26j` FOREIGN KEY (`tren_id`) REFERENCES `tren` (`id`),
  CONSTRAINT `FKkknxuqyu1xcpmx022p6fh7o6e` FOREIGN KEY (`utilizator_id`) REFERENCES `utilizatori` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervare`
--

LOCK TABLES `rezervare` WRITE;
/*!40000 ALTER TABLE `rezervare` DISABLE KEYS */;
/*!40000 ALTER TABLE `rezervare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezervari`
--

DROP TABLE IF EXISTS `rezervari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezervari` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utilizator_id` int NOT NULL,
  `tren_id` int NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `numar_bilete` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `utilizator_id` (`utilizator_id`),
  KEY `tren_id` (`tren_id`),
  CONSTRAINT `rezervari_ibfk_1` FOREIGN KEY (`utilizator_id`) REFERENCES `utilizatori` (`id`),
  CONSTRAINT `rezervari_ibfk_2` FOREIGN KEY (`tren_id`) REFERENCES `trenuri` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezervari`
--

LOCK TABLES `rezervari` WRITE;
/*!40000 ALTER TABLE `rezervari` DISABLE KEYS */;
INSERT INTO `rezervari` VALUES (1,2,1,'alex@gmail.com',2),(2,3,1,'maria@gmail.com',3),(3,2,2,'alex@gmail.com',1),(4,1,1,'test@gmail.com',5),(5,1,1,'test@gmail.com',5),(6,1,1,'cornelrezerva@gmail.com',5),(10,1,1,'sbarceacornel2004@gmail.com',3),(11,1,1,'sbarceacornel2004@gmail.com',3),(12,6,3,'sbarceacornel2004@gmail.com',22);
/*!40000 ALTER TABLE `rezervari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rute`
--

DROP TABLE IF EXISTS `rute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tren_id` int NOT NULL,
  `statie_plecare_id` int NOT NULL,
  `statie_sosire_id` int NOT NULL,
  `ora_plecare` varchar(255) DEFAULT NULL,
  `ora_sosire` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tren_id` (`tren_id`),
  KEY `statie_plecare_id` (`statie_plecare_id`),
  KEY `statie_sosire_id` (`statie_sosire_id`),
  CONSTRAINT `rute_ibfk_1` FOREIGN KEY (`tren_id`) REFERENCES `trenuri` (`id`),
  CONSTRAINT `rute_ibfk_2` FOREIGN KEY (`statie_plecare_id`) REFERENCES `statii` (`id`),
  CONSTRAINT `rute_ibfk_3` FOREIGN KEY (`statie_sosire_id`) REFERENCES `statii` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rute`
--

LOCK TABLES `rute` WRITE;
/*!40000 ALTER TABLE `rute` DISABLE KEYS */;
INSERT INTO `rute` VALUES (1,1,1,3,'11:00','15:00'),(3,3,2,4,'11:30','15:00'),(4,1,1,2,'10:00','12:00'),(5,2,2,1,'21:00','1:00'),(6,3,2,3,'14:00','21:00');
/*!40000 ALTER TABLE `rute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statii`
--

DROP TABLE IF EXISTS `statii`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statii` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nume` (`nume`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statii`
--

LOCK TABLES `statii` WRITE;
/*!40000 ALTER TABLE `statii` DISABLE KEYS */;
INSERT INTO `statii` VALUES (2,'Brasov'),(3,'Bucuresti'),(1,'Cluj'),(4,'Constanta');
/*!40000 ALTER TABLE `statii` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tren`
--

DROP TABLE IF EXISTS `tren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tren` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacitate` int DEFAULT NULL,
  `intarziere` int DEFAULT NULL,
  `numar_tren` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tren`
--

LOCK TABLES `tren` WRITE;
/*!40000 ALTER TABLE `tren` DISABLE KEYS */;
/*!40000 ALTER TABLE `tren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trenuri`
--

DROP TABLE IF EXISTS `trenuri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trenuri` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numar_tren` varchar(255) DEFAULT NULL,
  `capacitate` int NOT NULL,
  `intarziere` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `numar_tren` (`numar_tren`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trenuri`
--

LOCK TABLES `trenuri` WRITE;
/*!40000 ALTER TABLE `trenuri` DISABLE KEYS */;
INSERT INTO `trenuri` VALUES (1,'IR500-MOD',150,2),(2,'R200',50,10),(3,'IC300',80,20),(5,'22',21,0),(6,'3',21,0),(8,'31',21,0),(9,'311',21,0);
/*!40000 ALTER TABLE `trenuri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizatori`
--

DROP TABLE IF EXISTS `utilizatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizatori` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) DEFAULT NULL,
  `parola` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nume` (`nume`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizatori`
--

LOCK TABLES `utilizatori` WRITE;
/*!40000 ALTER TABLE `utilizatori` DISABLE KEYS */;
INSERT INTO `utilizatori` VALUES (1,'admin','1234','ADMIN'),(2,'alex','1111','USER'),(3,'maria','2222','USER'),(4,'ion','1234','USER'),(6,'Cornel','1234','CLIENT');
/*!40000 ALTER TABLE `utilizatori` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-10 18:15:42
