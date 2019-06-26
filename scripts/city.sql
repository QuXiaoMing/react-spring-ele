/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.6.36 : Database - seller
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manager` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `ele`;

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
                        `id` integer (11) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
                        `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
                        `abbr` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'abbr',
                        `key` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'key',
                        `area_code` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'area_code',
                        `sort` integer(11) COLLATE utf8_unicode_ci NOT NULL COMMENT 'sort',
                        `latitude` varchar(11) COLLATE utf8_unicode_ci NOT NULL COMMENT 'latitude',
                        `longitude` varchar(11) COLLATE utf8_unicode_ci NOT NULL COMMENT 'longitude',
                        `is_map` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT 'is_map',
                        `pinyin` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'pinyin',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
