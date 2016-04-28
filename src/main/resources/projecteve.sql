/*
Navicat MySQL Data Transfer

Source Server         : v60a82
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : projecteve

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-20 10:37:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` smallint(20) NOT NULL,
  `member_nickname` varchar(255) DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `member_password` varchar(255) DEFAULT NULL,
  `member_qq` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '星际奏者', 'xjzz', '123456', '120964066');

-- ----------------------------
-- Table structure for planet
-- ----------------------------
DROP TABLE IF EXISTS `planet`;
CREATE TABLE `planet` (
  `planet_id` smallint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `planet_user_id` smallint(20) NOT NULL,
  `planet_user_name` varchar(255) NOT NULL,
  `planet_upload_date` date NOT NULL,
  `planet_star_1` bigint(20) unsigned DEFAULT '0',
  `planet_star_2` bigint(20) unsigned DEFAULT '0',
  `planet_star_3` bigint(20) unsigned DEFAULT '0',
  `planet_star_4` bigint(20) unsigned DEFAULT '0',
  `planet_star_5` bigint(20) unsigned DEFAULT '0',
  `planet_star_6` bigint(20) DEFAULT NULL,
  `planet_star_7` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`planet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of planet
-- ----------------------------
INSERT INTO `planet` VALUES ('00000000000000000001', '1', '星际奏者', '2015-08-02', '100', '100', '100', '100', '100', '0', '0');
INSERT INTO `planet` VALUES ('00000000000000000002', '1', '星际奏者', '2015-08-03', '1', '2', '3', '4', '5', '0', '0');
