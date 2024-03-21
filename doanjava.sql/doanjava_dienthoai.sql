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
-- Table structure for table `dienthoai`
--

DROP TABLE IF EXISTS `dienthoai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dienthoai` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gia_ban` double DEFAULT NULL,
  `gia_nhap` double DEFAULT NULL,
  `hinh` varchar(200) NOT NULL,
  `home` bit(1) NOT NULL,
  `mo_ta` varchar(500) NOT NULL,
  `noi_bat` bit(1) NOT NULL,
  `sl_ton` int DEFAULT NULL,
  `ten_dien_thoai` varchar(50) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `ma_loai` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1ugist5i345qshaa3rv77uo7` (`ma_loai`),
  CONSTRAINT `FKp1ugist5i345qshaa3rv77uo7` FOREIGN KEY (`ma_loai`) REFERENCES `loaidienthoai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dienthoai`
--

LOCK TABLES `dienthoai` WRITE;
/*!40000 ALTER TABLE `dienthoai` DISABLE KEYS */;
INSERT INTO `dienthoai` VALUES (1,35000000,30000000,'/images/ip-14pm.jpg',_binary '','Thiết kế và chất liệu: Khung viền thép không gỉ và mặt lưng kính. - Kích thước, trọng lượng: 160 x 77.6 x 7.85 mm, trọng lượng 240 gam.  - Màn hình: OLED 6.7 inch, công nghệ màn hình Super Retina XDR. Độ phân giải 2796 x 1290 Pixels, tần số quét 120Hz.  - Camera: Trước 12 MP. Sau 48 MP, 12 MP, 12 MP.\', 1, 76',_binary '',47,'Iphone 14 pro max',_binary '',1),(2,12000000,10000000,'/images/Iph-X.jpg',_binary '','Kích thước màn hình 5.5 inches Camera sau 12 MP (f/1.8, 28mm, OIS) + 12 MP (f/2.8, 57mm), tự động lấy nét nhận diện theo giai đoạn, zoom quang 2x, 4 LED flash (2 tone) Camera trước 7 MP, f/2.2, 1080p@30fps, 720p@240fps, nhận diện khuôn mặt, HDR, panorama Chipset Apple A11 Bionic APL1W72 Dung lượng RAM 3 GB Bộ nhớ trong 64 GB Pin Li-ion 2691mAh Thẻ SIM Nano-SIM Hệ điều hành 11 Độ phân giải màn hình 1080 x 1920 pixels (FullHD) Trọng lượng 202 g (7.13 oz)',_binary '\0',82,'Iphone X',_binary '',1),(3,6990000,3990000,'/images/iph-8.jpg',_binary '','Kích thước màn hình 5.5 inches\nCamera sau 12 MP (f/1.8, 28mm, OIS) + 12 MP (f/2.8, 57mm), tự động lấy nét nhận diện theo giai đoạn, zoom quang 2x, 4 LED flash (2 tone)\nCamera trước 7 MP, f/2.2, 1080p@30fps, 720p@240fps, nhận diện khuôn mặt, HDR, panorama\nChipset Apple A11 Bionic APL1W72\nDung lượng RAM 3 GB\nBộ nhớ trong 64 GB\nPin Li-ion 2691mAh\nThẻ SIM Nano-SIM\nHệ điều hành 11\nĐộ phân giải màn hình 1080 x 1920 pixels (FullHD)\nTrọng lượng 202 g (7.13 oz)',_binary '\0',56,'Iphone 8',_binary '',1),(4,21990000,11990000,'/images/ip-14.jpg',_binary '','Màn hình:OLED6.1\"Super Retina XDRHệ điều hành: IOS 16Camera sau: 2 camera 12 MPCamera trước: 12 MPChip: Apple A15 BionicRAM: 6 GBDung lượng lưu trữ: 128 GBSIM: 1 Nano SIM & 1 eSIM hỗ trợ 5GPin, Sạc: 3279mAh 20W',_binary '',56,'Iphone 14',_binary '',1),(5,19990000,14000000,'/images/sszflip4.jpg',_binary '','Chip: Snapdragon 8+ Gen 1.\nRAM: 8 GB.\nBộ nhớ trong: 256 GB, 512 GB.\nHệ điều hành: Android 12.\nPin: 3.700 mAh (2 viên pin), sạc nhanh 25 W.\nCamera sau: 12 MP + 12 MP\nCamera selfie: 10 MP.',_binary '',98,'Samsung Galaxy Z Flip4',_binary '',2),(6,12000000,8000000,'/images/ss-galaxy-S21FE.jpg',_binary '','Màn hình: Dynamic AMOLED 2X6.4, Full HD+\nHệ điều hành: Android 12\nCamera sau: Chính 12 MP & Phụ 12 MP, 8 MP\nCamera trước: 32 MP\nChip: Exynos 21005\nRAM: 6 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM, Hỗ trợ 5G\nPin, Sạc: 4500mAh 25W',_binary '\0',72,'Samsung Galaxy S21 FE 5G',_binary '',2),(7,17990000,26990000,'/images/sss23.jpg',_binary '','Màn hình OLED kích thước 6.8 inch (3.088 × 1.440 pixel) hỗ trợ HDR10+, tần số quét 1-120 Hz và độ sáng 1.750 nits, máy có tùy chọn bộ nhớ RAM 8 GB hoặc 12 GB tương ứng với ba phiên bản bộ nhớ trong: 256 GB, 512 GB và 1 TB',_binary '',142,'Samsung S23 Ultra',_binary '',2),(8,29990000,23000000,'/images/xi-13-Pro.jpg',_binary '\0','Màn hình: AMOLED 6.73 Quad HD+ (2K+)\nHệ điều hành: Android 13\nCamera sau: Chính 50 MP & Phụ 50 MP, 50 MP\nCamera trước: 32 MP\nChip: Snapdragon 8 Gen 2 8 nhân\nRAM: 12 GB\nDung lượng lưu trữ: 256 GB\nSIM: 2 Nano SIM, Hỗ trợ 5G\nPin, Sạc: 4820mAh 120W',_binary '\0',39,'Xiaomi 13 Pro',_binary '',3),(9,7890000,6000000,'/images/xi-redmi-note11.jpg',_binary '\0','Màn hình: AMOLED 6.67, Full HD+\nHệ điều hành: Android 11\nCamera sau: Chính 108 MP & Phụ 8 MP, 2 MP\nCamera trước: 16 MP\nChip: Snapdragon 695 5G\nRAM: 8 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM (SIM 2 chung khe thẻ nhớ), Hỗ trợ 5G\nPin, Sạc: 5000mAh 67W',_binary '\0',54,'Xiaomi Redmi Note 11 Pro 5G',_binary '',3),(10,2890000,2890000,'/images/xiaomi-11t-1.jpg',_binary '\0','\nMàn hình: AMOLED6.67 Full HD+\nHệ điều hành: Android 11\nCamera sau: Chính 108 MP & Phụ 8 MP, 5 MP\nCamera trước: 16 MP\nChip: MediaTek Dimensity 1200\nRAM: 8 GB\nDung lượng lưu trữ: 256 GB\nSIM: 2 Nano SIMHỗ trợ 5G\nPin, Sạc: 5000mAh 67 W',_binary '\0',42,'Xiaomi 11T 5G',_binary '',3),(11,8490000,3490000,'/images/realme-9-pro-plus-1-1.jpg',_binary '\0','Màn hình: Super AMOLED6.4 Full HD+\nHệ điều hành: Android 12\nCamera sau: Chính 50 MP & Phụ 8 MP, 2 MP\nCamera trước: 16 MP\nChip: MediaTek Dimensity 920 5G\nRAM: 8 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIMHỗ trợ 5G\nPin, Sạc: 4500 mAh60 W',_binary '\0',124,'Realme 9 Pro+ 5G',_binary '',4),(12,6870000,5000000,'/images/rm10.jpg',_binary '\0','Màn hình: Super AMOLED 6.4 Full HD+\nHệ điều hành: Android 12\nCamera sau: Chính 50 MP & Phụ 2 MP\nCamera trước: 16 MP\nChip: MediaTek Helio G99\nRAM: 8 GB\nDung lượng lưu trữ: 256 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 5000mAh 33W',_binary '\0',83,'Realme 10',_binary '',4),(13,5790000,2790000,'/images/rm-8-pro.jpg',_binary '\0','Màn hình: Super AMOLED 6.4, Full HD+\nHệ điều hành: Android 11\nCamera sau: Chính 108 MP & Phụ 8 MP, 2 MP, 2 MP\nCamera trước: 16 MP\nChip: Snapdragon 720G\nRAM: 8 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 4500mAh 50W',_binary '\0',73,'Realme 8 Pro',_binary '',4),(14,13990000,10000000,'/images/op-reno6-pro.jpg',_binary '\0','Màn hình: AMOLED 6.55, Full HD+\nHệ điều hành: Android 11\nCamera sau: Chính 50 MP & Phụ 16 MP, 13 MP, 2 MP\nCamera trước: 32 MP\nChip: Snapdragon 870 5G\nRAM: 12 GB\nDung lượng lưu trữ: 256 GB\nSIM: 2 Nano SIM, Hỗ trợ 5G\nPin, Sạc: 4500mAh 65W',_binary '\0',75,'OPPO Reno6 Pro 5G',_binary '',5),(15,17990000,10890000,'/images/oppo-reno-8-5g.jpg',_binary '\0','Màn hình: AMOLED, 6.7, Full HD+\nHệ Điều Hành:	Android 12\nCamera Sau:	Chính 50 MP & Phụ 8 MP, 2 MP\nCamera Trước:	32 MP\nCPU:	MediaTek Dimensity 8100 Max 8 nhân\nRam:	12 GB\nBộ nhớ trong:	256 GB\nThẻ Sim:	2 Nano SIM, Hỗ trợ 5G\nDung lượng pin: 4500mAh, 80W',_binary '\0',68,'Oppo Reno8 Pro 5G',_binary '',5),(16,6990000,5600000,'/images/op-A96.jpg',_binary '\0','Màn hình: IPS LCD 6.59, Full HD+\nHệ điều hành: Android 11\nCamera sau: Chính 50 MP & Phụ 2 MP\nCamera trước: 16 MP\nChip: Snapdragon 680\nRAM: 8 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 5000mAh 33W',_binary '\0',87,'OPPO A96',_binary '',5),(17,3400000,2500000,'/images/vv-Y02s.jpg',_binary '\0','Màn hình: IPS LCD 6.51 HD+\nHệ điều hành: Android 12\nCamera sau: 8 MP\nCamera trước: 5 MP\nChip: MediaTek Helio P35\nRAM: 3 GB\nDung lượng lưu trữ: 32 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 5000mAh 10W',_binary '\0',38,'Vivo Y02s',_binary '',6),(18,4400000,3000000,'/images/vv-Y16.jpg',_binary '\0','Màn hình: IPS LCD 6.51 HD+\nHệ điều hành: Android 12\nCamera sau: Chính 13 MP & Phụ 2 MP\nCamera trước: 5 MP\nChip: MediaTek Helio P35\nRAM: 4 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 5000mAh 10W',_binary '\0',42,'Vivo Y16',_binary '',6),(19,7490000,6000000,'/images/vv-V25E.jpg',_binary '\0','Màn hình: AMOLED 6.44, Full HD+\nHệ điều hành: Android 12\nCamera sau: Chính 64 MP & Phụ 2 MP, 2 MP\nCamera trước: 32 MP\nChip: MediaTek Helio G99\nRAM: 8 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 4500mAh 44W',_binary '\0',120,'Vivo V25E',_binary '',6),(20,6990000,5090000,'/images/vv-y35.jpg',_binary '\0','Màn hình: IPS LCD 6.58, Full HD+\nHệ điều hành: Android 12\nCamera sau: Chính 50 MP & Phụ 2 MP, 2 MP\nCamera trước: 16 MP\nChip: Snapdragon 680\nRAM: 8 GB\nDung lượng lưu trữ: 128 GB\nSIM: 2 Nano SIM, Hỗ trợ 4G\nPin, Sạc: 5000mAh 44W',_binary '\0',65,'Vivo Y35',_binary '',6);
/*!40000 ALTER TABLE `dienthoai` ENABLE KEYS */;
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
