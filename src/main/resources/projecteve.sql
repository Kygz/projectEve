/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : projecteve

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-08-10 20:28:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for calendar_event
-- ----------------------------
DROP TABLE IF EXISTS `calendar_event`;
CREATE TABLE `calendar_event` (
  `calendar_id` bigint(20) NOT NULL,
  `calendar_create_id` bigint(20) NOT NULL,
  `calendar_create_name` varchar(255) DEFAULT NULL,
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
INSERT INTO `calendar_event` VALUES ('-8129845709251590232', '1', '星际奏者', '888', '888', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('-6529787324893019170', '1', '星际奏者', '123', '456', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('-6103396562780142266', '1', '星际奏者', '会战', '船只类型 aaa\nbbb\nccc', '2017-08-10 00:00:00', '2017-08-10 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('-5260414777408927735', '1', '星际奏者', '444', '444', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('-5045878095671375824', '1', '星际奏者', '7', '7', '2017-07-31 00:00:00', '2017-07-31 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('-4635022369235189633', '1', '星际奏者', '123', '456', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('11111', '1', '星际奏者', '测试预置', '这是过去的数据', '2017-07-01 00:00:00', '2017-07-02 00:00:00', '1', '0');
INSERT INTO `calendar_event` VALUES ('22222', '1', '星际奏者', '测试预置', '正在进行的数据', '2017-07-26 00:00:00', '2017-07-29 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('932637619462554205', '1', '星际奏者', '3', '5', '2017-08-02 00:00:00', '2017-08-02 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('2883885995073814873', '1', '星际奏者', '000', '000', '2017-08-02 00:00:00', '2017-08-02 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('3310912722921867051', '1', '星际奏者', '555', '555', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('5567667390613374141', '1', '星际奏者', '测试参加列表', 'fffffff', '2017-08-09 00:00:00', '2017-08-09 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('5997909351431487622', '1', '星际奏者', '333', '444', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');
INSERT INTO `calendar_event` VALUES ('6020859022254097627', '1', '星际奏者', '123456', '123', '2017-07-29 00:00:00', '2017-07-29 00:00:00', '1', '0');
INSERT INTO `calendar_event` VALUES ('8753330307245689910', '1', '星际奏者', '6', '6', '2017-08-01 00:00:00', '2017-08-01 23:59:59', '1', '0');

-- ----------------------------
-- Table structure for calendar_join
-- ----------------------------
DROP TABLE IF EXISTS `calendar_join`;
CREATE TABLE `calendar_join` (
  `calendar_join_id` bigint(20) NOT NULL,
  `calendar_event_id` bigint(20) NOT NULL,
  `calendar_member_id` bigint(20) NOT NULL,
  `calendar_member_name` varchar(255) NOT NULL,
  PRIMARY KEY (`calendar_join_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of calendar_join
-- ----------------------------
INSERT INTO `calendar_join` VALUES ('-8477484200568010072', '-6103396562780142266', '1', '星际奏者');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of planet
-- ----------------------------
INSERT INTO `planet` VALUES ('00000000000000000001', '1', '星际奏者', '2015-08-02', '100', '100', '100', '100', '100', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_key` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `role_id_list` varchar(8000) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('-8578240082376768048', 'superAdmin', '超级管理员', null);
INSERT INTO `role` VALUES ('-7498411867153544466', 'calendarAdmin', '日程管理员', '1');
INSERT INTO `role` VALUES ('1474601842975391884', 'memberAdmin', '人员管理员', '1');
INSERT INTO `role` VALUES ('2726293526685436521', 'shipAssemblyAdmin', '舰船装配管理员', '1');

-- ----------------------------
-- Table structure for shipassembly_entity
-- ----------------------------
DROP TABLE IF EXISTS `shipassembly_entity`;
CREATE TABLE `shipassembly_entity` (
  `shipAssembly_id` bigint(20) NOT NULL,
  `shipAssembly_creator_id` bigint(20) NOT NULL,
  `shipAssembly_creator_name` varchar(255) DEFAULT NULL,
  `shipAssembly_create_time` datetime DEFAULT NULL,
  `shipAssembly_title` varchar(200) DEFAULT NULL,
  `shipAssembly_img` LONGBLOB DEFAULT NULL,
  `shipAssembly_content` LONGBLOB DEFAULT NULL,
  `shipAssembly_tag` varchar(200) DEFAULT NULL,
  `shipAssembly_scope` int(2) DEFAULT NULL,
  `shipAssembly_use_type` int(2) DEFAULT NULL,
  `shipAssembly_ship_type` int(10) DEFAULT NULL,
  PRIMARY KEY (`shipAssembly_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipassembly_entity
-- ----------------------------

# -- ----------------------------
# -- Table structure for football
# -- ----------------------------
# DROP TABLE IF EXISTS `football`;
# CREATE TABLE `football` (
#   `football_id` bigint(20) NOT NULL,
#   `football_title` varchar(255) DEFAULT NULL,
#   `football_content` varchar(1000) DEFAULT NULL,
#   `football_create` bigint(20) DEFAULT NULL,
#   `football_starttime` datetime DEFAULT NULL,
#   `football_deadline` datetime DEFAULT NULL,
#   `football_options` varchar(2000) NOT NULL,
#   `football_result` int(2) DEFAULT NULL,
#   `football_state` int(1) DEFAULT NULL,
#   PRIMARY KEY (`football_id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
