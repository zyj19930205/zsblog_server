/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : localhost:3306
 Source Schema         : zsblog

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 22/05/2020 17:57:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zs_article
-- ----------------------------
DROP TABLE IF EXISTS `zs_article`;
CREATE TABLE `zs_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` mediumtext CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `authorId` int(11) NULL DEFAULT NULL,
  `tips` bigint(20) NULL DEFAULT NULL,
  `stars` int(255) NULL DEFAULT NULL,
  `type` int(255) NULL DEFAULT NULL,
  `isopened` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zs_article
-- ----------------------------
INSERT INTO `zs_article` VALUES (1, '无解肥了', '无解肥', NULL, 1, 5, 0, 2, 1);
INSERT INTO `zs_article` VALUES (2, '蜀道难', '<p><strong>蜀道之难，难于上青天</strong></p>', NULL, 1, 6, 3, 2, 1);
INSERT INTO `zs_article` VALUES (3, '号卡-bss侧常用表', '<p><strong><em>1.Bb_Service_Relation_t----可以查到号码的状态，根据if_valid进行判断，如果为0则代表不在网</em></strong></p><p><br></p><p><strong><em>2.Bb_gsm_service_info_t----bss侧号卡信息表</em></strong></p><p><br></p><p><strong><em>3.UCR_CRM4.tf_f_user_res@crm2jxewitch----cbss号卡信息表</em></strong></p><p><br></p><p><strong><em>4.bb_device_complete_t ----固网终端解绑导入表</em></strong></p><p><br></p><p><strong><em>5.bb_fixeddev_bind_info_t----固网终端绑定表</em></strong></p><p><br></p><p><strong><em>6.br_use_status_t----号卡状态表</em></strong></p>', NULL, 1, 7, 1, 1, 0);
INSERT INTO `zs_article` VALUES (4, '过秦论', '<p>    秦孝公据崤函之固，拥雍州之地，君臣固守以窥周室，有席卷天下，包举宇内，囊括四海之意，并吞八荒之心。当是时也，商君佐之，内立法度，务耕织，修守战之具，外连衡而斗诸侯。于是秦人拱手而取西河之外。</p><p><br></p><p>    孝公既没，惠文、武、昭襄蒙故业，因遗策，南取汉中，西举巴、蜀，东割膏腴之地，北收要害之郡。诸侯恐惧，会盟而谋弱秦，不爱珍器重宝肥饶之地，以致天下之士，合从缔交，相与为一。当此之时，齐有孟尝，赵有平原，楚有春申，魏有信陵。此四君者，皆明智而忠信，宽厚而爱人，尊贤而重士，约从离衡，兼韩、魏、燕、楚、齐、赵、宋、卫、中山之众。于是六国之士，有宁越、徐尚、苏秦、杜赫之属为之谋，齐明、周最、陈轸、召滑、楼缓、翟景、苏厉、乐毅之徒通其意，吴起、孙膑、带佗、倪良、王廖、田忌、廉颇、赵奢之伦制其兵。尝以十倍之地，百万之众，叩关而攻秦。秦人开关延敌，九国之师，逡巡而不敢进。秦无亡矢遗镞之费，而天下诸侯已困矣。于是从散约败，争割地而赂秦。秦有余力而制其弊，追亡逐北，伏尸百万，流血漂橹；因利乘便，宰割天下，分裂山河。强国请服，弱国入朝。延及孝文王、庄襄王，享国之日浅，国家无事。</p><p><br></p><p>    及至始皇，奋六世之余烈，振长策而御宇内，吞二周而亡诸侯，履至尊而制六合，执敲扑而鞭笞天下，威振四海。南取百越之地，以为桂林、象郡；百越之君，俯首系颈，委命下吏。乃使蒙恬北筑长城而守藩篱，却匈奴七百余里；胡人不敢南下而牧马，士不敢弯弓而报怨。于是废先王之道，焚百家之言，以愚黔首；隳名城，杀豪杰；收天下之兵，聚之咸阳，销锋镝，铸以为金人十二，以弱天下之民。然后践华为城，因河为池，据亿丈之城，临不测之渊，以为固。良将劲弩守要害之处，信臣精卒陈利兵而谁何。天下已定，始皇之心，自以为关中之固，金城千里，子孙帝王万世之业也。</p><p><br></p><p>    始皇既没，余威震于殊俗。然陈涉瓮牖绳枢之子，氓隶之人，而迁徙之徒也；才能不及中人，非有仲尼，墨翟之贤，陶朱、猗顿之富；蹑足行伍之间，而倔起阡陌之中，率疲弊之卒，将数百之众，转而攻秦；斩木为兵，揭竿为旗，天下云集响应，赢粮而景从。山东豪俊遂并起而亡秦族矣。</p><p><br></p><p>    且夫天下非小弱也，雍州之地，崤函之固，自若也。陈涉之位，非尊于齐、楚、燕、赵、韩、魏、宋、卫、中山之君也；锄櫌棘矜，非铦于钩戟长铩也；谪戍之众，非抗于九国之师也；深谋远虑，行军用兵之道，非及向时之士也。然而成败异变，功业相反，何也？试使山东之国与陈涉度长絜大，比权量力，则不可同年而语矣。然秦以区区之地，致万乘之势，序八州而朝同列，百有余年矣；然后以六合为家，崤函为宫；一夫作难而七庙隳，身死人手，为天下笑者，何也？仁义不施而攻守之势异也。</p>', NULL, 1, 8, 55, 2, 1);
INSERT INTO `zs_article` VALUES (5, '冒泡排序', '<p>比较相邻的元素，如果前一个比后一个大，交换之。</p><p>1.第一趟排序第1个和第2个一对，比较与交换，随后第2个和第3个一对比较交换，这样直到倒数第2个和最后1个，将最大的数移动到最后一位。</p><p>2.第二趟将第二大的数移动至倒数第二位</p><p> ......</p><p> 因此需要n-1趟；</p><p><br></p><p><br></p>', NULL, 1, 9, 12, 2, 1);

-- ----------------------------
-- Table structure for zs_article_tags
-- ----------------------------
DROP TABLE IF EXISTS `zs_article_tags`;
CREATE TABLE `zs_article_tags`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) NULL DEFAULT NULL,
  `tagsId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zs_article_tags
-- ----------------------------
INSERT INTO `zs_article_tags` VALUES (1, 1, 5);
INSERT INTO `zs_article_tags` VALUES (2, 2, 7);
INSERT INTO `zs_article_tags` VALUES (3, 3, 3);
INSERT INTO `zs_article_tags` VALUES (4, 4, 7);
INSERT INTO `zs_article_tags` VALUES (5, 5, 2);

-- ----------------------------
-- Table structure for zs_tag
-- ----------------------------
DROP TABLE IF EXISTS `zs_tag`;
CREATE TABLE `zs_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zs_tag
-- ----------------------------
INSERT INTO `zs_tag` VALUES (1, '游戏');
INSERT INTO `zs_tag` VALUES (2, '学习');
INSERT INTO `zs_tag` VALUES (3, '工作');
INSERT INTO `zs_tag` VALUES (4, '吃货');
INSERT INTO `zs_tag` VALUES (5, '杂项');
INSERT INTO `zs_tag` VALUES (6, '工具');
INSERT INTO `zs_tag` VALUES (7, '文学');

-- ----------------------------
-- Table structure for zs_type
-- ----------------------------
DROP TABLE IF EXISTS `zs_type`;
CREATE TABLE `zs_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zs_type
-- ----------------------------
INSERT INTO `zs_type` VALUES (1, '原创');
INSERT INTO `zs_type` VALUES (2, '转载');
INSERT INTO `zs_type` VALUES (3, '资源');
INSERT INTO `zs_type` VALUES (4, '通知');

-- ----------------------------
-- Table structure for zs_user
-- ----------------------------
DROP TABLE IF EXISTS `zs_user`;
CREATE TABLE `zs_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `fansnum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of zs_user
-- ----------------------------
INSERT INTO `zs_user` VALUES (1, 'qwe1234rt', 'qwe1234', '邹大仙', 699);

SET FOREIGN_KEY_CHECKS = 1;
