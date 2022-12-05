/*
 Navicat Premium Data Transfer

 Source Server         : book
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : buybook

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 30/11/2022 15:17:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `AdminID` int NOT NULL,
  `AdminName` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AdminPWD` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AdminPhone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`AdminID`) USING BTREE,
  UNIQUE INDEX `AdminName`(`AdminName`) USING BTREE,
  UNIQUE INDEX `AdminPhone`(`AdminPhone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '万叶', '1234510', '18384712601');
INSERT INTO `admin` VALUES (2, '一斗', '1234590', '18384712602');
INSERT INTO `admin` VALUES (3, '立本', '1234590', '18384712603');
INSERT INTO `admin` VALUES (4, '盖亚', '1234590', '18384712604');
INSERT INTO `admin` VALUES (5, '夜阑', '1234550', '18384712605');
INSERT INTO `admin` VALUES (6, '钟离', '1234560', '18384712606');
INSERT INTO `admin` VALUES (7, '甘雨', '1234570', '18384712607');
INSERT INTO `admin` VALUES (8, '刻晴', '1234580', '18384712608');
INSERT INTO `admin` VALUES (9, '凯亚', '1234590', '18384712609');
INSERT INTO `admin` VALUES (10, '班尼特', '1234511', '18384712610');
INSERT INTO `admin` VALUES (11, '迪迦', '1234512', '18384712611');

-- ----------------------------
-- Table structure for book_car_relation
-- ----------------------------
DROP TABLE IF EXISTS `book_car_relation`;
CREATE TABLE `book_car_relation`  (
  `Book_CarID` int NOT NULL AUTO_INCREMENT,
  `BookID` int NOT NULL,
  `CarID` int NOT NULL,
  `BookNumber` int NOT NULL,
  PRIMARY KEY (`Book_CarID`) USING BTREE,
  INDEX `fk_BookID4`(`BookID`) USING BTREE,
  INDEX `fk_CarID`(`CarID`) USING BTREE,
  CONSTRAINT `fk_BookID4` FOREIGN KEY (`BookID`) REFERENCES `bookinfo` (`BookID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_CarID` FOREIGN KEY (`CarID`) REFERENCES `carinfo` (`CarID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_car_relation
-- ----------------------------
INSERT INTO `book_car_relation` VALUES (1, 2, 1, 34);
INSERT INTO `book_car_relation` VALUES (2, 3, 2, 5);
INSERT INTO `book_car_relation` VALUES (3, 5, 6, 8);
INSERT INTO `book_car_relation` VALUES (4, 2, 6, 6);
INSERT INTO `book_car_relation` VALUES (5, 1, 10, 90);
INSERT INTO `book_car_relation` VALUES (6, 7, 9, 1);
INSERT INTO `book_car_relation` VALUES (7, 7, 7, 8);
INSERT INTO `book_car_relation` VALUES (8, 11, 10, 9);
INSERT INTO `book_car_relation` VALUES (9, 4, 2, 5);
INSERT INTO `book_car_relation` VALUES (10, 2, 6, 89);
INSERT INTO `book_car_relation` VALUES (11, 3, 6, 56);
INSERT INTO `book_car_relation` VALUES (12, 2, 10, 45);
INSERT INTO `book_car_relation` VALUES (13, 5, 7, 7);
INSERT INTO `book_car_relation` VALUES (14, 8, 3, 4);
INSERT INTO `book_car_relation` VALUES (15, 8, 4, 4);
INSERT INTO `book_car_relation` VALUES (16, 2, 9, 78);
INSERT INTO `book_car_relation` VALUES (17, 3, 10, 67);
INSERT INTO `book_car_relation` VALUES (18, 9, 4, 15);
INSERT INTO `book_car_relation` VALUES (19, 6, 2, 12);
INSERT INTO `book_car_relation` VALUES (20, 9, 3, 10);
INSERT INTO `book_car_relation` VALUES (21, 3, 2, 1);
INSERT INTO `book_car_relation` VALUES (22, 4, 2, 1);
INSERT INTO `book_car_relation` VALUES (23, 3, 1, 1);
INSERT INTO `book_car_relation` VALUES (24, 1, 1, 1);
INSERT INTO `book_car_relation` VALUES (25, 9, 1, 1);
INSERT INTO `book_car_relation` VALUES (26, 9, 1, 1);
INSERT INTO `book_car_relation` VALUES (27, 3, 2, 1);
INSERT INTO `book_car_relation` VALUES (28, 3, 2, 1);
INSERT INTO `book_car_relation` VALUES (30, 6, 1, 1);
INSERT INTO `book_car_relation` VALUES (31, 1, 3, 1);
INSERT INTO `book_car_relation` VALUES (32, 6, 27, 1);
INSERT INTO `book_car_relation` VALUES (33, 15, 1, 1);
INSERT INTO `book_car_relation` VALUES (34, 2, 28, 1);
INSERT INTO `book_car_relation` VALUES (35, 1, 1, 1);
INSERT INTO `book_car_relation` VALUES (36, 1, 1, 1);

-- ----------------------------
-- Table structure for book_type_relation
-- ----------------------------
DROP TABLE IF EXISTS `book_type_relation`;
CREATE TABLE `book_type_relation`  (
  `Book_TypeID` int NOT NULL AUTO_INCREMENT,
  `BookID` int NOT NULL,
  `TypeID` int NOT NULL,
  PRIMARY KEY (`Book_TypeID`) USING BTREE,
  INDEX `fk_BookID2`(`BookID`) USING BTREE,
  INDEX `fk_TypeID`(`TypeID`) USING BTREE,
  CONSTRAINT `fk_BookID2` FOREIGN KEY (`BookID`) REFERENCES `bookinfo` (`BookID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_TypeID` FOREIGN KEY (`TypeID`) REFERENCES `booktype` (`TypeID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type_relation
-- ----------------------------
INSERT INTO `book_type_relation` VALUES (1, 2, 3);
INSERT INTO `book_type_relation` VALUES (2, 4, 1);
INSERT INTO `book_type_relation` VALUES (3, 1, 2);
INSERT INTO `book_type_relation` VALUES (4, 1, 1);
INSERT INTO `book_type_relation` VALUES (5, 2, 1);
INSERT INTO `book_type_relation` VALUES (6, 5, 1);
INSERT INTO `book_type_relation` VALUES (7, 8, 9);
INSERT INTO `book_type_relation` VALUES (8, 5, 4);
INSERT INTO `book_type_relation` VALUES (9, 3, 6);
INSERT INTO `book_type_relation` VALUES (10, 9, 2);
INSERT INTO `book_type_relation` VALUES (11, 9, 4);
INSERT INTO `book_type_relation` VALUES (12, 11, 2);
INSERT INTO `book_type_relation` VALUES (13, 7, 4);
INSERT INTO `book_type_relation` VALUES (14, 6, 9);
INSERT INTO `book_type_relation` VALUES (15, 10, 11);
INSERT INTO `book_type_relation` VALUES (16, 7, 2);
INSERT INTO `book_type_relation` VALUES (17, 8, 2);
INSERT INTO `book_type_relation` VALUES (18, 9, 3);
INSERT INTO `book_type_relation` VALUES (19, 7, 2);
INSERT INTO `book_type_relation` VALUES (20, 6, 1);
INSERT INTO `book_type_relation` VALUES (21, 10, 3);
INSERT INTO `book_type_relation` VALUES (22, 15, 9);
INSERT INTO `book_type_relation` VALUES (23, 2, 12);
INSERT INTO `book_type_relation` VALUES (24, 1, 5);
INSERT INTO `book_type_relation` VALUES (25, 9, 8);
INSERT INTO `book_type_relation` VALUES (26, 7, 10);
INSERT INTO `book_type_relation` VALUES (27, 1, 14);
INSERT INTO `book_type_relation` VALUES (28, 9, 6);
INSERT INTO `book_type_relation` VALUES (29, 1, 12);

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo`  (
  `BookID` int NOT NULL AUTO_INCREMENT,
  `BookName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BookPrice` float NULL DEFAULT 1,
  `Img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `BookMS` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `AdminID` int NOT NULL,
  `BookNumber` int NULL DEFAULT 0,
  PRIMARY KEY (`BookID`) USING BTREE,
  INDEX `FK_AdminID`(`AdminID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES (1, '白夜行000', 12, '1.jpg', '可以', 1, 5);
INSERT INTO `bookinfo` VALUES (2, '活着', 10, '2.jpg', '不错', 4, 8);
INSERT INTO `bookinfo` VALUES (3, '兄弟', 34, '3.jpg', '一般', 6, 65);
INSERT INTO `bookinfo` VALUES (4, '红楼梦', 78, '4.jpg', '非常好', 6, 55);
INSERT INTO `bookinfo` VALUES (5, '史记', 78, '5.jpg', '还行', 8, 55);
INSERT INTO `bookinfo` VALUES (6, '操作系统', 45, '6.jpg', '一般', 3, 774);
INSERT INTO `bookinfo` VALUES (7, '诗经', 45, '7.jpg', '不错', 2, 888);
INSERT INTO `bookinfo` VALUES (8, '经济学基础', 23, '8.jpg', '还行', 5, 123);
INSERT INTO `bookinfo` VALUES (9, '人与自然', 33, '9.jpg', '好看', 2, 119);
INSERT INTO `bookinfo` VALUES (10, '计算机基础', 22, '10.jpg', '不好看', 10, 121);
INSERT INTO `bookinfo` VALUES (11, '管理的奥秘', 67, '11.jpg', '看不懂', 11, 664);
INSERT INTO `bookinfo` VALUES (15, '摆烂', 12, NULL, NULL, 1, 44);
INSERT INTO `bookinfo` VALUES (16, 'iiii', 34, NULL, NULL, 1, 12);
INSERT INTO `bookinfo` VALUES (17, '676', 67, NULL, NULL, 1, 9);

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype`  (
  `TypeID` int NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`TypeID`) USING BTREE,
  UNIQUE INDEX `TypeName`(`TypeName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES (15, '456456456');
INSERT INTO `booktype` VALUES (14, '人文学科');
INSERT INTO `booktype` VALUES (2, '历史iii');
INSERT INTO `booktype` VALUES (12, '教育');
INSERT INTO `booktype` VALUES (1, '文学');
INSERT INTO `booktype` VALUES (3, '武侠');
INSERT INTO `booktype` VALUES (5, '玄幻');
INSERT INTO `booktype` VALUES (6, '科幻');
INSERT INTO `booktype` VALUES (11, '科技');
INSERT INTO `booktype` VALUES (8, '管理');
INSERT INTO `booktype` VALUES (7, '经济');
INSERT INTO `booktype` VALUES (9, '美术');
INSERT INTO `booktype` VALUES (10, '自然');
INSERT INTO `booktype` VALUES (4, '计算机');

-- ----------------------------
-- Table structure for carinfo
-- ----------------------------
DROP TABLE IF EXISTS `carinfo`;
CREATE TABLE `carinfo`  (
  `CarID` int NOT NULL AUTO_INCREMENT,
  `UserAccount` int NOT NULL,
  PRIMARY KEY (`CarID`) USING BTREE,
  INDEX `fk_UserAccount1`(`UserAccount`) USING BTREE,
  CONSTRAINT `fk_UserAccount1` FOREIGN KEY (`UserAccount`) REFERENCES `userinfo` (`UserAccount`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carinfo
-- ----------------------------
INSERT INTO `carinfo` VALUES (1, 1);
INSERT INTO `carinfo` VALUES (2, 2);
INSERT INTO `carinfo` VALUES (3, 3);
INSERT INTO `carinfo` VALUES (4, 4);
INSERT INTO `carinfo` VALUES (5, 5);
INSERT INTO `carinfo` VALUES (6, 6);
INSERT INTO `carinfo` VALUES (7, 7);
INSERT INTO `carinfo` VALUES (8, 8);
INSERT INTO `carinfo` VALUES (9, 9);
INSERT INTO `carinfo` VALUES (10, 10);
INSERT INTO `carinfo` VALUES (11, 11);
INSERT INTO `carinfo` VALUES (12, 12);
INSERT INTO `carinfo` VALUES (28, 222);
INSERT INTO `carinfo` VALUES (27, 1111);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `CommID` int NOT NULL AUTO_INCREMENT,
  `CommContent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CommTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `BookID` int NULL DEFAULT NULL,
  `UserAccount` int NULL DEFAULT NULL,
  `FatherCommID` int NULL DEFAULT NULL,
  PRIMARY KEY (`CommID`) USING BTREE,
  INDEX `FatherCommID`(`FatherCommID`) USING BTREE,
  INDEX `CommID`(`CommID`, `FatherCommID`) USING BTREE,
  INDEX `fk_useraccount`(`UserAccount`) USING BTREE,
  INDEX `fk_bookid`(`BookID`) USING BTREE,
  CONSTRAINT `fk_bookid` FOREIGN KEY (`BookID`) REFERENCES `bookinfo` (`BookID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_fatherid` FOREIGN KEY (`FatherCommID`) REFERENCES `comment` (`CommID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_useraccount` FOREIGN KEY (`UserAccount`) REFERENCES `userinfo` (`UserAccount`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '简直是YYDS', '2022-05-17 13:52:11', 1, 4, NULL);
INSERT INTO `comment` VALUES (2, '同意楼上说法', '2022-05-17 13:58:04', 2, 2, NULL);
INSERT INTO `comment` VALUES (4, '感觉一般', '2022-05-17 14:01:03', 4, 7, NULL);
INSERT INTO `comment` VALUES (5, '哪里一般了，明明这么棒的', '2022-05-17 14:02:56', 5, 10, NULL);
INSERT INTO `comment` VALUES (6, '不错', '2022-05-17 14:05:05', 1, 11, NULL);
INSERT INTO `comment` VALUES (8, '同意', '2022-05-17 14:08:20', 8, 5, NULL);
INSERT INTO `comment` VALUES (9, '有点看不懂', '2022-05-17 14:09:36', 9, 6, NULL);
INSERT INTO `comment` VALUES (10, '后悔买了', '2022-05-17 14:10:13', 7, 8, NULL);
INSERT INTO `comment` VALUES (11, '宝藏书籍', '2022-05-17 14:10:57', 5, 4, NULL);
INSERT INTO `comment` VALUES (12, '真心推荐', '2022-05-17 14:11:52', 3, 6, NULL);
INSERT INTO `comment` VALUES (13, '我好喜欢', '2022-05-17 14:12:49', 6, 9, NULL);
INSERT INTO `comment` VALUES (14, '每个字都认识，连在一起就不行了', '2022-05-17 14:13:57', 10, 1, 4);
INSERT INTO `comment` VALUES (15, '离大谱', '2022-05-17 14:15:33', 5, 3, 1);
INSERT INTO `comment` VALUES (16, '加一', '2022-05-17 14:16:10', 1, 9, NULL);
INSERT INTO `comment` VALUES (17, '我也是', '2022-05-17 14:17:23', 4, 8, 1);
INSERT INTO `comment` VALUES (30, '没看懂', '2022-05-26 16:31:05', 2, 7, NULL);
INSERT INTO `comment` VALUES (31, '看懂一点', '2022-05-26 16:36:54', 3, 6, NULL);
INSERT INTO `comment` VALUES (33, '同意', '2022-06-17 16:52:03', 8, 1, 8);
INSERT INTO `comment` VALUES (38, 'yyyyy', '2022-06-17 22:06:46', 1, 1, 6);
INSERT INTO `comment` VALUES (40, 'yyyyy', '2022-06-19 13:41:00', 9, 1, 9);
INSERT INTO `comment` VALUES (43, '123', '2022-06-21 18:57:00', 6, 1, 13);
INSERT INTO `comment` VALUES (45, 'sdadad', '2022-06-21 21:03:04', 1, 3, 38);
INSERT INTO `comment` VALUES (46, '123', '2022-06-22 21:08:52', 6, 1111, 43);
INSERT INTO `comment` VALUES (47, 'pppp', '2022-06-22 21:08:57', 6, 1111, NULL);
INSERT INTO `comment` VALUES (48, 'uuuu', '2022-06-22 21:09:38', 6, 1111, NULL);
INSERT INTO `comment` VALUES (49, 'ttttt', '2022-06-22 21:19:20', 15, 1, NULL);
INSERT INTO `comment` VALUES (51, '', '2022-06-23 09:17:04', 2, 222, NULL);
INSERT INTO `comment` VALUES (52, '123', '2022-06-23 09:17:23', 2, 222, NULL);
INSERT INTO `comment` VALUES (53, '123', '2022-06-23 09:17:24', 2, 222, NULL);
INSERT INTO `comment` VALUES (54, '123', '2022-06-23 09:17:27', 2, 222, NULL);
INSERT INTO `comment` VALUES (55, '123', '2022-06-23 09:17:54', 2, 222, NULL);

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `BookID` int NOT NULL,
  `UserAccount` int NOT NULL,
  `Price` float NOT NULL,
  `Creat_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`OrderID`) USING BTREE,
  INDEX `fk_BookID3`(`BookID`) USING BTREE,
  INDEX `fk_UserAccount2`(`UserAccount`) USING BTREE,
  CONSTRAINT `fk_BookID3` FOREIGN KEY (`BookID`) REFERENCES `bookinfo` (`BookID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_UserAccount2` FOREIGN KEY (`UserAccount`) REFERENCES `userinfo` (`UserAccount`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES (4, 3, 2, 9, '2022-05-17 18:27:22');
INSERT INTO `orderinfo` VALUES (5, 1, 7, 54, '2022-05-17 18:27:42');
INSERT INTO `orderinfo` VALUES (6, 2, 3, 11, '2022-05-17 18:27:59');
INSERT INTO `orderinfo` VALUES (7, 11, 9, 90, '2022-05-17 18:28:12');
INSERT INTO `orderinfo` VALUES (8, 4, 1, 56, '2022-05-17 18:28:32');
INSERT INTO `orderinfo` VALUES (9, 2, 6, 11, '2022-05-17 18:28:43');
INSERT INTO `orderinfo` VALUES (10, 5, 7, 44, '2022-05-17 18:28:55');
INSERT INTO `orderinfo` VALUES (11, 7, 4, 67, '2022-05-17 18:29:05');
INSERT INTO `orderinfo` VALUES (12, 2, 3, 32, '2022-05-17 18:29:27');
INSERT INTO `orderinfo` VALUES (13, 6, 5, 32, '2022-05-17 18:29:37');
INSERT INTO `orderinfo` VALUES (14, 1, 5, 33, '2022-05-17 18:29:52');
INSERT INTO `orderinfo` VALUES (15, 4, 11, 222, '2022-05-17 18:30:03');
INSERT INTO `orderinfo` VALUES (16, 2, 7, 121, '2022-05-18 21:52:41');
INSERT INTO `orderinfo` VALUES (17, 7, 3, 78, '2022-05-18 21:52:52');
INSERT INTO `orderinfo` VALUES (18, 8, 3, 45, '2022-05-18 21:53:07');
INSERT INTO `orderinfo` VALUES (19, 3, 6, 83, '2022-05-18 21:53:25');
INSERT INTO `orderinfo` VALUES (20, 4, 1, 12, '2022-05-18 21:53:38');
INSERT INTO `orderinfo` VALUES (21, 1, 2, 1, '2022-06-17 09:57:10');
INSERT INTO `orderinfo` VALUES (22, 1, 2, 1, '2022-06-17 09:58:28');
INSERT INTO `orderinfo` VALUES (23, 2, 2, 78, '2022-06-17 10:12:35');
INSERT INTO `orderinfo` VALUES (24, 5, 2, 1, '2022-06-17 10:14:56');
INSERT INTO `orderinfo` VALUES (26, 1, 2, 12, '2022-06-17 10:41:32');
INSERT INTO `orderinfo` VALUES (27, 4, 2, 78, '2022-06-17 10:44:00');
INSERT INTO `orderinfo` VALUES (30, 2, 1, 10, '2022-06-18 15:13:22');
INSERT INTO `orderinfo` VALUES (31, 11, 1, 67, '2022-06-18 17:12:50');
INSERT INTO `orderinfo` VALUES (32, 11, 1, 67, '2022-06-18 17:12:56');
INSERT INTO `orderinfo` VALUES (33, 9, 1, 33, '2022-06-19 13:40:49');
INSERT INTO `orderinfo` VALUES (34, 1, 1, 12, '2022-06-20 13:24:53');
INSERT INTO `orderinfo` VALUES (35, 9, 1, 33, '2022-06-21 10:25:26');
INSERT INTO `orderinfo` VALUES (36, 3, 2, 34, '2022-06-21 14:48:26');
INSERT INTO `orderinfo` VALUES (38, 9, 1, 33, '2022-06-21 16:44:31');
INSERT INTO `orderinfo` VALUES (40, 6, 1, 45, '2022-06-21 18:56:43');
INSERT INTO `orderinfo` VALUES (41, 1, 3, 12, '2022-06-21 21:02:54');
INSERT INTO `orderinfo` VALUES (42, 6, 1111, 45, '2022-06-22 21:08:44');
INSERT INTO `orderinfo` VALUES (43, 15, 1, 12, '2022-06-22 21:19:11');
INSERT INTO `orderinfo` VALUES (44, 2, 222, 10, '2022-06-23 09:12:48');
INSERT INTO `orderinfo` VALUES (45, 9, 1, 33, '2022-07-11 20:13:15');
INSERT INTO `orderinfo` VALUES (46, 1, 1, 12, '2022-11-30 15:09:00');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `UserAccount` int NOT NULL,
  `UserName` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UserPWD` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Sex` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT 1,
  `UserPhone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UserAge` int NULL DEFAULT NULL,
  `Address` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ImgName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`UserAccount`) USING BTREE,
  UNIQUE INDEX `UserPhone`(`UserPhone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, '张6', '123', '男', 1, '12345678910', 12, '北京市朝阳区', '1');
INSERT INTO `userinfo` VALUES (2, '李四', '123', '男', 0, '12345678920', 22, '上海市', '3');
INSERT INTO `userinfo` VALUES (3, '王五', '123456', '男', 1, '12345378910', 13, '北京市朝阳区', '1');
INSERT INTO `userinfo` VALUES (4, '李哈哈', '12300', '女', 1, '12345678320', 32, '成都市', '3');
INSERT INTO `userinfo` VALUES (5, '王哈哈', '110011', '男', 1, '12245678910', 12, '北京市朝阳区', '1');
INSERT INTO `userinfo` VALUES (6, '彭哈哈', '123', '男', 1, '12344678920', 22, '上海市', '3');
INSERT INTO `userinfo` VALUES (7, '莫哈哈', '123456', '男', 1, '12345378310', 13, '北京市朝阳区', '1');
INSERT INTO `userinfo` VALUES (8, '任哈哈', '123', '女', 1, '12345578320', 42, '意大利', '3');
INSERT INTO `userinfo` VALUES (9, '杜张艺兴', '123456', '男', 1, '12346678910', 12, '北京市朝阳区', '1');
INSERT INTO `userinfo` VALUES (10, '沙尔几步', '123', '女', 1, '12342678920', 22, '上海市', '3');
INSERT INTO `userinfo` VALUES (11, '老六', '123456', '男', 1, '12445378910', 16, '北京市朝阳区', '1');
INSERT INTO `userinfo` VALUES (12, '大帅哥', '123', '男', 1, '12345678520', 22, '成都市', '3');
INSERT INTO `userinfo` VALUES (20, '小白', '123456', '男', 1, '12345678930', 12, NULL, NULL);
INSERT INTO `userinfo` VALUES (21, '小黑', '123456', '男', 1, '12345678931', 12, NULL, NULL);
INSERT INTO `userinfo` VALUES (222, 'eee', '123', '男', 1, '13540980899', 12, '123', NULL);
INSERT INTO `userinfo` VALUES (1111, 'yyy', '123', '女', 0, '12345678901', 34, '66', NULL);

SET FOREIGN_KEY_CHECKS = 1;
