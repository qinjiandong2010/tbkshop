/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : tbkshop

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2013-09-05 18:57:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌编号ID',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `cate_id` int(11) DEFAULT NULL COMMENT '品牌分类',
  `brand_icon` varchar(255) DEFAULT NULL COMMENT '品牌图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(11) DEFAULT '1' COMMENT '状态,1=可用,0=禁用',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='品牌';

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO `t_brand` VALUES ('2', '千百惠', null, '56', '', '0', '1', '0');

-- ----------------------------
-- Table structure for `t_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品编号ID',
  `product_price` double DEFAULT '0' COMMENT '商品价格',
  `product_integral` int(11) DEFAULT '0' COMMENT '商品积分',
  `product_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `product_imgurl` text COMMENT '商品图片来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cart
-- ----------------------------

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL COMMENT '应用类型名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `parent` int(11) DEFAULT NULL COMMENT '上一级分类',
  `visible` tinyint(4) DEFAULT NULL COMMENT '是否可见，1=可见，0=隐藏 ',
  `order_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('39', '上衣', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('40', '雪纺衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('41', 'T恤', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('42', '衬衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('43', '小衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('44', '蕾丝衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('45', '开衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('46', '小西装', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('47', '防晒衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('48', '短外套', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('49', '背心', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('50', '罩衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('51', '马甲', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('52', '针织衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('53', '吊带', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('54', '卫衣', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('55', 'polo衫', '', '39', '1', '0');
INSERT INTO `t_category` VALUES ('56', '裙子', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('57', '连衣裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('58', '短裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('59', '半身裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('60', '长裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('61', '背心裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('62', '雪纺裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('63', '背心裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('64', '雪纺裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('65', '印花裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('66', '蕾丝裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('67', '百褶裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('68', '沙滩裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('69', '伞摆裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('70', '中长连衣裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('71', '蓬蓬裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('72', '衬衫连衣裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('73', '包臀裙', '', '56', '1', '0');
INSERT INTO `t_category` VALUES ('74', '内衣/泳衣/家服', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('75', 'Bra', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('76', '内衣套装', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('77', '内裤', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('78', '家居服', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('79', '睡衣/睡裙', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('80', '无痕内衣', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('81', '泳衣', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('82', '隐形内衣', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('83', '安全裤', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('84', '塑身衣', '', '74', '1', '0');
INSERT INTO `t_category` VALUES ('85', '裤子', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('86', '铅笔裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('87', '铅笔裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('88', '短裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('89', '牛仔裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('90', '裙裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('91', '连体裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('92', '背带裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('93', '西装裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('94', '高腰裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('95', '直筒裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('96', '阔腿裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('97', '休闲裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('98', '哈伦裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('99', '长裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('100', '小脚裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('101', '热裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('102', '七分裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('103', '五分裤', '', '85', '1', '0');
INSERT INTO `t_category` VALUES ('104', '鞋子', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('105', '高跟鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('106', '凉鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('107', '单鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('108', '运动鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('109', '帆布鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('110', '松糕鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('111', '船鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('112', '布洛克鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('113', '果冻鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('114', '凉拖', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('115', '鱼嘴鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('116', '夹脚鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('117', '浅口鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('118', '平底鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('119', '豆豆鞋', '', '104', '1', '0');
INSERT INTO `t_category` VALUES ('120', '童装', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('121', '衬衫', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('122', '哈衣', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('123', '短袖T恤', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('124', '背心/马甲', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('125', '连衣裙', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('126', '短裙', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('127', '短裤', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('128', '长裤', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('129', '长T', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('130', '小西装', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('131', '背心裙', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('132', '雪纺裙', '', '120', '1', '0');
INSERT INTO `t_category` VALUES ('133', '包包', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('134', '单肩包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('135', '斜挎包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('136', '双肩包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('137', '链条包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('138', '机车包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('139', '钱包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('140', '邮差包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('141', '功能箱包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('142', '手拿包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('143', '手提包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('144', '水桶包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('145', '迷你包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('146', '信封包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('147', '旅行包', '', '133', '1', '0');
INSERT INTO `t_category` VALUES ('148', '配饰', '', '0', '1', '0');
INSERT INTO `t_category` VALUES ('149', '项链', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('150', '耳钉/耳环', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('151', '戒指', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('152', '腰带', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('153', '假领', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('154', '手链/手镯', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('155', '手表', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('156', '发饰', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('157', '丝袜', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('158', '手表', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('159', '吊坠', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('160', '脚链', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('161', '挂件', '', '148', '1', '0');
INSERT INTO `t_category` VALUES ('162', '纹身贴', '', '148', '1', '0');

-- ----------------------------
-- Table structure for `t_complaint`
-- ----------------------------
DROP TABLE IF EXISTS `t_complaint`;
CREATE TABLE `t_complaint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `user_name` varchar(255) DEFAULT NULL COMMENT '创建者用户名',
  `complaintto` bigint(20) DEFAULT NULL COMMENT '回复目标用户',
  `complaintfrom` bigint(20) DEFAULT NULL COMMENT '回复者',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0--unhandled complaint\r\n1--handled complaint',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL COMMENT '修改时间',
  `img` varchar(255) DEFAULT NULL COMMENT '头像',
  `delflag` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ind_creater` (`roleid`),
  KEY `ind_createtime` (`createtime`),
  KEY `ind_complaintto` (`complaintto`),
  KEY `ind_complaintfrom` (`complaintfrom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB; InnoDB free: 11264 kB; InnoDB free: 1';

-- ----------------------------
-- Records of t_complaint
-- ----------------------------

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
INSERT INTO `t_config` VALUES ('files_path', '/home/sd/files', '2013-05-28 08:59:14');
INSERT INTO `t_config` VALUES ('released_sdk', 'sa_sdk_0.2.4.zip', '2013-01-06 02:16:03');

-- ----------------------------
-- Table structure for `t_coupons`
-- ----------------------------
DROP TABLE IF EXISTS `t_coupons`;
CREATE TABLE `t_coupons` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `coupons_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '优惠卷名称',
  `coupons_cate` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '优惠卷分类',
  `shop_id` int(11) NOT NULL DEFAULT '0' COMMENT '所属商家',
  `is_shop_recommend` tinyint(3) DEFAULT '0' COMMENT '是否优惠劵特推商家',
  `img` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `displaydate` datetime DEFAULT NULL COMMENT '预约显示时间',
  `startdate` datetime DEFAULT NULL COMMENT '优惠卷开始有效时间',
  `enddate` datetime DEFAULT NULL COMMENT '优惠卷有效结束时间',
  `disabled` tinyint(3) DEFAULT '0' COMMENT '是否启用，1=是，0=否',
  `status` tinyint(3) DEFAULT '0' COMMENT '是否前台显示，1=是，0=否',
  `sort` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '排序',
  `notice` text COLLATE utf8_bin COMMENT '卷使用注意事项',
  `describe` text COLLATE utf8_bin COMMENT '优惠卷描述',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='优惠卷';

-- ----------------------------
-- Records of t_coupons
-- ----------------------------

-- ----------------------------
-- Table structure for `t_extend`
-- ----------------------------
DROP TABLE IF EXISTS `t_extend`;
CREATE TABLE `t_extend` (
  `extend_id` varchar(32) DEFAULT NULL COMMENT '主表对应GUID',
  `keyfield` varchar(255) DEFAULT NULL COMMENT '扩展的列名',
  `type` tinyint(4) DEFAULT NULL COMMENT '数据类型,比如 int = 1,char = 2 ,text = 3',
  `val_varchar` varchar(500) DEFAULT NULL,
  `val_text` text,
  `val_char` char(255) DEFAULT NULL,
  `val_double` double DEFAULT NULL,
  `val_int` int(11) DEFAULT NULL,
  UNIQUE KEY `idx_uni_extendid_keyfield` (`extend_id`,`keyfield`) USING BTREE,
  KEY `idx_extend_id` (`extend_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_extend
-- ----------------------------

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号ID',
  `goods_code` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `goods_name` varchar(200) NOT NULL COMMENT '商品名称',
  `display_name` varchar(255) DEFAULT NULL COMMENT '显示名称',
  `shop_id` int(11) DEFAULT NULL COMMENT '商家',
  `brand_id` int(11) DEFAULT NULL COMMENT '所属品牌',
  `creater_uid` int(11) DEFAULT NULL COMMENT '创建者',
  `cate_id` int(11) DEFAULT NULL COMMENT '商品分类',
  `sell_price` double DEFAULT NULL COMMENT '销售价',
  `cost_price` double DEFAULT NULL COMMENT '成本价',
  `comm_rate` double DEFAULT NULL COMMENT '佣金率',
  `comm_price` double DEFAULT NULL COMMENT '佣金额',
  `goods_pic` text COMMENT '图片',
  `brief` varchar(255) DEFAULT NULL COMMENT '概要描述',
  `content` text COMMENT '商品介绍',
  `like_num` varchar(255) DEFAULT NULL COMMENT '用户喜欢基数',
  `is_top` tinyint(3) DEFAULT NULL COMMENT '是否首推',
  `is_hot` tinyint(3) DEFAULT NULL COMMENT '是否热销商品',
  `index_hot` tinyint(3) DEFAULT NULL COMMENT '是否热门商品',
  `status` tinyint(3) DEFAULT NULL COMMENT '商品状态',
  `preview` tinyint(3) DEFAULT NULL COMMENT '是否可浏览',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `keyword` varchar(100) NOT NULL DEFAULT '' COMMENT '商品关键字',
  `stocks` int(11) DEFAULT NULL COMMENT '库存量',
  `l_icon` varchar(500) DEFAULT NULL COMMENT '大图标',
  `s_icon` varchar(500) DEFAULT NULL COMMENT '小图标',
  `link_url` varchar(255) DEFAULT NULL COMMENT '商品链接地址',
  `buys` int(11) DEFAULT NULL COMMENT '商品购买数',
  `del_flag` tinyint(4) DEFAULT NULL COMMENT '删除标记,1=已删除，0=未删除',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifytime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '20220455601', '千百惠海贝衣香丽影款2013夏装新款正品淑女装蕾丝雪纺短袖连衣裙', null, null, '2', null, '40', '120', '120', '5', '6', ',,http://i03.c.aliimg.com/img/ibank/2013/939/349/815943939_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/149/349/815943941_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/349/349/815943943_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/467/849/815948764_748786497.jpg,http://i05.c.aliimg.com/img/ibank/2013/449/349/815943944_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/649/349/815943946_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/849/349/815943948_748786497.jpg,http://i05.c.aliimg.com/img/ibank/2013/059/349/815943950_748786497.jpg,http://i03.c.aliimg.com/img/ibank/2013/939/349/815943939_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/149/349/815943941_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/349/349/815943943_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/467/849/815948764_748786497.jpg,http://i05.c.aliimg.com/img/ibank/2013/449/349/815943944_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/649/349/815943946_748786497.jpg,http://i01.c.aliimg.com/img/ibank/2013/849/349/815943948_748786497.jpg,http://i05.c.aliimg.com/img/ibank/2013/059/349/815943950_748786497.jpg', '', '', null, null, null, null, '0', null, null, '千百惠 连衣裙', null, 'http://i01.c.aliimg.com/img/ibank/2013/349/349/815943943_748786497.jpg', 'http://img02.taobaocdn.com/bao/uploaded/i2/16767022501567085/T1UzN3XAlhXXXXXXXX_!!0-item_pic.jpg_sum.jpg', 'http://s.click.taobao.com/t?e=zGU34CA7K%2BPkqB07S4%2FK0CITy7klxxrJ35Nnc0lhsbQDgzA3p3W5ZrOMFSyVOhWPH%2FMbad7Nytg1VZI3qYGUpVgU0HhfdvqI0BhjFJdB8Lenag%3D%3D', '0', '0', '2013-09-02 12:46:44', '2013-09-02 13:18:49');

-- ----------------------------
-- Table structure for `t_goods_comm`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_comm`;
CREATE TABLE `t_goods_comm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品评论表',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '评论主题',
  `createtime` datetime DEFAULT NULL COMMENT '评论时间',
  `grade_img` varchar(500) DEFAULT NULL COMMENT '评分',
  `merit` varchar(500) DEFAULT NULL COMMENT '优点',
  `demerit` varchar(500) DEFAULT NULL COMMENT '缺点',
  `pro_comment` varchar(500) DEFAULT NULL COMMENT '商品评论全部',
  `img` varchar(500) DEFAULT NULL COMMENT '头像',
  `status` int(11) DEFAULT NULL COMMENT '状态，0=隐藏，1=显示',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods_comm
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=1013 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_menu` VALUES ('1002', '商品管理', '', '', '0', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1003', '商品分类列表', '', '/category/list.html', '1011', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1004', '新增商品分类', '', '/category/add.html', '1011', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1005', '品牌管理', '', '', '0', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1006', '品牌列表', '', '/brand/list.html', '1005', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1007', '新增品牌', '', '/brand/add.html', '1005', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1009', '商品列表', '', '/goods/list.html', '1002', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1010', '添加商品', '', '/goods/add.html', '1002', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1011', '商品分类', '', '', '0', '1', '1', '0');
INSERT INTO `t_menu` VALUES ('1012', '商品评论', '', '', '0', '1', '1', '0');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `ordertime` datetime DEFAULT NULL COMMENT '订单时间',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `product_integral` int(11) DEFAULT NULL COMMENT '商品积分',
  `product_price` double DEFAULT NULL COMMENT '商品价格',
  `order_count` int(11) DEFAULT NULL COMMENT '订单数量',
  `order_money` int(11) DEFAULT NULL COMMENT '订单金额',
  `order_pay` varchar(255) DEFAULT NULL COMMENT '支付方式',
  `order_distribution` varchar(255) DEFAULT NULL COMMENT '配送方式',
  `order_status` int(11) DEFAULT NULL COMMENT '支付状态',
  `order_uid` int(11) DEFAULT NULL COMMENT '订单用户ID',
  `order_freight` double DEFAULT NULL COMMENT '运费',
  `remark` varchar(255) DEFAULT NULL COMMENT ' 备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=1964 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_role_menu` VALUES ('1850', '1', '1');
INSERT INTO `t_role_menu` VALUES ('1851', '1', '2');
INSERT INTO `t_role_menu` VALUES ('1852', '1', '3');
INSERT INTO `t_role_menu` VALUES ('1853', '1', '22');
INSERT INTO `t_role_menu` VALUES ('1854', '1', '23');
INSERT INTO `t_role_menu` VALUES ('1855', '1', '24');
INSERT INTO `t_role_menu` VALUES ('1856', '1', '4');
INSERT INTO `t_role_menu` VALUES ('1857', '1', '5');
INSERT INTO `t_role_menu` VALUES ('1858', '1', '13');
INSERT INTO `t_role_menu` VALUES ('1859', '1', '14');
INSERT INTO `t_role_menu` VALUES ('1860', '1', '6');
INSERT INTO `t_role_menu` VALUES ('1861', '1', '7');
INSERT INTO `t_role_menu` VALUES ('1862', '1', '15');
INSERT INTO `t_role_menu` VALUES ('1863', '1', '16');
INSERT INTO `t_role_menu` VALUES ('1864', '1', '17');
INSERT INTO `t_role_menu` VALUES ('1932', '2', '88');
INSERT INTO `t_role_menu` VALUES ('1933', '2', '89');
INSERT INTO `t_role_menu` VALUES ('1934', '2', '1002');
INSERT INTO `t_role_menu` VALUES ('1935', '2', '1003');
INSERT INTO `t_role_menu` VALUES ('1936', '2', '1004');
INSERT INTO `t_role_menu` VALUES ('1937', '2', '1009');
INSERT INTO `t_role_menu` VALUES ('1938', '2', '1010');
INSERT INTO `t_role_menu` VALUES ('1939', '2', '1005');
INSERT INTO `t_role_menu` VALUES ('1940', '2', '1006');
INSERT INTO `t_role_menu` VALUES ('1941', '2', '1007');
INSERT INTO `t_role_menu` VALUES ('1942', '2', '1011');
INSERT INTO `t_role_menu` VALUES ('1943', '2', '1012');
INSERT INTO `t_role_menu` VALUES ('1944', '2', '1');
INSERT INTO `t_role_menu` VALUES ('1945', '2', '2');
INSERT INTO `t_role_menu` VALUES ('1946', '2', '3');
INSERT INTO `t_role_menu` VALUES ('1947', '2', '22');
INSERT INTO `t_role_menu` VALUES ('1948', '2', '23');
INSERT INTO `t_role_menu` VALUES ('1949', '2', '24');
INSERT INTO `t_role_menu` VALUES ('1950', '2', '4');
INSERT INTO `t_role_menu` VALUES ('1951', '2', '5');
INSERT INTO `t_role_menu` VALUES ('1952', '2', '13');
INSERT INTO `t_role_menu` VALUES ('1953', '2', '14');
INSERT INTO `t_role_menu` VALUES ('1954', '2', '6');
INSERT INTO `t_role_menu` VALUES ('1955', '2', '7');
INSERT INTO `t_role_menu` VALUES ('1956', '2', '15');
INSERT INTO `t_role_menu` VALUES ('1957', '2', '16');
INSERT INTO `t_role_menu` VALUES ('1958', '2', '17');
INSERT INTO `t_role_menu` VALUES ('1959', '2', '67');
INSERT INTO `t_role_menu` VALUES ('1960', '2', '79');
INSERT INTO `t_role_menu` VALUES ('1961', '2', '80');
INSERT INTO `t_role_menu` VALUES ('1962', '2', '81');
INSERT INTO `t_role_menu` VALUES ('1963', '2', '82');

-- ----------------------------
-- Table structure for `t_shop`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '商家名称',
  `shop_logo` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家LOGO',
  `shop_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家链接',
  `shop_info` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '商家描述',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `remark` text COLLATE utf8_bin,
  `coupons_use` text COLLATE utf8_bin COMMENT '优惠卷使用教程',
  `status` int(11) DEFAULT '1' COMMENT '状态,1=有效，2=无效',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_shop
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) unsigned NOT NULL COMMENT '用户编号',
  `account_name` varchar(20) NOT NULL COMMENT '帐户名称',
  `account_pwd` varchar(32) NOT NULL COMMENT '帐户密码',
  `email` varchar(100) NOT NULL,
  `roleid` tinyint(4) NOT NULL COMMENT '角色类型',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin@adplatform.com', '1', '', '系统管理员', '', null, '', '2013-06-02 17:43:46', '569f23c3263a46debb040a57236be222', '2013-08-20 01:10:37', '1');
INSERT INTO `t_user` VALUES ('2', 'spadmin', 'e10adc3949ba59abbe56e057f20f883e', 'spadmin@adplatform.com', '2', '', '运营管理员', '', null, '', '2013-07-08 00:12:45', '75ba559c3de242b08d2aac1daea621d6', '2013-09-02 13:34:00', '1');
