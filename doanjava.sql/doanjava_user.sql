-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (x86_64)
--
-- Host: localhost    Database: doanjava
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `provider` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'vinhtran@gmail.com','vinh','$2a$10$zJTuJcsTyJPc.ryMMP8tRu0IX3xMUrAZXS3rZv95gYwDL17yoQs82','0369997678',NULL,'vinh123'),(2,'kythanh@gmail.com','ky','$2a$10$43p.PnJ6Y3AXwp0xTVNXCeBSP/LbxDkqPpwEjnXf1.XZrkO2OAIpC','0578475884',NULL,'ky'),(3,'vinhtranthe117@gmail.com','vinh','$2a$10$pDUHPgsh91ZCWl9OfdDHru78T2CWECi4L5ux.ZqAG5ggfnTRbq/Tq','0473874738',NULL,'vinh'),(4,'khanhvy@gmail.com','vy','$2a$10$nrvBqv5r.K84hdNLRHGWVe0NSiRfwkNzokoTCgzLyjCDUEK9YPjhW','0848474748',NULL,'vy'),(5,'na@gmail.com','manh','$2a$10$A6QJ9b9K.MzJRzeO3gzFFehInEDiVVQwM8W6SZyIjl4oYsmsB8Y9m','0384737584',NULL,'manh'),(6,'nhat@gmail.com','nhat','$2a$10$eQ3C8CN5pvbCRpxX36RUlehOqSIG6wRKAjbwiA83XlolUOKj34bN.','0483958364',NULL,'nhat'),(7,'a@gmail.com','a','$2a$10$agtKN342L5WfjfghIJu2R.pHUvqRAiwW5BvLoBiCMmpaEON2fjD.u','0473847564',NULL,'a'),(8,'abc@gmail.com','acb','$2a$10$Irt3/j0BCSNs0SRxyKtGQeEsDO45S8JYGbNyM75zPEXsYE6g38EUO','0495847562',NULL,'abc'),(9,'trang@gmail.com','trang','$2a$10$sXkqiRCz0pQtVohyr8wL2uyWFY8wYP228/13zcBNqZN7xPuuF898C','0397877899',NULL,'trang1'),(11,'manngu123@gmail.com','manngu','$2a$10$YDe6hTGJznHQoT4u03HrMe78gNQ5J98bihd0G88THL9QpHROxrhD2','0354448756',NULL,'man');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-17 14:10:18
