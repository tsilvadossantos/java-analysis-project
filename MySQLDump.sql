-- MySQL dump 10.13  Distrib 5.7.9, for osx10.11 (x86_64)
--
-- Host: localhost    Database: networkmonitor
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Current Database: `networkmonitor`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `networkmonitor` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `networkmonitor`;

--
-- Table structure for table `destinationdata`
--

DROP TABLE IF EXISTS `destinationdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinationdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ipaddress` varchar(60) DEFAULT NULL,
  `bytes_received` int(11) DEFAULT '0',
  `timerange` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinationdata`
--

LOCK TABLES `destinationdata` WRITE;
/*!40000 ALTER TABLE `destinationdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinationdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinationsummary`
--

DROP TABLE IF EXISTS `destinationsummary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinationsummary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `con_total` float DEFAULT NULL,
  `bytes_total` float DEFAULT NULL,
  `bytes_min` float DEFAULT NULL,
  `bytes_avg` float DEFAULT NULL,
  `bytes_max` float DEFAULT NULL,
  `timerange` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinationsummary`
--

LOCK TABLES `destinationsummary` WRITE;
/*!40000 ALTER TABLE `destinationsummary` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinationsummary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webserverdata`
--

DROP TABLE IF EXISTS `webserverdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webserverdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dport` varchar(60) DEFAULT NULL,
  `packets_received` int(11) DEFAULT '0',
  `timerange` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webserverdata`
--

LOCK TABLES `webserverdata` WRITE;
/*!40000 ALTER TABLE `webserverdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `webserverdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webserversummary`
--

DROP TABLE IF EXISTS `webserversummary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webserversummary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `con_total` float DEFAULT NULL,
  `packets_total` float DEFAULT NULL,
  `packets_min` float DEFAULT NULL,
  `packets_avg` float DEFAULT NULL,
  `packets_max` float DEFAULT NULL,
  `timerange` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webserversummary`
--

LOCK TABLES `webserversummary` WRITE;
/*!40000 ALTER TABLE `webserversummary` DISABLE KEYS */;
/*!40000 ALTER TABLE `webserversummary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-07 18:25:51
