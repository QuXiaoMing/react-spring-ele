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

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
                        `id` varchar (20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
                        `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '名称',
                        `phone` integer(11) COLLATE utf8_unicode_ci NOT NULL COMMENT '联系电话',
                        `latitude` DOUBLE COLLATE utf8_unicode_ci NOT NULL COMMENT 'latitude',
                        `longitude` DOUBLE COLLATE utf8_unicode_ci NOT NULL COMMENT 'longitude',
                        `category` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '食品分类',
                        `image_path` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '店铺图片地址',
                        `float_delivery_fee` integer(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '运费' DEFAULT 0,
                        `float_minimum_order_amount` integer(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '起送价' DEFAULT 0,
                        `description` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '餐馆介绍',
                        `promotion_info` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '店铺标语',
                        `is_premium` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT '品牌商铺,默认false' DEFAULT FALSE,
                        `delivery_mode` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT '支持蜂鸟专送，默认false DEFAULT FALSE',
                        `is_new` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT '新开店铺，默认false' DEFAULT FALSE,
                        `is_bao` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT '支持保险，默认false' DEFAULT FALSE,
                        `is_zhun` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT '准时达，默认false' DEFAULT FALSE,
                        `is_piao` boolean COLLATE utf8_unicode_ci NOT NULL COMMENT '开发票，默认false' DEFAULT FALSE,
                        `startTime` DATE COLLATE utf8_unicode_ci NOT NULL COMMENT '开始营业时间',
                        `endTime` DATE COLLATE utf8_unicode_ci NOT NULL COMMENT '停止营业时间',
                        `business_license_image` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '营业执照图片地址',
                        `catering_service_license_image` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '餐饮服务许可证图片地址',
                        `activities` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '商铺活动：示例：[{icon_name:''新'', name:''新用户立减'', description: ''''}]',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
