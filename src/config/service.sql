/*
Navicat MySQL Data Transfer

Source Server         : localhost-123456
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : service

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2021-03-24 12:18:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNum` varchar(11) DEFAULT NULL,
  `adminName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `phoneNum` (`phoneNum`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `checkpost`
-- ----------------------------
DROP TABLE IF EXISTS `checkpost`;
CREATE TABLE `checkpost` (
  `postId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `displayInfo` text,
  `hiddenInfo` text,
  `resourceAddr` text,
  `postName` text,
  `time` timestamp NULL DEFAULT NULL,
  `sortId` int(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `source` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkpost
-- ----------------------------

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commId` bigint(20) NOT NULL AUTO_INCREMENT,
  `postID` bigint(20) DEFAULT NULL,
  `comm` text,
  `fkCommId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `sendTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `reportNum` bigint(20) DEFAULT NULL,
  `likeNum` bigint(20) DEFAULT NULL,
  `hateNum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`commId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `commentreport`
-- ----------------------------
DROP TABLE IF EXISTS `commentreport`;
CREATE TABLE `commentreport` (
  `crId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `commId` bigint(20) DEFAULT NULL,
  `reason` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`crId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commentreport
-- ----------------------------

-- ----------------------------
-- Table structure for `commentuser`
-- ----------------------------
DROP TABLE IF EXISTS `commentuser`;
CREATE TABLE `commentuser` (
  `cuId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `commId` bigint(20) DEFAULT NULL,
  `lOrh` int(11) DEFAULT '0',
  PRIMARY KEY (`cuId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commentuser
-- ----------------------------

-- ----------------------------
-- Table structure for `count`
-- ----------------------------
DROP TABLE IF EXISTS `count`;
CREATE TABLE `count` (
  `countId` bigint(20) NOT NULL AUTO_INCREMENT,
  `countNum` bigint(20) DEFAULT NULL,
  `countLoginNum` bigint(20) DEFAULT NULL,
  `countDate` date DEFAULT NULL,
  PRIMARY KEY (`countId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of count
-- ----------------------------

-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `fId` bigint(20) NOT NULL AUTO_INCREMENT,
  `beAttendUserId` bigint(20) DEFAULT NULL,
  `attendUserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`fId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friends
-- ----------------------------

-- ----------------------------
-- Table structure for `likeandhaterecord`
-- ----------------------------
DROP TABLE IF EXISTS `likeandhaterecord`;
CREATE TABLE `likeandhaterecord` (
  `lhId` bigint(20) NOT NULL AUTO_INCREMENT,
  `postId` bigint(20) DEFAULT NULL,
  `usersId` bigint(20) DEFAULT NULL,
  `lOrH` int(11) DEFAULT '0',
  PRIMARY KEY (`lhId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likeandhaterecord
-- ----------------------------

-- ----------------------------
-- Table structure for `notpasspost`
-- ----------------------------
DROP TABLE IF EXISTS `notpasspost`;
CREATE TABLE `notpasspost` (
  `postId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `displayInfo` text,
  `hiddenInfo` text,
  `resourceAddr` text,
  `postName` text,
  `time` timestamp NULL DEFAULT NULL,
  `checkTime` timestamp NULL DEFAULT NULL,
  `adminId` bigint(20) DEFAULT NULL,
  `sortId` int(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `reason` text,
  `source` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notpasspost
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `displayInfo` text,
  `hiddenInfo` text,
  `resourceAddr` text,
  `postName` text,
  `likeNum` bigint(20) DEFAULT NULL,
  `hateNum` bigint(20) DEFAULT NULL,
  `browseNum` bigint(20) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `checkTime` timestamp NULL DEFAULT NULL,
  `adminId` bigint(20) DEFAULT NULL,
  `sortId` int(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `source` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`postId`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `reportId` bigint(20) NOT NULL AUTO_INCREMENT,
  `postId` bigint(20) DEFAULT NULL,
  `usersId` bigint(20) DEFAULT NULL,
  `cause` text,
  `isCheck` int(11) DEFAULT '0',
  `reportTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for `request`
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
  `requestId` bigint(20) NOT NULL AUTO_INCREMENT,
  `usersId` bigint(20) DEFAULT NULL,
  `title` text,
  `descInfo` text,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `accpet` bigint(20) DEFAULT NULL,
  `finish` int(11) DEFAULT NULL,
  PRIMARY KEY (`requestId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of request
-- ----------------------------

-- ----------------------------
-- Table structure for `sign`
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `signId` bigint(20) NOT NULL AUTO_INCREMENT,
  `usersId` bigint(20) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`signId`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------

-- ----------------------------
-- Table structure for `sort`
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `sortId` int(11) NOT NULL AUTO_INCREMENT,
  `sort` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`sortId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phoneNum` varchar(11) DEFAULT NULL,
  `userIcon` varchar(100) DEFAULT NULL,
  `userSex` char(4) DEFAULT '男',
  `regDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mail` varchar(50) DEFAULT NULL,
  `exp` bigint(20) DEFAULT NULL,
  `intro` varchar(300) DEFAULT NULL,
  `freePoint` int(11) DEFAULT NULL,
  `payPoint` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phoneNum` (`phoneNum`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------

-- ----------------------------
-- Table structure for `usersbuy`
-- ----------------------------
DROP TABLE IF EXISTS `usersbuy`;
CREATE TABLE `usersbuy` (
  `usersBuyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `usersId` bigint(20) DEFAULT NULL,
  `postId` bigint(20) DEFAULT NULL,
  `buyTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`usersBuyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usersbuy
-- ----------------------------
