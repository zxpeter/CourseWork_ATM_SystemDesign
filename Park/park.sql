/*
Navicat MySQL Data Transfer

Source Server         : uml
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-05-27 23:37:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CustomerID` varchar(18) NOT NULL,
  `CustomerName` varchar(20) NOT NULL,
  `Sex` char(1) NOT NULL,
  `Telphone` varchar(11) NOT NULL,
  `DepositCash` decimal(10,2) NOT NULL,
  `ArrivalTime` datetime NOT NULL,
  `Days` int(2) unsigned NOT NULL,
  `SpaceID` varchar(10) NOT NULL,
  PRIMARY KEY (`CustomerID`),
  KEY `ToRoom` (`SpaceID`),
  CONSTRAINT `ToRoom` FOREIGN KEY (`SpaceID`) REFERENCES `space` (`SpaceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('111111111111111110', '赵旭', 'M', '11111111111', '200.00', '2015-05-22 13:00:16', '1', 'BS102');
INSERT INTO `customer` VALUES ('111111111111111111', '赵旭', 'M', '18369180786', '200.00', '2015-05-25 08:52:11', '1', 'BD201');
INSERT INTO `customer` VALUES ('111111111111111112', '21', 'M', '11221111111', '5.00', '2015-05-26 00:42:49', '1', 'BS103');
INSERT INTO `customer` VALUES ('111112222222222222', '111我问', 'M', '12111221111', '5.00', '2015-05-26 13:43:28', '1', 'BS101');
INSERT INTO `customer` VALUES ('111221122222111211', '山昌', 'M', '18412341234', '5.00', '2015-05-27 22:29:48', '1', 'BS105');
INSERT INTO `customer` VALUES ('111222222222111122', '112', 'M', '11111122111', '5.00', '2015-05-26 13:45:31', '1', 'BS107');
INSERT INTO `customer` VALUES ('112211111111121111', '1111', 'M', '22222211111', '5.00', '2015-05-27 22:35:55', '1', 'BS104');
INSERT INTO `customer` VALUES ('112211111222222222', '1112', 'M', '11221111122', '5.00', '2015-05-26 23:10:56', '1', 'BS104');
INSERT INTO `customer` VALUES ('112222221111112221', '112吖吖', 'M', '11122222222', '5.00', '2015-05-26 20:59:53', '1', 'BS106');
INSERT INTO `customer` VALUES ('121122221111221111', 'Peter', 'M', '22111222211', '5.00', '2015-05-26 00:05:07', '1', 'BS103');
INSERT INTO `customer` VALUES ('122222222222222222', '是是是', 'M', '12112222111', '200.00', '2015-05-25 10:00:58', '1', 'BD210');
INSERT INTO `customer` VALUES ('122223222222222222', '111', 'M', '11111221111', '5.00', '2015-05-25 17:38:01', '1', 'BS105');
INSERT INTO `customer` VALUES ('221111221111111211', '2', 'M', '12221112221', '5.00', '2015-05-25 17:31:42', '1', 'BS103');
INSERT INTO `customer` VALUES ('222111111111111111', '21', 'M', '12111122111', '5.00', '2015-05-26 12:41:00', '1', 'BS103');
INSERT INTO `customer` VALUES ('222222111111112211', '11', 'M', '21111111111', '5.00', '2015-05-26 12:56:36', '1', 'BS104');
INSERT INTO `customer` VALUES ('222222222222222222', '22', 'M', '22222222222', '5.00', '2015-05-25 19:14:07', '1', 'BS106');
INSERT INTO `customer` VALUES ('222223333321112321', '11', 'M', '11112211121', '5.00', '2015-05-25 21:29:20', '1', 'BS105');
INSERT INTO `customer` VALUES ('222223333333333333', '1', 'M', '11223332222', '200.00', '2015-05-25 16:21:17', '1', 'BS102');
INSERT INTO `customer` VALUES ('370502199505010816', '赵旭', 'M', '18463111234', '5.00', '2015-05-26 23:37:29', '1', 'BS105');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('zx', '1');

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `DateTime` datetime NOT NULL,
  `RName` varchar(20) NOT NULL,
  `RTel` varchar(11) NOT NULL,
  `SpaceType` varchar(20) NOT NULL,
  `SpaceID` varchar(10) NOT NULL,
  `ArrivalTime` date NOT NULL,
  `Days` int(2) unsigned NOT NULL,
  PRIMARY KEY (`DateTime`),
  KEY `RToRoom` (`SpaceID`),
  CONSTRAINT `RToRoom` FOREIGN KEY (`SpaceID`) REFERENCES `space` (`SpaceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('2015-05-26 01:19:54', '122', '12121111111', '贵宾停车位', 'BS108', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-26 01:21:32', '112', '11222222222', '贵宾停车位', 'BS101', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-26 12:55:46', '111', '22211111111', '贵宾停车位', 'BS102', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-26 13:44:46', '11', '11112222222', '贵宾停车位', 'BS101', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-26 13:45:39', '111', '11221111111', '贵宾停车位', 'BS106', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-26 20:58:43', '我问', '11111122222', '贵宾停车位', 'BS104', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-26 23:34:58', '12345', '12345678909', '贵宾停车位', 'BS105', '2015-05-26', '1');
INSERT INTO `reservation` VALUES ('2015-05-27 22:25:15', '1122', '18409876565', '贵宾停车位', 'BS105', '2015-05-27', '1');

-- ----------------------------
-- Table structure for space
-- ----------------------------
DROP TABLE IF EXISTS `space`;
CREATE TABLE `space` (
  `SpaceID` varchar(10) NOT NULL,
  `SpaceState` varchar(10) NOT NULL,
  `SpaceType` varchar(20) NOT NULL,
  `SpacePrice` int(2) unsigned NOT NULL,
  `SpaceTel` varchar(11) NOT NULL,
  PRIMARY KEY (`SpaceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of space
-- ----------------------------
INSERT INTO `space` VALUES ('BD201', '可用', '标准停车位', '2', '20001');
INSERT INTO `space` VALUES ('BD202', '可用', '标准停车位', '2', '20002');
INSERT INTO `space` VALUES ('BD203', '可用', '标准停车位', '2', '20003');
INSERT INTO `space` VALUES ('BD204', '可用', '标准停车位', '2', '20004');
INSERT INTO `space` VALUES ('BD205', '可用', '标准停车位', '2', '20005');
INSERT INTO `space` VALUES ('BD206', '可用', '标准停车位', '2', '20006');
INSERT INTO `space` VALUES ('BD207', '可用', '标准停车位', '2', '20007');
INSERT INTO `space` VALUES ('BD208', '可用', '标准停车位', '2', '20008');
INSERT INTO `space` VALUES ('BD209', '可用', '标准停车位', '2', '20009');
INSERT INTO `space` VALUES ('BD210', '可用', '标准停车位', '2', '20010');
INSERT INTO `space` VALUES ('BS101', '已预约', '贵宾停车位', '1', '10001');
INSERT INTO `space` VALUES ('BS102', '已预约', '贵宾停车位', '1', '10002');
INSERT INTO `space` VALUES ('BS103', '可用', '贵宾停车位', '1', '10003');
INSERT INTO `space` VALUES ('BS104', '已占用', '贵宾停车位', '1', '10004');
INSERT INTO `space` VALUES ('BS105', '可用', '贵宾停车位', '1', '10005');
INSERT INTO `space` VALUES ('BS106', '可用', '贵宾停车位', '1', '10006');
INSERT INTO `space` VALUES ('BS107', '可用', '贵宾停车位', '1', '10007');
INSERT INTO `space` VALUES ('BS108', '可用', '贵宾停车位', '1', '10008');
INSERT INTO `space` VALUES ('BS109', '可用', '贵宾停车位', '1', '10009');
INSERT INTO `space` VALUES ('BS110', '可用', '贵宾停车位', '1', '10010');
