-- MySQL dump 10.13  Distrib 5.6.16, for Win32 (x86)
--
-- Host: localhost    Database: Instituto
-- ------------------------------------------------------
-- Server version	5.6.16

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (2,1,'Otra actividad','Descripcion de la actividad que es nueva.','2017-01-01','02:20:00'),(4,1,'acrtividad','descripcion','2017-01-01','03:20:00'),(5,3,'Actividad','descripcion	','2017-01-01','04:35:00'),(6,1,'activiad','descripcion','2017-01-01','03:35:00'),(8,2,'aldnasd','sdfsdf','2017-01-01','02:10:00'),(9,1,'ACTIVIDAD','DESCRIPC','2017-01-19','09:40:00'),(10,3,'Act','descripcion','2017-10-05','03:20:00'),(11,2,'Actividad de Ejemplo','Este es una actividAD DE EJEMPLO','2018-05-13','02:30:00');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignation`
--

DROP TABLE IF EXISTS `assignation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) unsigned NOT NULL,
  `subject_id` int(11) unsigned NOT NULL,
  `gestion` varchar(2) NOT NULL,
  `anio` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignation`
--

LOCK TABLES `assignation` WRITE;
/*!40000 ALTER TABLE `assignation` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type_personal` varchar(64) NOT NULL,
  `personal_id` int(11) unsigned NOT NULL,
  `attendance_status` varchar(64) NOT NULL,
  `date_enter` date NOT NULL,
  `time_enter` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'teacher',1,'Asistido','2018-06-15','02:38:50'),(2,'teacher',1,'Asistido','2018-06-15','02:39:05'),(3,'teacher',2,'Asistido','2018-06-28','01:33:40'),(4,'teacher',2,'Asistido','2018-06-28','01:33:44'),(5,'teacher',1,'Asistido','2018-06-28','01:33:55'),(6,'principal',1,'Asistido','2018-06-28','02:21:09');
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
  `subject_id` int(11) NOT NULL,
  `shift` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'AULA A',50,2,'Tarde'),(2,'AULA B',70,1,'Tarde'),(3,'AULA C',100,4,'Tarde');
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
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
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
  `code` int(11) unsigned NOT NULL,
  `photo` varchar(128) DEFAULT NULL,
  `username` varchar(128) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `principal`
--

LOCK TABLES `principal` WRITE;
/*!40000 ALTER TABLE `principal` DISABLE KEYS */;
INSERT INTO `principal` VALUES (1,'Roberto Carlos','Villegas Laure','M','C. Tumusla #433','2014-05-07',2222,235,'Villegas Laure Roberto Carlos 2222.jpg','aaa','bbb');
/*!40000 ALTER TABLE `principal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_teacher`
--

DROP TABLE IF EXISTS `schedule_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_teacher` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) unsigned NOT NULL,
  `time_enter` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_teacher`
--

LOCK TABLES `schedule_teacher` WRITE;
/*!40000 ALTER TABLE `schedule_teacher` DISABLE KEYS */;
INSERT INTO `schedule_teacher` VALUES (1,1,'00:10:00'),(2,1,'02:20:00'),(3,1,'05:15:00'),(4,1,'02:05:00'),(5,1,'01:30:00'),(6,1,'01:05:00'),(7,1,'03:10:00');
/*!40000 ALTER TABLE `schedule_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `classroom_id` int(11) unsigned NOT NULL,
  `student_id` int(11) unsigned DEFAULT NULL,
  `seat_name` varchar(8) NOT NULL,
  `state` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretary`
--

DROP TABLE IF EXISTS `secretary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `ci` int(11) unsigned NOT NULL,
  `sex` varchar(2) NOT NULL,
  `address` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `code` int(11) unsigned NOT NULL,
  `place_birth` varchar(25) NOT NULL,
  `photo` longtext,
  `username` varchar(128) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretary`
--

LOCK TABLES `secretary` WRITE;
/*!40000 ALTER TABLE `secretary` DISABLE KEYS */;
INSERT INTO `secretary` VALUES (1,'Maria Alejandra','Sanchez Torrico',795943,'F','Av. De los Andes #3421','2012-03-10',0,'Cochabamba Bolivia','','marale','Bol123');
/*!40000 ALTER TABLE `secretary` ENABLE KEYS */;
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
  `code` int(11) unsigned NOT NULL,
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
INSERT INTO `student` VALUES (1,'Mariela','Vargas','2009-05-22',4554883,0,'C. Jordan #432',3435353,79483822,'AULA A'),(2,'Mijail','Tordoya','2008-03-29',4857383,0,'Av. Heroinas #4323',34833211,694839392,'AULA B'),(3,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(4,'Miguelina','Sanchez','2004-02-11',958321,0,'Av. Heroina #212',9583202,5968483,'AULA A'),(5,'Sonia','Hidalgo','2007-05-10',4214212,0,'C. Suipacha #211',6483292,354442,'AULA A'),(6,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(7,'Miguelina','Sanchez','2004-02-11',95128321,0,'Av. Heroina #212',9533202,54343283,'AULA A'),(8,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(9,'Miguelina','Sanchez','2004-02-11',95128321,0,'Av. Heroina #212',9533202,54343283,'AULA A'),(10,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(11,'Miguelina','Sanchez','2004-02-11',95128321,0,'Av. Heroina #212',9533202,54343283,'AULA A'),(12,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(13,'Miguelina','Sanchez','2004-02-11',95128321,0,'Av. Heroina #212',9533202,54343283,'AULA A'),(14,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(15,'Miguelina','Sanchez','2004-02-11',95128321,0,'Av. Heroina #212',9533202,54343283,'AULA A'),(16,'Patricia','Foronda','2007-03-30',4833992,0,'C. Tumusla #421',3948392,5068499,'AULA A'),(17,'Miguelina','Sanchez','2004-02-11',95128321,0,'Av. Heroina #212',9533202,54343283,'AULA A');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `schedules` varchar(512) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'materia de prueba','ljglgjldglejgetgegerg','07:20,14:00,21:10'),(2,'Fisica','','07:15,null,null'),(3,'test','sdfsdf','null,null'),(4,'Psicologia','dfsdfdsfsdfdsfsdf nujnca paso','10:00,15:15'),(5,'xxx','fdefe','10:--,21:10'),(6,'sgsrgsrg','dddddddddddddddddddddddddddddddddddddddddddd','14:05,21:10'),(7,'vfvfvf','rafafafasfasfasfasfasf','07:15,20:25'),(8,'Prueba de Materia sabado','este es una nueva prueba con mhashmaps','14:05,21:30,08:10'),(9,'Esta es una prueba','xxxxxxxxxxx','--,21:05,09:10'),(10,'sdfsdf','sdfsdfdsf','15:10,--,07:15');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(60) NOT NULL,
  `ci` varchar(32) NOT NULL,
  `birthday` date NOT NULL,
  `code` int(11) unsigned NOT NULL,
  `place_birth` varchar(25) NOT NULL,
  `photo` longtext,
  `username` varchar(128) NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (2,'Jose','Figueroa','C. Tumusla #433','759833','2005-05-12',333,'Sucre','photo2.jpg','yyy','222');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_classroom`
--

DROP TABLE IF EXISTS `teacher_classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_classroom` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `classroom_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `classroom_id` (`classroom_id`),
  CONSTRAINT `teacher_classroom_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `teacher_classroom_ibfk_2` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_classroom`
--

LOCK TABLES `teacher_classroom` WRITE;
/*!40000 ALTER TABLE `teacher_classroom` DISABLE KEYS */;
INSERT INTO `teacher_classroom` VALUES (3,2,1),(4,2,2),(5,2,3);
/*!40000 ALTER TABLE `teacher_classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subject`
--

DROP TABLE IF EXISTS `teacher_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_subject` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) unsigned NOT NULL,
  `subject_id` int(11) unsigned NOT NULL,
  `year` int(5) NOT NULL,
  `gestion` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subject`
--

LOCK TABLES `teacher_subject` WRITE;
/*!40000 ALTER TABLE `teacher_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-03 23:38:27
