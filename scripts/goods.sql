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

/*Table structure for table `order_t` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
                       `id` integer(5) COLLATE utf8_unicode_ci NOT NULL AUTO_INCREMENT COMMENT '商品ID',
                       `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '商品名称',
                       `remark` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '描述',
                       `stock` integer(5) collate utf8_unicode_ci NOT NULL default 0 COMMENT '库存',
                       `price` integer(5) collate utf8_unicode_ci NOT NULL default 0 COMMENT '价格',
                       `sales` integer(5) collate utf8_unicode_ci NOT NULL default 0 COMMENT '销量',
                       `praise_rate` integer(3) collate utf8_unicode_ci NOT NULL default 0 COMMENT '好评率',
                       `shop_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '商家ID',
                       `user_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
                       `status` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '商品状态',
                       `images` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '商品状态',
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
