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

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名称',
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `sex` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户性别，0：男、1：女',
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户类型,ADMIN:管理员,NORMAL:普通用户',
  `order_status` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
