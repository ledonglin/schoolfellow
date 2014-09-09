/*
SQLyog v10.2 
MySQL - 5.5.39 : Database - flyingbiz
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flyingbiz` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `flyingbiz`;

/*Table structure for table `file_info` */

CREATE TABLE `file_info` (
  `FILE_ID` varchar(36) NOT NULL,
  `FILE_NAME` varchar(255) DEFAULT NULL,
  `SECURITY_TYPE` varchar(64) DEFAULT NULL,
  `MEDIA_TYPE` varchar(64) DEFAULT NULL,
  `NOTICE_TYPE` varchar(64) DEFAULT NULL,
  `FILE_TYPE` varchar(64) DEFAULT NULL,
  `ISSUED_DEPARTMENT` varchar(255) DEFAULT NULL,
  `AMOUNT_TYPE` varchar(32) DEFAULT NULL,
  `HOLD_TYPE` varchar(64) DEFAULT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL,
  `UPLOAD_DATE` datetime DEFAULT NULL,
  `LAST_MODIFIED` datetime DEFAULT NULL,
  `UPLOAD_USER_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `login_log` */

CREATE TABLE `login_log` (
  `LOG_ID` varchar(36) NOT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `IP` varchar(32) DEFAULT NULL,
  `LOGIN_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `role` */

CREATE TABLE `role` (
  `ROLE_ID` varchar(36) NOT NULL,
  `ROLE_NAME` varchar(50) DEFAULT NULL,
  `ROLE_PATH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

CREATE TABLE `user` (
  `USER_ID` varchar(36) NOT NULL,
  `USERNAME` varchar(64) DEFAULT NULL,
  `LOGINNAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT 'SALT',
  `EMAIL` varchar(50) DEFAULT NULL,
  `ROLE` varchar(36) DEFAULT NULL,
  `MOBILEPHONE` varchar(11) DEFAULT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  `SEX` varchar(1) DEFAULT '0',
  `TITLE` varchar(100) DEFAULT NULL,
  `LASTMODIFIED` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
