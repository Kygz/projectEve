/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : projecteve

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-07-28 18:16:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for calendar_event
-- ----------------------------
DROP TABLE IF EXISTS `calendar_event`;
CREATE TABLE `calendar_event` (
  `calendar_id` bigint(20) NOT NULL,
  `calendar_create_id` bigint(20) NOT NULL,
  `calendar_title` varchar(2000) DEFAULT NULL,
  `calendar_content` varchar(2000) DEFAULT NULL,
  `calendar_startTime` datetime DEFAULT NULL,
  `calendar_endTime` datetime DEFAULT NULL,
  `calendar_allDay` int(1) DEFAULT NULL,
  `calendar_state` int(2) DEFAULT NULL,
  PRIMARY KEY (`calendar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of calendar_event
-- ----------------------------
INSERT INTO `calendar_event` VALUES ('11111', '1', '测试预置', '这是过去的数据', '2017-07-01 00:00:00', null, '1', '0');
INSERT INTO `calendar_event` VALUES ('22222', '1', '测试预置', '正在进行的数据', '2017-07-26 00:00:00', '2017-07-29 23:59:59', '1', '0');

-- ----------------------------
-- Table structure for mail
-- ----------------------------
DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `mail_id` bigint(20) NOT NULL,
  `mail_user_id` bigint(20) NOT NULL,
  `mail_user_name` varchar(255) NOT NULL,
  `mail_address` varchar(255) NOT NULL,
  `mail_content` varchar(2000) DEFAULT NULL,
  `mail_createDate` datetime DEFAULT NULL,
  `mail_time` datetime DEFAULT NULL,
  `mail_done` int(2) DEFAULT NULL,
  PRIMARY KEY (`mail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail
-- ----------------------------
INSERT INTO `mail` VALUES ('-5387683711696484965', '1', '星际奏者', 'gavin110991@163.com', '技能将要到期，请及时续一秒！', '2017-07-25 18:35:14', '2017-07-25 18:36:05', '-2');
INSERT INTO `mail` VALUES ('-1216926129766445463', '1', '星际奏者', 'gavin110991@163.com', '技能将要到期，请及时续一秒！', '2017-07-25 21:01:12', '2017-07-25 21:02:06', '1');
INSERT INTO `mail` VALUES ('2862845660245020463', '1', '星际奏者', 'gavin110991@163.com', '技能将要到期，请及时续一秒！', '2017-07-25 20:25:29', '2017-07-25 20:59:24', '1');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` bigint(20) NOT NULL,
  `member_nickname` varchar(255) DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `member_password` varchar(255) DEFAULT NULL,
  `member_qq` varchar(255) DEFAULT NULL,
  `member_email` varchar(255) DEFAULT NULL,
  `member_skin` varchar(255) DEFAULT 'skin-blur-violate',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '星际奏者', 'xjzz', '123456', '120964066', 'gavin110991@163.com', 'skin-blur-chrome');

-- ----------------------------
-- Table structure for planet
-- ----------------------------
DROP TABLE IF EXISTS `planet`;
CREATE TABLE `planet` (
  `planet_id` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `planet_user_id` bigint(20) NOT NULL,
  `planet_user_name` varchar(255) NOT NULL,
  `planet_upload_date` date NOT NULL,
  `planet_star_1` bigint(20) unsigned DEFAULT '0',
  `planet_star_2` bigint(20) unsigned DEFAULT '0',
  `planet_star_3` bigint(20) unsigned DEFAULT '0',
  `planet_star_4` bigint(20) unsigned DEFAULT '0',
  `planet_star_5` bigint(20) unsigned DEFAULT '0',
  `planet_star_6` bigint(20) unsigned DEFAULT '0',
  `planet_star_7` bigint(20) unsigned DEFAULT '0',
  `planet_star_1_price` bigint(20) unsigned DEFAULT '0',
  `planet_star_2_price` bigint(20) unsigned DEFAULT '0',
  `planet_star_3_price` bigint(20) unsigned DEFAULT '0',
  `planet_star_4_price` bigint(20) unsigned DEFAULT '0',
  `planet_star_5_price` bigint(20) unsigned DEFAULT '0',
  `planet_star_6_price` bigint(20) unsigned DEFAULT '0',
  `planet_star_7_price` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`planet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of planet
-- ----------------------------
INSERT INTO `planet` VALUES ('00000000000000000001', '1', '星际奏者', '2015-08-02', '100', '100', '100', '100', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0');
