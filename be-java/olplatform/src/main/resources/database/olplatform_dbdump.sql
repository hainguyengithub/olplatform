-- MySQL dump 10.13  Distrib 8.0.26, for macos10.15 (x86_64)
--
-- Host: localhost    Database: olplatform
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `academic_advisor`
--

DROP TABLE IF EXISTS `academic_advisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_advisor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_advisor`
--

LOCK TABLES `academic_advisor` WRITE;
/*!40000 ALTER TABLE `academic_advisor` DISABLE KEYS */;
INSERT INTO `academic_advisor` VALUES (1,'fwallis@fanshawec.ca','Faith','Wallis','abc','519-452-4430 x4915','fwallis'),(2,'asutherland@fanshawec.ca','Ashleigh','Sutherland','abc','519-452-4430 x2031','asutherland'),(3,'bantone-collar@fanshawec.ca','Bev','Antone-Collar','abc','519-452-4176','bantone-collar');
/*!40000 ALTER TABLE `academic_advisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint DEFAULT NULL,
  `instructor_id` bigint DEFAULT NULL,
  `program_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK478bp6bk6381i6r1nqfp0kbgs` (`course_id`),
  KEY `FK75fccqx1nuyosidbi8wc041qo` (`instructor_id`),
  KEY `FKe6jdnhi8ivv6ylwko5x5pyy08` (`program_id`),
  CONSTRAINT `FK478bp6bk6381i6r1nqfp0kbgs` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FK75fccqx1nuyosidbi8wc041qo` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`),
  CONSTRAINT `FKe6jdnhi8ivv6ylwko5x5pyy08` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,1,1,2),(2,2,3,3),(3,3,2,1);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(12) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'BSCI-6031','This course will introduce students to substance-related and behavioural addictions as indicated in the Diagnostic and Statistical Manual. Through the biopsychosocial and trauma informed lens, students will critically analyze different theories of addiction and current initiatives in field addiction services. The signs and symptoms of dependence, abuse, problematic, and occasional patterns of substance use will be addressed. Throughout the course, students will engage in self- reflection regarding their understanding of addictions with the aim to challenge one\'s own beliefs and assumptions.','2022-01-11 00:00:00.000000','Fundamentals of Addictions','2021-09-07 00:00:00.000000'),(2,'TELE-1025','In this course students will learn to process calls for Police, Fire and EMS, recording incident details and reports while applying effective interview and interrogation techniques as well as triage and call categorization protocols. Confirmation of locations through computer-integrated and paper mapping while maintaining a client-centered approach with a diverse caller base for both emergent and non-emergent situations will be emphasized. Students will have hands on experience with current public safety communications technologies, including Hexagon Intergraph® Computer-Aided Dispatch. At the end of this course, students will be prepared for the level two labs (TELE3014, TELE3015, TELE3016).','2023-01-11 00:00:00.000000','Call Processing & Procedure-Intro','2022-09-07 00:00:00.000000'),(3,'INFO-1215','An introduction to relational database system design and development, by creating a variety of simple databases, based upon typical business requirements. Students build complete database solutions incorporating multi-table relational databases, forms, reports, queries, and test data. Students will also be introduced to the Structured Query Language.','2022-01-11 00:00:00.000000','Database Fundamentals','2021-09-07 00:00:00.000000');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `salary` bigint NOT NULL,
  `sin` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'elauersen@fanshaweonline.ca','Evan','Lauersen','abc','418-555-0107',89500,'542 519 103','elauersen'),(2,'s_sharpe6133@fanshaweonline.ca','Steve','Sharpe','abc','902-555-0171',67900,'754 386 423','s_sharpe6133'),(3,'o_ali@fanshaweonline.ca ','Osam','Ali','abc','709-555-0135',100400,'526 415 476','o_ali');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `attachment` longblob,
  `attachment_enabled` bit(1) DEFAULT NULL,
  `attachment_name` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `classroom_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnp631daenjebgasqob4qoyp6w` (`classroom_id`),
  CONSTRAINT `FKnp631daenjebgasqob4qoyp6w` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `academic_advisor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhf2cf9r01d3e4n4owdg5mj3ed` (`academic_advisor_id`),
  CONSTRAINT `FKhf2cf9r01d3e4n4owdg5mj3ed` FOREIGN KEY (`academic_advisor_id`) REFERENCES `academic_advisor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'There is no career more valued, in-demand or dynamic these days than an IT career. If you have a passion for coding and computers, and you’re ready to develop the skills to land your dream job as a computer programmer, Fanshawe’s Computer Programming and Analysis advanced diploma is the right fit for you.','2022-01-11 00:00:00.000000','Computer Programmer Analyst 2','2021-09-07 00:00:00.000000',1),(2,'The Addictions and Mental Health one-year program will be beneficial for seasoned practitioners who are committed to maintaining currency, and/or who are seeking career advancement.','2022-01-11 00:00:00.000000','Addictions and Mental Health','2021-09-07 00:00:00.000000',2),(3,'This hands-on and comprehensive program provides students with the foundational knowledge and specialized communication skills required to work in the highly demanding and unpredictable field of public safety communications.','2023-01-11 00:00:00.000000','911 and Public Safety Communications','2022-09-07 00:00:00.000000',3);
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `classroom_id` bigint DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8pamxltkteu8pqnncfqte0slp` (`classroom_id`),
  KEY `FK6vjk5f55i8n5h5qkwabt0xnmc` (`student_id`),
  CONSTRAINT `FK6vjk5f55i8n5h5qkwabt0xnmc` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK8pamxltkteu8pqnncfqte0slp` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,3,1),(2,2,3),(3,1,2);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'h_nguyen89212@fanshaweonline.ca','Hai','Nguyen','abc','226-503-8196','h_nguyen89212'),(2,'g_moussa@fanshaweonline.ca','George','Moussa','abc','867-988-1037','g_moussa'),(3,'e_somers@fanshaweonline.ca','Evan','Somers','abc','403-302-3211','e_somers');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `grade` float DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `submission_date` datetime(6) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `seat_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKstdua5yau2w2neyi3ocqrhr9t` (`seat_id`),
  CONSTRAINT `FKstdua5yau2w2neyi3ocqrhr9t` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-21  7:40:06
