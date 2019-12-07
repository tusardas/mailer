-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.22-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table mailer.campaigns
CREATE TABLE IF NOT EXISTS `campaigns` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `campaignId` int(25) NOT NULL,
  `createdBy` int(25) NOT NULL,
  `campaignName` varchar(255) NOT NULL,
  `subject` varchar(500) DEFAULT NULL,
  `body` varchar(50000) DEFAULT NULL,
  `modifiedOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `triggeredOn` date DEFAULT NULL,
  `numberOfTargets` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`campaignId`),
  UNIQUE KEY `campaignId` (`campaignId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table mailer.campaigns: 1 rows
/*!40000 ALTER TABLE `campaigns` DISABLE KEYS */;
INSERT INTO `campaigns` (`id`, `campaignId`, `createdBy`, `campaignName`, `subject`, `body`, `modifiedOn`, `triggeredOn`, `numberOfTargets`) VALUES
	(1, -843454446, -2009841557, 'New Email Campaign', 'New Email Campaign', '<p><span style="font-family: \'courier new\', courier;">Hello,</span></p>\r\n<p><span style="font-family: \'courier new\', courier;">I am very very delighted to send you this New Email Campaign. This is a test email. Please do not mark as spam.</span></p>\r\n<p><span style="font-family: \'courier new\', courier;">Sincerely,</span></p>\r\n<p><span style="font-family: \'courier new\', courier;">Mailer Application</span></p>', '2019-12-07 14:05:51', NULL, 0);
/*!40000 ALTER TABLE `campaigns` ENABLE KEYS */;

-- Dumping structure for table mailer.contacts
CREATE TABLE IF NOT EXISTS `contacts` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `contactId` int(25) NOT NULL,
  `uploadedBy` int(25) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`contactId`),
  UNIQUE KEY `contactId` (`contactId`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Dumping data for table mailer.contacts: 1 rows
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` (`id`, `contactId`, `uploadedBy`, `emailAddress`, `firstName`, `lastName`, `gender`) VALUES
	(1, -1772007457, -2009841557, 'tusar.mailer@gmail.com', 'Tusar', 'Das', 'M');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;

-- Dumping structure for table mailer.sender_profile
CREATE TABLE IF NOT EXISTS `sender_profile` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `senderId` int(25) NOT NULL,
  `host` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `port` varchar(10) NOT NULL,
  `protocol` varchar(10) NOT NULL,
  `preferredName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`senderId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table mailer.sender_profile: 1 rows
/*!40000 ALTER TABLE `sender_profile` DISABLE KEYS */;
INSERT INTO `sender_profile` (`id`, `senderId`, `host`, `username`, `password`, `port`, `protocol`, `preferredName`) VALUES
	(1, -2009841557, 'smtp.gmail.com', 'tusar.mailer@gmail.com', 'Password', '465', 'smtp', 'Mailer');
/*!40000 ALTER TABLE `sender_profile` ENABLE KEYS */;

-- Dumping structure for table mailer.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(25) NOT NULL,
  `userCategory` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`,`userId`,`email`),
  UNIQUE KEY `userId` (`userId`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table mailer.users: 2 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `userId`, `userCategory`, `email`, `password`) VALUES
	(1, 0, 'o', 'admin@mailer.org', '-41-11-1098527-2536-54-88-6037-81-5-942818'),
	(2, -2009841557, 'a', 'tusar.mailer@gmail.com', '-41-11-1098527-2536-54-88-6037-81-5-942818');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
