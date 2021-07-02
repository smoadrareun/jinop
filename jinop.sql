/*
 Navicat Premium Data Transfer

 Source Server         : Jinop
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : jinop

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 02/07/2021 20:49:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cliinfo
-- ----------------------------
DROP TABLE IF EXISTS `cliinfo`;
CREATE TABLE `cliinfo`  (
  `id` int(0) NOT NULL,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT 0.00,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  `addinfo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paypass` int(0) NULL DEFAULT NULL,
  `level` tinyint(1) NULL DEFAULT 0,
  `longi` decimal(20, 6) NULL DEFAULT NULL,
  `lati` decimal(20, 6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cliinfo
-- ----------------------------

-- ----------------------------
-- Table structure for cominfo
-- ----------------------------
DROP TABLE IF EXISTS `cominfo`;
CREATE TABLE `cominfo`  (
  `id` int(0) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT 0.00,
  `num` int(0) NULL DEFAULT NULL,
  `sales` int(0) NULL DEFAULT 0,
  `info` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `kind` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'def',
  `spec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cominfo
-- ----------------------------

-- ----------------------------
-- Table structure for merinfo
-- ----------------------------
DROP TABLE IF EXISTS `merinfo`;
CREATE TABLE `merinfo`  (
  `id` int(0) NOT NULL,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  `addinfo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of merinfo
-- ----------------------------

-- ----------------------------
-- Table structure for retinfo
-- ----------------------------
DROP TABLE IF EXISTS `retinfo`;
CREATE TABLE `retinfo`  (
  `id` int(0) NOT NULL,
  `money` decimal(10, 2) NULL DEFAULT 0.00,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  `addinfo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `disc` decimal(3, 1) NULL DEFAULT 10.0,
  `dist` decimal(5, 2) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `longi` decimal(20, 6) NULL DEFAULT NULL,
  `lati` decimal(20, 6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of retinfo
-- ----------------------------

-- ----------------------------
-- Table structure for traninfo
-- ----------------------------
DROP TABLE IF EXISTS `traninfo`;
CREATE TABLE `traninfo`  (
  `id` varchar(17) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cliid` int(0) NULL DEFAULT NULL,
  `retid` int(0) NULL DEFAULT NULL,
  `cliname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `retname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` decimal(10, 2) NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of traninfo
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
