-- MySQL dump 10.13  Distrib 5.7.20, for Linux (i686)
--
-- Host: localhost    Database: Instituto
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `place_birth` varchar(25) NOT NULL,
  `photo` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (1,'Carla','Marquina','Av. Villazon #231','2004-05-19','Cochabamba','photo1.jpg'),(2,'Jose','Figueroa','C. Tumusla #433','2005-05-12','Sucre','photo2.jpg');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `classroom_id` bigint(20) unsigned NOT NULL,
  `activity_name` varchar(64) NOT NULL,
  `description` text NOT NULL,
  `activity_date` date NOT NULL,
  `activity_time` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,2,'Actividad 1','Descripcion de la actividad','2017-01-01','03:15:00'),(2,1,'Otra actividad','Descripcion de la actividad que es nueva.','2017-01-01','02:20:00'),(3,1,'Otra actividad','Descripcion de la actividad que es nueva.','2017-01-01','03:20:00'),(4,1,'acrtividad','descripcion','2017-01-01','03:20:00'),(5,3,'activifdad','descripcion	','2017-01-01','04:35:00'),(6,1,'activiad','descripcion','2017-01-01','03:35:00'),(7,2,'registrado','descripcion	','2017-01-18','03:25:00'),(8,2,'aldnasd','sdfsdf','2017-01-01','02:10:00'),(9,1,'ACTIVIDAD','DESCRIPC','2017-01-19','09:40:00'),(10,3,'Act','descripcion','2017-10-05','03:20:00');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `classroom_id` int(11) NOT NULL,
  `attendance_status` varchar(32) NOT NULL,
  `time_attendance` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,1,2,'PUNTUAL','2017-09-10 13:55:00'),(2,2,3,'PUNTUAL','2017-10-03 14:00:00'),(3,1,2,'TARDE','2017-11-10 15:10:00');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  `occupied` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'AULA A',50,20),(2,'AULA B',70,35),(3,'AULA C',100,15);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `classroom_id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `moment` datetime NOT NULL,
  `resend` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `classroom_id` (`classroom_id`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (2,2,3,'Aviso de Festejo','Este es unb mensaje de aviso de festividad que se hara el 14/07/2018','2017-10-08 13:38:45',0),(3,2,2,'Nuevo Mensaje','Este es otro mensaje a enviar','2017-10-08 13:47:48',0),(4,1,3,'otro mensaje','ella ella esa','2017-10-08 13:49:05',0),(7,1,3,'wdsdfsdfsdfsdf','sfsdfsdf','2017-10-08 13:50:58',1),(8,2,2,'mensaje nuevo','ksdfhsdksdkjvskdbvjsdvksdkjkjsdkvjsdkjvkjdsksdnkdv','2017-10-09 23:35:34',0),(9,1,3,'sdfsdfsdf','ooooooooooooooooooooooddd','2017-10-10 00:08:17',1),(10,2,2,'mensaje mensaje','este es un mensaje de prueba','2017-10-10 23:44:32',2);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `identity` int(11) NOT NULL,
  `birthplace` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `principal`
--

DROP TABLE IF EXISTS `principal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `principal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `address` varchar(256) NOT NULL,
  `date_of_birth` date NOT NULL,
  `ci` int(16) NOT NULL,
  `photo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `principal`
--

LOCK TABLES `principal` WRITE;
/*!40000 ALTER TABLE `principal` DISABLE KEYS */;
INSERT INTO `principal` VALUES (1,'Roberto Carlos','Villegas Laure','M','Av. Heeroinas #533','2017-03-24',6848,'director_1.jpg');
/*!40000 ALTER TABLE `principal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `lastname` varchar(64) NOT NULL,
  `birthday` date NOT NULL,
  `ci` int(11) NOT NULL,
  `address` varchar(64) NOT NULL,
  `phone` int(11) NOT NULL,
  `cellphone` int(11) NOT NULL,
  `classroom` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Mariela','Vargas','2009-05-22',4554883,'C. Jordan #432',3435353,79483822,'AULA A'),(2,'Mijail','Tordoya','2008-03-29',4857383,'Av. Heroinas #4323',34833211,694839392,'AULA B'),(3,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(4,'Miguelina','Sanchez','2004-02-11',958321,'Av. Heroina #212',9583202,5968483,'AULA A'),(5,'Sonia','Hidalgo','2007-05-10',4214212,'C. Suipacha #211',6483292,354442,'AULA A'),(6,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(7,'Miguelina','Sanchez','2004-02-11',95128321,'Av. Heroina #212',9533202,54343283,'AULA A'),(8,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(9,'Miguelina','Sanchez','2004-02-11',95128321,'Av. Heroina #212',9533202,54343283,'AULA A'),(10,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(11,'Miguelina','Sanchez','2004-02-11',95128321,'Av. Heroina #212',9533202,54343283,'AULA A'),(12,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(13,'Miguelina','Sanchez','2004-02-11',95128321,'Av. Heroina #212',9533202,54343283,'AULA A'),(14,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(15,'Miguelina','Sanchez','2004-02-11',95128321,'Av. Heroina #212',9533202,54343283,'AULA A'),(16,'Patricia','Foronda','2007-03-30',4833992,'C. Tumusla #421',3948392,5068499,'AULA A'),(17,'Miguelina','Sanchez','2004-02-11',95128321,'Av. Heroina #212',9533202,54343283,'AULA A');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `schedules` varchar(512) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,1,'Matematicas','...................',''),(2,1,'Literatura','...................',''),(3,1,'Geologia','...................',''),(4,1,'Geologia','...................','');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_classroom`
--

DROP TABLE IF EXISTS `teacher_classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_classroom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `classroom_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `classroom_id` (`classroom_id`),
  CONSTRAINT `teacher_classroom_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`),
  CONSTRAINT `teacher_classroom_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_classroom`
--

LOCK TABLES `teacher_classroom` WRITE;
/*!40000 ALTER TABLE `teacher_classroom` DISABLE KEYS */;
INSERT INTO `teacher_classroom` VALUES (1,1,1),(2,1,3),(3,2,1),(4,2,2),(5,2,3);
/*!40000 ALTER TABLE `teacher_classroom` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-29 17:30:56
