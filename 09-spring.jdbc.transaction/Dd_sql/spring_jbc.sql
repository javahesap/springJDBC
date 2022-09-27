-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 27, 2022 at 07:19 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spring_jbc`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `EMPLOYEE_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `AGE` int(10) NOT NULL,
  `SALARY` int(10) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `personel`
--

DROP TABLE IF EXISTS `personel`;
CREATE TABLE IF NOT EXISTS `personel` (
  `personelId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(25) COLLATE utf8_turkish_ci DEFAULT NULL,
  `lastName` varchar(25) COLLATE utf8_turkish_ci DEFAULT NULL,
  `birtOfDate` date DEFAULT NULL,
  `personelNumber` varchar(12) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`personelId`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `personel`
--

INSERT INTO `personel` (`personelId`, `firstName`, `lastName`, `birtOfDate`, `personelNumber`) VALUES
(1, 'beşir', 'aydemir', '2022-10-12', '123456'),
(2, 'ali', 'yıldız', '2022-10-12', '123456'),
(5, 'hasan', 'y?ld?z', '2002-11-09', '456456'),
(6, 'hasan', 'y?ld?z', '2002-11-09', '456456'),
(7, 'hasan', 'y?ld?z', '2002-11-09', '456456'),
(8, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(9, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(10, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(11, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(12, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(13, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(14, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456'),
(15, 'hasan', 'yÄ±ldÄ±z', '2002-11-09', '456456');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `avaliable` int(11) DEFAULT NULL,
  `addDate` datetime DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `name`, `price`, `avaliable`, `addDate`) VALUES
(8, 'sansung a32', 2345, 6, '2022-09-16 22:49:51'),
(6, 'sansung a32', 2345, 6, '2022-09-15 22:30:44'),
(7, 'sansung a32', 2345, 6, '2022-09-16 22:48:43');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(250) COLLATE utf8_turkish_ci DEFAULT NULL,
  `password` varchar(250) COLLATE utf8_turkish_ci DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `userdetailId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `userdetay` (`userdetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `userName`, `password`, `creationDate`, `userdetailId`) VALUES
(3, 'gııııu', 'huuu', '2022-09-25 09:34:03', 1),
(4, 'be?ir', '123456', '2022-09-27 20:58:00', NULL),
(5, 'besir', '123456', '2022-09-27 21:03:09', 16);

-- --------------------------------------------------------

--
-- Table structure for table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE IF NOT EXISTS `userdetail` (
  `userDetailId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `lastName` varchar(250) COLLATE utf8_turkish_ci NOT NULL,
  `birtOfDate` date NOT NULL,
  PRIMARY KEY (`userDetailId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `userdetail`
--

INSERT INTO `userdetail` (`userDetailId`, `firstName`, `lastName`, `birtOfDate`) VALUES
(1, 'beşir', 'aydemir', '2022-09-07'),
(5, 'besir', '123456', '2022-10-01'),
(6, 'besir', '123456', '2022-10-01'),
(7, 'besir', '123456', '2022-10-01'),
(8, 'besir', '123456', '2022-10-01'),
(9, 'besir', '123456', '2022-10-01'),
(10, 'besir', '123456', '2022-10-01'),
(11, 'besir', '123456', '2022-10-01'),
(13, 'besir', '123456', '2022-10-01'),
(14, 'besir', '123456', '2022-10-01'),
(16, 'besir', '123456', '2022-10-01');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `userdetay` FOREIGN KEY (`userdetailId`) REFERENCES `userdetail` (`userDetailId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
