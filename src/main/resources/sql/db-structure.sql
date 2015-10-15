-- Host: localhost    Database: TEST
-- ------------------------------------------------------
-- Server version	5.5.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- GLOBAL settings
-- H2 to MySQL compatibility
SET MODE MySQL;
-- HSQL to MySQL compatibility
--SET DATABASE SQL SYNTAX MYS TRUE;
--SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
----
------ CREATING AND SETTING THE DEFAULT SCHEMA
CREATE SCHEMA TEST;
SET SCHEMA TEST;
----
---- TABLE structure for table `users`
----
--
DROP TABLE IF EXISTS `customers`;
--/*!40101 SET @saved_cs_client     = @@character_set_client */;
--/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(2) DEFAULT NULL,
  `lastname` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
