/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : tbkshop

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2013-08-12 16:19:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_app_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_app_type`;
CREATE TABLE `t_app_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL COMMENT '应用类型名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `parent` int(11) DEFAULT NULL COMMENT '上一级分类',
  `visible` tinyint(4) DEFAULT NULL COMMENT '是否可见，1=可见，0=隐藏 ',
  `order_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_app_type
-- ----------------------------
INSERT INTO `t_app_type` VALUES ('1', '应用', '应用分类', '0', '1', '1');
INSERT INTO `t_app_type` VALUES ('2', '游戏', '游戏分类', '0', '1', '0');
INSERT INTO `t_app_type` VALUES ('3', '系统工具', '', '1', '1', '1');
INSERT INTO `t_app_type` VALUES ('4', '实用工具', '', '1', '1', '2');
INSERT INTO `t_app_type` VALUES ('5', '社交通信', '', '1', '1', '3');
INSERT INTO `t_app_type` VALUES ('6', '旅行天气', '', '1', '1', '4');
INSERT INTO `t_app_type` VALUES ('7', '影音漫画', '', '1', '1', '5');
INSERT INTO `t_app_type` VALUES ('8', '商务财经', '', '1', '1', '6');
INSERT INTO `t_app_type` VALUES ('9', '生活助手', '', '1', '1', '7');
INSERT INTO `t_app_type` VALUES ('10', '学习人文', '', '1', '1', '8');
INSERT INTO `t_app_type` VALUES ('11', '美化壁纸', '', '1', '1', '9');
INSERT INTO `t_app_type` VALUES ('12', '阅读资讯', '', '1', '1', '10');
INSERT INTO `t_app_type` VALUES ('13', '网络通讯', '', '1', '1', '11');
INSERT INTO `t_app_type` VALUES ('14', '电子书', '', '1', '1', '12');
INSERT INTO `t_app_type` VALUES ('15', '手机安全', '', '1', '1', '13');
INSERT INTO `t_app_type` VALUES ('16', '应用商店', '', '1', '1', '14');
INSERT INTO `t_app_type` VALUES ('17', '其它', '', '1', '1', '15');
INSERT INTO `t_app_type` VALUES ('18', '休闲益智', '', '2', '1', '16');
INSERT INTO `t_app_type` VALUES ('19', '策略棋牌', '', '2', '1', '17');
INSERT INTO `t_app_type` VALUES ('20', '角色扮演', '', '2', '1', '18');
INSERT INTO `t_app_type` VALUES ('21', '动作格斗', '', '2', '1', '19');
INSERT INTO `t_app_type` VALUES ('22', '射击飞行', '', '2', '1', '20');
INSERT INTO `t_app_type` VALUES ('23', '体育竞技', '', '2', '1', '21');
INSERT INTO `t_app_type` VALUES ('24', '网游游戏', '', '2', '1', '22');
INSERT INTO `t_app_type` VALUES ('25', '模拟游戏', '', '2', '1', '23');

-- ----------------------------
-- Table structure for `t_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config` (
  `cmd_name` varchar(100) NOT NULL,
  `cmd_value` varchar(300) DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cmd_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_config
-- ----------------------------
INSERT INTO `t_config` VALUES ('released_sdk', 'sa_sdk_0.2.4.zip', '2013-01-06 02:16:03');
INSERT INTO `t_config` VALUES ('files_path', '/home/sd/files', '2013-05-28 08:59:14');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `menuname` varchar(250) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `description` varchar(250) DEFAULT NULL COMMENT '描述',
  `path` varchar(250) DEFAULT '' COMMENT '菜单路径',
  `parent` int(4) DEFAULT '0' COMMENT '父菜单',
  `visible` int(4) DEFAULT '1' COMMENT '是否可见：0-不可见，1-可见',
  `status` int(4) DEFAULT '0' COMMENT '是否有效 0-有效，1-无效',
  `order_no` varchar(50) DEFAULT '0' COMMENT '排序标示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '系统管理', null, '', '0', '1', '1', '1');
INSERT INTO `t_menu` VALUES ('2', '新增用户', '', '/accounts/formpage.html', '1', '1', '1', '111');
INSERT INTO `t_menu` VALUES ('3', '用户列表', null, '/accounts/listUser.html', '1', '1', '1', '112');
INSERT INTO `t_menu` VALUES ('4', '新增角色', null, '/role/formpage.html', '1', '1', '1', '121');
INSERT INTO `t_menu` VALUES ('5', '角色列表', null, '/role/listRole.html', '1', '1', '1', '122');
INSERT INTO `t_menu` VALUES ('6', '新增菜单', null, '/menu/formpage.html', '1', '1', '1', '131');
INSERT INTO `t_menu` VALUES ('7', '菜单列表', null, '/menu/listMenu.html', '1', '1', '1', '132');
INSERT INTO `t_menu` VALUES ('13', '查看权限', null, '/role/roleFormpage.html', '1', '0', '1', '124');
INSERT INTO `t_menu` VALUES ('14', '设置角色权限', null, '/role/setRoleMenu.html', '1', '0', '1', '125');
INSERT INTO `t_menu` VALUES ('15', '新增菜单', null, '/menu/formpage.html', '1', '0', '1', '133');
INSERT INTO `t_menu` VALUES ('16', '查找菜单', null, '/menu/getMenu.html', '1', '0', '1', '134');
INSERT INTO `t_menu` VALUES ('17', '修改菜单', null, '/menu/updateMenu.html', '1', '0', '1', '135');
INSERT INTO `t_menu` VALUES ('22', '编辑用户', null, '/user/editUser.html', '1', '0', '1', '114');
INSERT INTO `t_menu` VALUES ('23', '修改用户角色&状态', null, '/user/updateUserRoleAndStatus.html', '1', '0', '1', '115');
INSERT INTO `t_menu` VALUES ('24', '重置密码', null, '/ajax/updateUser.html', '1', '0', '1', '116');
INSERT INTO `t_menu` VALUES ('67', '帐户管理', '', '', '0', '1', '1', '4');
INSERT INTO `t_menu` VALUES ('79', '个人资料', '', '/accounts/overview', '67', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('80', '修改Email', '', '/accounts/change_email', '67', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('81', '修改资料', '', '/accounts/change_profile', '67', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('82', '修改密码', '', '/accounts/change_pwd', '67', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('88', '用户审核', '', '', '0', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('89', '用户审核列表', '', '/accounts/userReviewList.html', '88', '1', '1', '0');

-- ----------------------------
-- Table structure for `t_reset_pwd`
-- ----------------------------
DROP TABLE IF EXISTS `t_reset_pwd`;
CREATE TABLE `t_reset_pwd` (
  `email` varchar(100) NOT NULL,
  `token` varchar(80) NOT NULL,
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enable` bit(1) NOT NULL COMMENT '0 is enable',
  PRIMARY KEY (`email`),
  UNIQUE KEY `id_token` (`token`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_reset_pwd
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
  `status` int(4) DEFAULT '0' COMMENT '状态：0-有效 1-无效',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '1', '2013-04-07 03:18:49');
INSERT INTO `t_role` VALUES ('2', '超级管理员', '1', '2013-04-07 06:27:39');
INSERT INTO `t_role` VALUES ('3', '会员', '1', '2013-04-22 08:13:21');

-- ----------------------------
-- Table structure for `t_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `role_id` int(4) NOT NULL COMMENT '角色ID',
  `menu_id` int(4) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1832 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1565', '4', '66');
INSERT INTO `t_role_menu` VALUES ('1566', '4', '68');
INSERT INTO `t_role_menu` VALUES ('1567', '4', '69');
INSERT INTO `t_role_menu` VALUES ('1568', '4', '70');
INSERT INTO `t_role_menu` VALUES ('1569', '4', '71');
INSERT INTO `t_role_menu` VALUES ('1570', '4', '67');
INSERT INTO `t_role_menu` VALUES ('1571', '4', '79');
INSERT INTO `t_role_menu` VALUES ('1572', '4', '80');
INSERT INTO `t_role_menu` VALUES ('1573', '4', '81');
INSERT INTO `t_role_menu` VALUES ('1574', '4', '82');
INSERT INTO `t_role_menu` VALUES ('1575', '4', '72');
INSERT INTO `t_role_menu` VALUES ('1576', '4', '74');
INSERT INTO `t_role_menu` VALUES ('1577', '4', '75');
INSERT INTO `t_role_menu` VALUES ('1578', '4', '76');
INSERT INTO `t_role_menu` VALUES ('1579', '4', '73');
INSERT INTO `t_role_menu` VALUES ('1580', '4', '77');
INSERT INTO `t_role_menu` VALUES ('1581', '4', '78');
INSERT INTO `t_role_menu` VALUES ('1582', '4', '26');
INSERT INTO `t_role_menu` VALUES ('1583', '4', '27');
INSERT INTO `t_role_menu` VALUES ('1584', '4', '28');
INSERT INTO `t_role_menu` VALUES ('1585', '4', '29');
INSERT INTO `t_role_menu` VALUES ('1586', '4', '30');
INSERT INTO `t_role_menu` VALUES ('1587', '4', '31');
INSERT INTO `t_role_menu` VALUES ('1588', '4', '32');
INSERT INTO `t_role_menu` VALUES ('1614', '5', '66');
INSERT INTO `t_role_menu` VALUES ('1615', '5', '68');
INSERT INTO `t_role_menu` VALUES ('1616', '5', '69');
INSERT INTO `t_role_menu` VALUES ('1617', '5', '70');
INSERT INTO `t_role_menu` VALUES ('1618', '5', '71');
INSERT INTO `t_role_menu` VALUES ('1619', '5', '67');
INSERT INTO `t_role_menu` VALUES ('1620', '5', '79');
INSERT INTO `t_role_menu` VALUES ('1621', '5', '80');
INSERT INTO `t_role_menu` VALUES ('1622', '5', '81');
INSERT INTO `t_role_menu` VALUES ('1623', '5', '82');
INSERT INTO `t_role_menu` VALUES ('1624', '5', '72');
INSERT INTO `t_role_menu` VALUES ('1625', '5', '74');
INSERT INTO `t_role_menu` VALUES ('1626', '5', '75');
INSERT INTO `t_role_menu` VALUES ('1627', '5', '76');
INSERT INTO `t_role_menu` VALUES ('1628', '5', '73');
INSERT INTO `t_role_menu` VALUES ('1629', '5', '77');
INSERT INTO `t_role_menu` VALUES ('1630', '5', '78');
INSERT INTO `t_role_menu` VALUES ('1631', '5', '83');
INSERT INTO `t_role_menu` VALUES ('1632', '5', '84');
INSERT INTO `t_role_menu` VALUES ('1633', '5', '85');
INSERT INTO `t_role_menu` VALUES ('1634', '5', '86');
INSERT INTO `t_role_menu` VALUES ('1635', '5', '87');
INSERT INTO `t_role_menu` VALUES ('1636', '5', '88');
INSERT INTO `t_role_menu` VALUES ('1637', '5', '89');
INSERT INTO `t_role_menu` VALUES ('1638', '5', '90');
INSERT INTO `t_role_menu` VALUES ('1639', '5', '91');
INSERT INTO `t_role_menu` VALUES ('1640', '5', '92');
INSERT INTO `t_role_menu` VALUES ('1641', '5', '93');
INSERT INTO `t_role_menu` VALUES ('1642', '5', '1');
INSERT INTO `t_role_menu` VALUES ('1643', '5', '2');
INSERT INTO `t_role_menu` VALUES ('1644', '5', '3');
INSERT INTO `t_role_menu` VALUES ('1645', '5', '22');
INSERT INTO `t_role_menu` VALUES ('1646', '5', '23');
INSERT INTO `t_role_menu` VALUES ('1647', '5', '24');
INSERT INTO `t_role_menu` VALUES ('1648', '5', '25');
INSERT INTO `t_role_menu` VALUES ('1649', '5', '45');
INSERT INTO `t_role_menu` VALUES ('1650', '5', '4');
INSERT INTO `t_role_menu` VALUES ('1651', '5', '5');
INSERT INTO `t_role_menu` VALUES ('1652', '5', '13');
INSERT INTO `t_role_menu` VALUES ('1653', '5', '14');
INSERT INTO `t_role_menu` VALUES ('1654', '5', '6');
INSERT INTO `t_role_menu` VALUES ('1655', '5', '7');
INSERT INTO `t_role_menu` VALUES ('1656', '5', '15');
INSERT INTO `t_role_menu` VALUES ('1657', '5', '16');
INSERT INTO `t_role_menu` VALUES ('1658', '5', '17');
INSERT INTO `t_role_menu` VALUES ('1659', '5', '46');
INSERT INTO `t_role_menu` VALUES ('1660', '5', '47');
INSERT INTO `t_role_menu` VALUES ('1661', '5', '48');
INSERT INTO `t_role_menu` VALUES ('1662', '5', '49');
INSERT INTO `t_role_menu` VALUES ('1663', '5', '50');
INSERT INTO `t_role_menu` VALUES ('1664', '5', '51');
INSERT INTO `t_role_menu` VALUES ('1665', '5', '8');
INSERT INTO `t_role_menu` VALUES ('1666', '5', '9');
INSERT INTO `t_role_menu` VALUES ('1667', '5', '10');
INSERT INTO `t_role_menu` VALUES ('1668', '5', '18');
INSERT INTO `t_role_menu` VALUES ('1669', '5', '19');
INSERT INTO `t_role_menu` VALUES ('1670', '5', '21');
INSERT INTO `t_role_menu` VALUES ('1671', '5', '26');
INSERT INTO `t_role_menu` VALUES ('1672', '5', '27');
INSERT INTO `t_role_menu` VALUES ('1673', '5', '28');
INSERT INTO `t_role_menu` VALUES ('1674', '5', '29');
INSERT INTO `t_role_menu` VALUES ('1675', '5', '33');
INSERT INTO `t_role_menu` VALUES ('1676', '5', '30');
INSERT INTO `t_role_menu` VALUES ('1677', '5', '31');
INSERT INTO `t_role_menu` VALUES ('1678', '5', '32');
INSERT INTO `t_role_menu` VALUES ('1721', '3', '66');
INSERT INTO `t_role_menu` VALUES ('1722', '3', '68');
INSERT INTO `t_role_menu` VALUES ('1723', '3', '69');
INSERT INTO `t_role_menu` VALUES ('1724', '3', '70');
INSERT INTO `t_role_menu` VALUES ('1725', '3', '71');
INSERT INTO `t_role_menu` VALUES ('1726', '3', '67');
INSERT INTO `t_role_menu` VALUES ('1727', '3', '79');
INSERT INTO `t_role_menu` VALUES ('1728', '3', '80');
INSERT INTO `t_role_menu` VALUES ('1729', '3', '81');
INSERT INTO `t_role_menu` VALUES ('1730', '3', '82');
INSERT INTO `t_role_menu` VALUES ('1731', '3', '72');
INSERT INTO `t_role_menu` VALUES ('1732', '3', '75');
INSERT INTO `t_role_menu` VALUES ('1733', '3', '76');
INSERT INTO `t_role_menu` VALUES ('1734', '3', '73');
INSERT INTO `t_role_menu` VALUES ('1735', '3', '77');
INSERT INTO `t_role_menu` VALUES ('1736', '3', '78');
INSERT INTO `t_role_menu` VALUES ('1737', '3', '26');
INSERT INTO `t_role_menu` VALUES ('1738', '3', '27');
INSERT INTO `t_role_menu` VALUES ('1739', '3', '28');
INSERT INTO `t_role_menu` VALUES ('1740', '3', '29');
INSERT INTO `t_role_menu` VALUES ('1741', '3', '30');
INSERT INTO `t_role_menu` VALUES ('1742', '3', '31');
INSERT INTO `t_role_menu` VALUES ('1743', '3', '32');
INSERT INTO `t_role_menu` VALUES ('1744', '1', '1');
INSERT INTO `t_role_menu` VALUES ('1745', '1', '95');
INSERT INTO `t_role_menu` VALUES ('1746', '1', '96');
INSERT INTO `t_role_menu` VALUES ('1747', '1', '2');
INSERT INTO `t_role_menu` VALUES ('1748', '1', '3');
INSERT INTO `t_role_menu` VALUES ('1749', '1', '22');
INSERT INTO `t_role_menu` VALUES ('1750', '1', '23');
INSERT INTO `t_role_menu` VALUES ('1751', '1', '24');
INSERT INTO `t_role_menu` VALUES ('1752', '1', '25');
INSERT INTO `t_role_menu` VALUES ('1753', '1', '45');
INSERT INTO `t_role_menu` VALUES ('1754', '1', '4');
INSERT INTO `t_role_menu` VALUES ('1755', '1', '5');
INSERT INTO `t_role_menu` VALUES ('1756', '1', '13');
INSERT INTO `t_role_menu` VALUES ('1757', '1', '14');
INSERT INTO `t_role_menu` VALUES ('1758', '1', '6');
INSERT INTO `t_role_menu` VALUES ('1759', '1', '7');
INSERT INTO `t_role_menu` VALUES ('1760', '1', '15');
INSERT INTO `t_role_menu` VALUES ('1761', '1', '16');
INSERT INTO `t_role_menu` VALUES ('1762', '1', '17');
INSERT INTO `t_role_menu` VALUES ('1763', '1', '46');
INSERT INTO `t_role_menu` VALUES ('1764', '1', '47');
INSERT INTO `t_role_menu` VALUES ('1765', '1', '48');
INSERT INTO `t_role_menu` VALUES ('1766', '1', '49');
INSERT INTO `t_role_menu` VALUES ('1767', '1', '50');
INSERT INTO `t_role_menu` VALUES ('1768', '1', '51');
INSERT INTO `t_role_menu` VALUES ('1810', '2', '26');
INSERT INTO `t_role_menu` VALUES ('1811', '2', '33');
INSERT INTO `t_role_menu` VALUES ('1812', '2', '83');
INSERT INTO `t_role_menu` VALUES ('1813', '2', '84');
INSERT INTO `t_role_menu` VALUES ('1814', '2', '85');
INSERT INTO `t_role_menu` VALUES ('1815', '2', '86');
INSERT INTO `t_role_menu` VALUES ('1816', '2', '87');
INSERT INTO `t_role_menu` VALUES ('1817', '2', '88');
INSERT INTO `t_role_menu` VALUES ('1818', '2', '89');
INSERT INTO `t_role_menu` VALUES ('1819', '2', '90');
INSERT INTO `t_role_menu` VALUES ('1820', '2', '91');
INSERT INTO `t_role_menu` VALUES ('1821', '2', '92');
INSERT INTO `t_role_menu` VALUES ('1822', '2', '93');
INSERT INTO `t_role_menu` VALUES ('1823', '2', '1000');
INSERT INTO `t_role_menu` VALUES ('1824', '2', '1001');
INSERT INTO `t_role_menu` VALUES ('1825', '2', '8');
INSERT INTO `t_role_menu` VALUES ('1826', '2', '9');
INSERT INTO `t_role_menu` VALUES ('1827', '2', '10');
INSERT INTO `t_role_menu` VALUES ('1828', '2', '18');
INSERT INTO `t_role_menu` VALUES ('1829', '2', '19');
INSERT INTO `t_role_menu` VALUES ('1830', '2', '21');
INSERT INTO `t_role_menu` VALUES ('1831', '2', '96');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `account_name` varchar(20) NOT NULL COMMENT '帐户名称',
  `account_pwd` varchar(32) NOT NULL COMMENT '帐户密码',
  `email` varchar(100) NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '角色类型',
  `company` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `contact_name` varchar(45) DEFAULT NULL,
  `contact_tel` varchar(45) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `createtime` datetime NOT NULL COMMENT '注册日期',
  `login_token` varchar(50) DEFAULT NULL,
  `login_token_time` datetime DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_name`),
  UNIQUE KEY `id_UNIQUE` (`uid`),
  UNIQUE KEY `id_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1350073 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin@adplatform.com', '1', '', '系统管理员', '', null, '', '2013-06-02 17:43:46', 'a9b8afaab8d6463f8cc5e004e1164f28', '2013-08-12 15:38:26', '1');
INSERT INTO `t_user` VALUES ('2', 'spadmin', 'e10adc3949ba59abbe56e057f20f883e', 'spadmin@adplatform.com', '2', '', '运营管理员', '', null, '', '2013-07-08 00:12:45', 'd22ff486aaf54ebabe74fa47e03f3bc3', '2013-08-12 15:38:19', '1');

-- ----------------------------
-- Table structure for `t_user_account`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account`;
CREATE TABLE `t_user_account` (
  `uid` varchar(20) NOT NULL COMMENT '用户',
  `balance` double NOT NULL COMMENT '余额',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新日期',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_account
-- ----------------------------
INSERT INTO `t_user_account` VALUES ('1', '0', '2013-06-02 02:41:21');
INSERT INTO `t_user_account` VALUES ('1350070', '0', '2013-06-06 16:57:00');
INSERT INTO `t_user_account` VALUES ('1350071', '0', '2013-06-06 16:57:00');
INSERT INTO `t_user_account` VALUES ('1350072', '0', '2013-08-09 09:43:44');
INSERT INTO `t_user_account` VALUES ('2', '0', '2013-06-02 09:47:41');
