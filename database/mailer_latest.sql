/*
SQLyog Community Edition- MySQL GUI v7.15 
MySQL - 5.5.8 : Database - mailer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`mailer` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mailer`;

/*Table structure for table `campaigns` */

DROP TABLE IF EXISTS `campaigns`;

CREATE TABLE `campaigns` (
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

/*Data for the table `campaigns` */

insert  into `campaigns`(`id`,`campaignId`,`createdBy`,`campaignName`,`subject`,`body`,`modifiedOn`,`triggeredOn`,`numberOfTargets`) values (1,1576631246,1998627023,'Samsung Partnership','We are now partners with Samsung','<p><span style=\"font-family: verdana,geneva; font-size: small; color: #000080;\">Hi everyone !<br /></span></p>\r\n<p><span style=\"font-family: verdana,geneva; font-size: small; color: #000080;\">This is a great pleasure to inform you that, we are now partners with technology giant and globlal leader <span style=\"color: #993300;\"><a href=\"http://www.samsung.co.in\" target=\"_blank\"><span style=\"color: #993300;\">Samsung Inc</span></a>.</span></span></p>\r\n<p><span style=\"font-family: verdana,geneva; font-size: small; color: #000080;\">Cheers,</span></p>\r\n<p><span style=\"color: #000080;\"><strong><span style=\"font-family: verdana,geneva; font-size: small;\">Team Neev</span></strong></span></p>','2011-09-11 13:13:17',NULL,0),(2,240066769,-153708640,'new','ytffyyrryeryryry','<p>ytryyrtyrytyt</p>','2011-09-11 17:11:13',NULL,0),(5,1135360821,2006304602,'position for software developer','Hello there','<p>Here is an<span style=\"text-decoration: underline;\"> opening</span> for <em>software</em>&nbsp;<img title=\"Cry\" src=\"web/tinyMCE/plugins/emotions/img/smiley-cry.gif\" alt=\"Cry\" border=\"0\" />&nbsp;<strong>developer.....</strong>.<img title=\"Tongue out\" src=\"web/tinyMCE/plugins/emotions/img/smiley-tongue-out.gif\" alt=\"Tongue out\" border=\"0\" /></p>','2011-09-12 18:10:10',NULL,0),(4,-577676314,-757651800,'Neev Tech Talk','Neev Tech Talk','<p>&nbsp;</p>\r\n<p>Emailer</p>\r\n<div style=\"width: 621px; margin: 0px auto; border-top: 1px solid #cdcdcd;\"><!-- Header starts here -->\r\n<div style=\"width: 620px; margin: 0px auto; padding-bottom: 20px; border-left: 1px solid; border-right: 1px solid; border-color: #d4d0c8;\">\r\n<div style=\"height: 25px; width: 430px; float: left; margin-left: -2px; margin-top: 20px;\">\r\n<div style=\"height: 25px; background-color: #29292b; width: 430px; float: left;\">&nbsp;</div>\r\n<div style=\"clear: both; width: 423px; padding-left: 5px; font-size: 9px;\">A newsletter from Neev Technologies, a software services &amp; solutions company<span style=\"padding-left: 33px;\">August 2011</span></div>\r\n</div>\r\n<div style=\"width: 155px; float: left;\"><img style=\"display: block; margin-left: 1px;\" src=\"http://www.neevtech.com/assets/template/Images/newsletter_images/techtalk.png\" alt=\"\" width=\"155\" height=\"61\" /></div>\r\n<div style=\"margin-top: 20px; min-height: 25px; background-color: #29292b; width: 33px; float: left; margin-left: 2px;\">&nbsp;</div>\r\n<div style=\"height: 60px;\">&nbsp;</div>\r\n</div>\r\n<!-- Header end-->\r\n<div style=\"border: 1px solid; border-color: #d4d0c8; border-top: none; width: 620px; margin: 0px auto; padding-bottom: 20px;\"><!-- left section -->\r\n<div style=\"float: left; margin-left: 3px;\">\r\n<div style=\"color: #fff; background-color: #1a2753; padding: 5px 0px 5px 15px; width: 220px;\"><strong>Trend Spotting</strong></div>\r\n<div class=\"bx03bg\" style=\"border-right: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-left: 1px solid #CDCDCD; padding: 5px 15px 15px 15px; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/bx01Bg.gif\') repeat-x scroll center bottom transparent; width: 202px; text-align: justify;\"><strong>Gartner\'s Top 10 strategic technologies</strong><br />Gartner, Inc. highlighted the top 10 technologies and trends that will be strategic for most organizations in 2011. Gartner defines a strategic technology as one with the potential for significant impact on the enterprise in the next three years. Factors that denote significant impact include a high potential for disruption to IT or the business. More...<br /> <a href=\"http://www.gartner.com/it/page.jsp?id=1454221\" target=\"_blank\">http://www.gartner.com/it/page.jsp?id=1454221</a></div>\r\n<div style=\"height: 10px; width: 233px;\">&nbsp;</div>\r\n<div style=\"color: #fff; background-color: #1a2753; padding: 5px 0px 5px 15px;\"><strong>Showcase</strong></div>\r\n<div class=\"bx03bg\" style=\"border-right: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-left: 1px solid #CDCDCD; padding: 5px 15px 15px 15px; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/bx01Bg.gif\') repeat-x scroll center bottom transparent; width: 202px; text-align: justify;\"><strong>Neev\'s Mobile Moves with Google</strong><br />Google was looking to launch a new marketing campaign to encourage users to use Google products like search, gmail, maps etc from their mobile phones. The primary target audience for the mobile campaign was young adults from Tier-II / Tier-III cities who probably didn\'t have a computer but owned a mobile phone. The idea was to communicate that \'mobile moves\' is as easy as a child\'s play. The Solution: www.mobilemoves.in was built with the aim of building a portal of crowd-sourced videos. Users were encouraged to upload videos of how they used the Google products on their mobile devices. Users would \'like\', \'vote\' on the videos and also share them via Twitter and Facebook to help the videos going viral. More...<br /> <a href=\"http://www.neevtech.com/showcase\" target=\"_blank\">http://www.neevtech.com/showcase/</a></div>\r\n<div style=\"height: 10px; width: 233px;\">&nbsp;</div>\r\n<div style=\"color: #fff; background-color: #1a2753; padding: 5px 0px 5px 15px;\"><strong>Happenings</strong></div>\r\n<div class=\"bx03bg\" style=\"border-right: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-left: 1px solid #CDCDCD; padding: 5px 15px 15px 15px; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/bx01Bg.gif\') repeat-x scroll center bottom transparent; width: 202px; text-align: justify;\"><strong>Virtual store in Korea could spark shopping revolution</strong><br />Fancy shopping from a subway station? Well the concept isn\'t too far off the West, after UK supermarket Tesco recently trialed the idea in Seoul, South Korea. \"Koreans are the second most hardworking people in the world,\" which led Home Plus - Tesco and Samsung\'s joint venture - to take the \'store\' to the people. The \'virtual supermarket\' consists of several posters - displaying pictures of everyday products - pasted onto platform walls. With the help of Quick Response codes. More...<br /> <a href=\"http://www.digitaljournal.com/article/309919#ixzz1UhRdn8wQ\" target=\"_blank\">http://www.digitaljournal.com/article/</a></div>\r\n</div>\r\n<!-- left section end -->\r\n<div style=\"margin-left: 240px;\">\r\n<div style=\"background-color: #9fbd37; padding-top: 4px; padding-bottom: 5px; padding-left: 5px; width: 362px; margin-left: 10px;\"><strong style=\"color: #fff;\">Big Data: Next frontier for innovation, competition &amp; productivity </strong></div>\r\n<div style=\"float: left; margin-left: 10px; width: 382px;\">\r\n<div style=\"border-left: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-right: 1px solid #CDCDCD; border-t: 1px solid #CDCDCD; padding: 2px 10px 10px 10px; width: 345px; text-align: justify; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/innerBoxBg.gif\') repeat-x scroll 0 0 transparent; margin-bottom: 10px; position: relative;\">\r\n<p>The amount of data in our world has been exploding and analyzing large data sets-so-called big data-will become a key basis of competition, underpinning new waves of productivity growth, innovation, and consumer surplus, according to research by MGI and McKinsey\'s Business Technology Office. Leaders in every sector will have to grapple with the implications of big data, not just a few data-oriented managers. The increasing volume and detail of information captured by enterprises, the rise of multimedia, social media, and the Internet of Things will fuel exponential growth in data for the foreseeable future.<br /> More...<br /> <a href=\"http://www.mckinsey.com/mgi/publications/big_data/index.asp\" target=\"_blank\">http://www.mckinsey.com/mgi/publications/big_data/index.asp</a></p>\r\n</div>\r\n<div style=\"background-color: #9fbd37; margin-top: 4px; padding-top: 4px; padding-bottom: 5px; padding-left: 5px; color: #fff; width: 362px;\"><strong>Quick response marketing with QR Codes</strong></div>\r\n<div style=\"border-left: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-right: 1px solid #CDCDCD; border-t: 1px solid #CDCDCD; padding: 2px 10px 10px 10px; width: 345px; text-align: justify; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/innerBoxBg.gif\') repeat-x scroll 0 0 transparent; margin-bottom: 10px; position: relative;\">\r\n<p>Quick Response Codes, or QR codes, have become a powerful marketing force, connecting the physical world to the Web. A QR code is a specific two-dimensional code, readable by a dedicated QR bar code reader, camera phone or smartphone. With QR codes, you may invite prospects to find out more about your product or service as they browse through your print material (business cards, direct mail, and special offer leaflets). You can also put discount codes on a product and send users to an online site where they may place an order.<br /> More...<br /><a href=\"http://www.maltabusinessweekly.com.mt/news.asp?newsitemid=11699\" target=\"_blank\">http://www.maltabusinessweekly.com.mt/news.asp?newsitemid=11699</a></p>\r\n</div>\r\n<div style=\"background-color: #9fbd37; margin-top: 4px; padding-top: 4px; padding-bottom: 5px; padding-left: 5px; color: #fff; width: 362px;\"><strong>CAPTCHA prompts searches on Google, Bing</strong></div>\r\n<div style=\"border-left: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-right: 1px solid #CDCDCD; border-t: 1px solid #CDCDCD; padding: 2px 10px 10px 10px; width: 345px; text-align: justify; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/innerBoxBg.gif\') repeat-x scroll 0 0 transparent; margin-bottom: 10px; position: relative;\">\r\n<p>They\'re in our content, they\'re online and offline, they\'re on buses, billboards, and more. Of course, those who are successful in digital advertising are generally those who can find these non-traditional areas to use as advertising space - latest being the Solve Media\'s CAPTCHAs. Consumers are far less likely to struggle with Solve Media\'s CAPTCHAs than they are with those annoying fuzzy puzzle CAPTCHAs. On the other hand, publishers get to employ a security buffer (when needed), and advertisers get guaranteed views and impressions for their brands. More... <br /> <a href=\"http://techcrunch.com/2011/07/26/solve-media-is-captcha-ing-620k-type-in-ads-a-day/\" target=\"_blank\">http://techcrunch.com/2011/07/26/solve-media-is-captcha-ing-620k-type-in-ads-a-day/</a></p>\r\n</div>\r\n<div style=\"background-color: #9fbd37; margin-top: 4px; padding-top: 4px; padding-bottom: 5px; padding-left: 5px; color: #fff; width: 362px;\"><strong>Computing the cost of clouds</strong></div>\r\n<div style=\"border-left: 1px solid #CDCDCD; border-bottom: 1px solid #CDCDCD; border-right: 1px solid #CDCDCD; border-t: 1px solid #CDCDCD; padding: 2px 10px 10px 10px; width: 345px; text-align: justify; background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/innerBoxBg.gif\') repeat-x scroll 0 0 transparent; margin-bottom: 10px; position: relative;\">\r\n<p>Mark Twain once said it was OK to keep all your eggs in one basket &acirc;&euro;&rdquo; as long you kept a close eye on that basket. His 19th-century advice appears particularly apt for a 21st-century technological marvel: cloud computing. This is the means by which companies such as Amazon, Google, IBM and Microsoft now offer data storage and virtual servers their customers can access on demand without having to store masses of information on their own computers. More...<br /> <a href=\"http://www.theage.com.au/national/education/computing-the-cost-of-clouds-20110801-1i7z7.html#ixzz1UhtFkObb\" target=\"_blank\">http://www.theage.com.au/national/education/computing-the-cost-of-clouds-20110801-1i7z7.html#ixzz1UhtFkObb</a></p>\r\n</div>\r\n</div>\r\n</div>\r\n<!-- Footer starts here -->\r\n<div style=\"clear: both; height: 10px;\">&nbsp;</div>\r\n<div class=\"fbg\" style=\"background: url(\'http://www.neevtech.com/assets/template/Images/newsletter_images/footerLine.gif\') repeat-x scroll center top #F4F0EE; line-height: 18px; padding: 10px 5px 0px 5px; text-align: justify; clear: both; border-bottom: 1px solid #d4d0c8; font-size: 9px;\">You are receiving this mail because sometime in the past, our paths have crossed in this dynamic global business village.</div>\r\n<div style=\"height: 15px;\">&nbsp;</div>\r\n<div style=\"height: 25px; background-color: #29292b; width: 35px; float: left; margin-top: 18px;\">&nbsp;</div>\r\n<div style=\"height: 25px; width: 114px; float: left; padding-top: 5px;\"><img style=\"display: block; height: 49px; margin-top: -13px; width: 114px; margin-left: 1px;\" src=\"http://www.neevtech.com/assets/template/Images/newsletter_images/neevlogo.jpg\" alt=\"\" /></div>\r\n<div style=\"height: 25px; background-color: #29292b; float: left; width: 468px; margin-left: 2px; margin-top: 18px;\">&nbsp;</div>\r\n<div style=\"height: 47px;\">&nbsp;</div>\r\n<div style=\"clear: both; padding: 0px 5px 0px 5px; font-size: 9px;\">Neev Information Technologies Pvt. Ltd, The Estate, No. 121, Dickensen Road, Bangalore 560042. <a style=\"color: blue;\" href=\"http://www.neevtech.com\" target=\"_balnk\">www.neevtech.com</a></div>\r\n<!-- Footer end --></div>\r\n</div>','2011-09-12 11:30:43',NULL,0);

/*Table structure for table `contacts` */

DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
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

/*Data for the table `contacts` */

insert  into `contacts`(`id`,`contactId`,`uploadedBy`,`emailAddress`,`firstName`,`lastName`,`gender`) values (13,1099631301,2006304602,'jajnaseni@neevtech.com','jagi','cvnfb','F'),(7,1045906265,-153708640,'tusar@neevtech.com','Tusar','Das','M'),(8,2046541031,1998627023,'reshma@neevtech.com','Reshma','','F'),(12,-1204086445,-757651800,'reshma@neevtech.com','Reshma','B','F'),(10,968479982,-757651800,'tusar.busybird@gmail.com','Tusar','Gmail','M'),(11,585853472,-757651800,'tusar_das@ymail.com','Tusar','Yahoo','M'),(14,-1868849069,2006304602,'tusar@neevtech.com','tusar','das','M'),(15,-740946162,2006304602,'milanoec9@gmail.com','milan','das','F'),(16,1498452789,2006304602,'sunita.sonu29@gmail.com','suni','pana','F');

/*Table structure for table `sender_profile` */

DROP TABLE IF EXISTS `sender_profile`;

CREATE TABLE `sender_profile` (
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

/*Data for the table `sender_profile` */

insert  into `sender_profile`(`id`,`senderId`,`host`,`username`,`password`,`port`,`protocol`,`preferredName`) values (1,1998627023,'smtp.mail.yahoo.com','tusar_das@ymail.com','dGl0YW5AMjAxMQ==','465','smtp','Tusar Yahoo'),(2,-438772850,'mail.google.com','usar.busybird@gmail.com','password','465','smtp','Tusar'),(3,-757651800,'smtp.gmail.com','tusar@neevtech.com','ZG9jdG9ydXI=','465','smtp','Tusar Neev'),(4,2006304602,'smtp.gmail.com','sanghamittra@neevtech.com','anVtYm9vb28=','465','smtp','kunmun');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(25) NOT NULL,
  `userCategory` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`,`userId`,`email`),
  UNIQUE KEY `userId` (`userId`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`userId`,`userCategory`,`email`,`password`) values (1,0,'o','admin@mailer.org','-41-11-1098527-2536-54-88-6037-81-5-942818'),(4,-757651800,'a','tusar@neevtech.com','-41-11-1098527-2536-54-88-6037-81-5-942818'),(2,1998627023,'a','tusar_das@ymail.com','-41-11-1098527-2536-54-88-6037-81-5-942818');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
