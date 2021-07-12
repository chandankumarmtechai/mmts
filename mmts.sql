-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: mmts
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `bookticket`
--

DROP TABLE IF EXISTS `bookticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookticket` (
  `pnr` varchar(255) NOT NULL,
  `s_code` varchar(255) DEFAULT NULL,
  `d_code` varchar(255) DEFAULT NULL,
  `fair` double DEFAULT NULL,
  `dtime` datetime DEFAULT NULL,
  `noadult` int DEFAULT NULL,
  `nochild` int DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pnr`),
  KEY `s_code` (`s_code`),
  KEY `d_code` (`d_code`),
  KEY `cname` (`cname`),
  CONSTRAINT `bookticket_ibfk_1` FOREIGN KEY (`s_code`) REFERENCES `station` (`code`),
  CONSTRAINT `bookticket_ibfk_2` FOREIGN KEY (`d_code`) REFERENCES `station` (`code`),
  CONSTRAINT `bookticket_ibfk_3` FOREIGN KEY (`cname`) REFERENCES `class` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookticket`
--

LOCK TABLES `bookticket` WRITE;
/*!40000 ALTER TABLE `bookticket` DISABLE KEYS */;
INSERT INTO `bookticket` VALUES ('12021-06-30T05:42:23.554275600','lpi','fm',210,'2021-06-30 05:42:24',1,1,'first'),('12021-06-30T05:46:35.492319600','lpi','fm',210,'2021-06-30 05:46:35',1,1,'first'),('12021-06-30T05:47:20.507763600','lpi','fm',84,'2021-06-30 05:47:21',2,1,'vendor'),('12021-07-06T18:58:52.999827100','lpi','fm',84,'2021-07-06 18:58:53',2,1,'vendor'),('12021-07-06T19:00:48.326195600','lpi','fm',84,'2021-07-06 19:00:48',2,1,'vendor'),('1234567','lpi','fm',33,'2021-06-29 17:23:33',1,1,'first');
/*!40000 ALTER TABLE `bookticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `name` varchar(255) NOT NULL,
  `fair` double DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('abc',30),('adv',50),('first',10),('general',5),('ladies',3),('vendor',2);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `route_no` int NOT NULL,
  `first_code` varchar(255) DEFAULT NULL,
  `last_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`route_no`),
  KEY `first_code` (`first_code`),
  KEY `last_code` (`last_code`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`first_code`) REFERENCES `station` (`code`),
  CONSTRAINT `route_ibfk_2` FOREIGN KEY (`last_code`) REFERENCES `station` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'lpi','fm'),(2,'hyb','fm'),(3,'lpi','hyb');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `code` varchar(255) NOT NULL,
  `route_no` int NOT NULL,
  `distance` double DEFAULT NULL,
  PRIMARY KEY (`code`,`route_no`),
  KEY `route_no` (`route_no`),
  CONSTRAINT `routes_ibfk_1` FOREIGN KEY (`code`) REFERENCES `station` (`code`),
  CONSTRAINT `routes_ibfk_2` FOREIGN KEY (`route_no`) REFERENCES `route` (`route_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES ('atc',1,13),('atc',2,8),('bmt',1,8),('bmt',3,8),('brbd',1,4),('brbd',3,4),('btnr',1,5),('btnr',3,5),('cdnr',1,1),('cdnr',3,1),('dqb',1,18),('dqb',2,13),('fm',1,21),('fm',2,16),('fnb',1,6),('fnb',3,6),('hfz',1,2),('hfz',3,2),('hpg',1,20),('hpg',2,15),('htcy',1,3),('htcy',3,3),('hyb',2,0),('hyb',3,12),('jms',1,10),('jms',2,5),('joo',1,14),('joo',2,9),('kcg',1,16),('kcg',2,11),('kqd',2,2),('kqd',3,10),('lpi',1,0),('lpi',3,0),('lpl',2,1),('lpl',3,11),('mxt',1,17),('mxt',2,12),('nchs',1,7),('nchs',3,7),('nlrd',2,3),('nlrd',3,9),('Sc',1,11),('sc',2,6),('stpd',1,12),('stpd',2,7),('svp',1,9),('svp',2,4),('var',1,15),('var',2,10),('yka',1,19),('yka',2,14);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `station` (
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES ('Arts College','atc'),('Begumpet','bmt'),('Borabanda','brbd'),('Bharatnagar','btnr'),('Chandanagar','cdnr'),('Dabirpura','dqb'),('Falaknuma','fm'),('Fatehnagar','fnb'),('Hafeezpet','hfz'),('Huppuguda','hpg'),('Hitech City','htcy'),('Hyderabad','hyb'),('James Street','jms'),('Jamai Osmania','joo'),('Kacheguda','kcg'),('Khairatabad','kqd'),('Lingampally','lpi'),('Lakdi ka pul','lpl'),('Malakpet','mxt'),('Nature Cure Hospital','nchs'),('Necklace Road','nlrd'),('Secunderabad','sc'),('Sitafalmandi','stpd'),('Sanjeevaiah Park','svp'),('Vidyanagar','var'),('Yakutpura','yka');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-12 11:37:08
