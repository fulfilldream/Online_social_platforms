/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.39 : Database - forum_sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`forum_sys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `forum_sys`;

/*Table structure for table `about` */

DROP TABLE IF EXISTS `about`;

CREATE TABLE `about` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关于我们ID',
  `cellphone` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `creat_date` varchar(255) DEFAULT NULL COMMENT '成立时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `introduce` varchar(2000) DEFAULT NULL COMMENT '简介',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `about` */

insert  into `about`(`id`,`cellphone`,`email`,`address`,`creat_date`,`status`,`introduce`,`img`,`name`) values (2,'13122892145','54188@qq.com','在线社交平台','2025-03-14',1,'在线社交平台','http://localhost:8088/images/20250206-105627-F6F19482F620.jpg','在线社交平台');

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小组加入ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `groups_id` int(11) DEFAULT NULL COMMENT '小组ID',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `groups_id` (`groups_id`),
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `apply_ibfk_2` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `apply` */

insert  into `apply`(`id`,`user_id`,`groups_id`) values (3,6,4);

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
  `user_id` int(11) DEFAULT NULL COMMENT '发布者ID',
  `creat_time` datetime DEFAULT NULL COMMENT '发布时间',
  `img` varchar(255) DEFAULT NULL COMMENT '展示图',
  `article_type_id` int(11) DEFAULT NULL COMMENT '类型ID',
  `read_count` int(11) DEFAULT '0' COMMENT '浏览量',
  `collect_count` int(11) DEFAULT '0' COMMENT '收藏量',
  `groups_id` int(11) DEFAULT NULL COMMENT '小组ID',
  `status` int(2) DEFAULT '0' COMMENT '审核状态',
  `opinion` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `like_count` int(11) DEFAULT '0' COMMENT '点赞量',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `article_type_id` (`article_type_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`article_type_id`) REFERENCES `article_type` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`,`summary`,`user_id`,`creat_time`,`img`,`article_type_id`,`read_count`,`collect_count`,`groups_id`,`status`,`opinion`,`like_count`) values (1,'瑞典警方称厄勒布鲁市校园枪击事件已造成约10人死亡','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p>','瑞典警方称厄勒布鲁市校园枪击事件已造成约10人死亡',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144646-16CE7CCB85EB.jpg',1,0,0,1,1,NULL,0),(2,'瑞典警方称厄勒布鲁市校园枪击事件已造成约10人死亡','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p>','瑞典警方称厄勒布鲁市校园枪击事件已造成约10人死亡',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144803-98CCED6E4D8D.jpg',7,0,0,3,1,NULL,0),(3,'开学第一课 守护在校园','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144656-E8A2BC623753.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','开学第一课 守护在校园',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144659-47B107475C24.jpg',7,1,0,3,1,NULL,0),(4,'校园枪击案已造成11人死亡！瑞典首相发声','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144656-E8A2BC623753.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','校园枪击案已造成11人死亡！瑞典首相发声',6,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144718-DEE34A6001A3.jpg',5,1,0,2,1,NULL,0),(5,'山东教师的寒假日记｜王焕涛：校园里的温暖与希望','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144656-E8A2BC623753.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','山东教师的寒假日记｜王焕涛：校园里的温暖与希望',6,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144728-81045BE17DE9.jpg',4,2,0,2,1,NULL,0),(6,'瑞典厄勒布鲁校园枪击案已造成11人死亡','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144656-E8A2BC623753.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','瑞典厄勒布鲁校园枪击案已造成11人死亡',6,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144738-1924A8126F88.jpg',2,1,0,1,1,NULL,0),(7,'走进家门，打开学生“心门” 丨新春走基层','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144656-E8A2BC623753.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','走进家门，打开学生“心门” 丨新春走基层',6,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144752-E5E567AA0E05.jpg',1,10,1,1,1,NULL,1);

/*Table structure for table `article_collect` */

DROP TABLE IF EXISTS `article_collect`;

CREATE TABLE `article_collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章收藏ID',
  `article_id` int(11) DEFAULT NULL COMMENT '文章ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `article_collect_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_collect_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `article_collect` */

insert  into `article_collect`(`id`,`article_id`,`user_id`) values (2,7,2);

/*Table structure for table `article_comment` */

DROP TABLE IF EXISTS `article_comment`;

CREATE TABLE `article_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题讨论ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `article_id` int(11) DEFAULT NULL COMMENT '问题ID',
  `content` varchar(255) DEFAULT NULL COMMENT '讨论内容',
  `creat_time` datetime DEFAULT NULL COMMENT '讨论时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `article_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_comment_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `article_comment` */

insert  into `article_comment`(`id`,`user_id`,`article_id`,`content`,`creat_time`) values (4,2,7,'6666666666','2025-03-15 18:31:16');

/*Table structure for table `article_like` */

DROP TABLE IF EXISTS `article_like`;

CREATE TABLE `article_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作品点赞ID',
  `article_id` int(11) DEFAULT NULL COMMENT '作品ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `article_like_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_like_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `article_like` */

insert  into `article_like`(`id`,`article_id`,`user_id`) values (11,7,2);

/*Table structure for table `article_type` */

DROP TABLE IF EXISTS `article_type`;

CREATE TABLE `article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章类型ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `describes` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `article_type` */

insert  into `article_type`(`id`,`name`,`describes`) values (1,'兴趣分享','兴趣分享'),(2,'生活交流','生活交流'),(3,'军事发展','军事发展'),(4,'游戏探讨','游戏探讨'),(5,'趣事分享','趣事分享'),(6,'学习交流','学习交流'),(7,'成长故事','成长故事');

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '轮播图ID',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` tinyint(1) DEFAULT '0' COMMENT '是否展示',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

insert  into `banner`(`id`,`img`,`status`,`name`,`introduce`) values (1,'http://localhost:8088/images/20250206-105618-BE8919BD5AFB.jpg',1,'轮播图','轮播图'),(2,'http://localhost:8088/images/20250206-105610-42E496153971.jpg',1,'轮播图','轮播图');

/*Table structure for table `follow` */

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `follow_user_id` int(11) DEFAULT NULL COMMENT '关注对象ID',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `follow_user_id` (`follow_user_id`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`follow_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `follow` */

/*Table structure for table `groups` */

DROP TABLE IF EXISTS `groups`;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小组ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `img` varchar(255) DEFAULT NULL COMMENT '展示图',
  `content` text COMMENT '内容',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(2) DEFAULT '0' COMMENT '审核状态',
  `opinion` varchar(255) DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `groups` */

insert  into `groups`(`id`,`user_id`,`name`,`label`,`img`,`content`,`creat_time`,`status`,`opinion`) values (1,2,'好物交流小组','好物交流小组','http://localhost:8088/images/20250217-225817-0CB421F1889B.jpg','<p>数学小组<span style=\"display: inline !important;\">数学小组</span><span style=\"display: inline !important;\">数学小组</span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\"><img src=\"http://localhost:8088/images/20250217-225825-40B942D5A27E.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></span></p>','2025-03-14 22:58:27',1,'1'),(2,6,'军事讨论小组','军事讨论小组','http://localhost:8088/images/20250217-225833-08D174FDC484.jpg','<p>数学小组<span style=\"display: inline !important;\">数学小组</span><span style=\"display: inline !important;\">数学小组</span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\"><img src=\"http://localhost:8088/images/20250217-225825-40B942D5A27E.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></span></p>','2025-03-14 22:58:27',1,'1'),(3,6,'历史探索小组','历史探索小组','http://localhost:8088/images/20250217-225841-68C5A4EECBB1.jpg','<p>数学小组<span style=\"display: inline !important;\">数学小组</span><span style=\"display: inline !important;\">数学小组</span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\">数学小组数学小组数学小组<br/></span></p><p><span style=\"display: inline !important;\"><img src=\"http://localhost:8088/images/20250217-225825-40B942D5A27E.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></span></p>','2025-03-14 22:58:27',1,'1'),(4,2,'校园分享小组','校园分享小组','http://localhost:8088/images/20250217-230842-379FB8CCF992.jpg','<p>测试小组</p>','2025-03-14 22:58:27',1,'111111');

/*Table structure for table `groups_comment` */

DROP TABLE IF EXISTS `groups_comment`;

CREATE TABLE `groups_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小组交流ID',
  `groups_id` int(11) DEFAULT NULL COMMENT '小组ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `content` varchar(255) DEFAULT NULL COMMENT '交流内容',
  `creat_time` datetime DEFAULT NULL COMMENT '交流时间',
  `types` int(2) DEFAULT '0' COMMENT '类型',
  PRIMARY KEY (`id`),
  KEY `groups_id` (`groups_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `groups_comment_ibfk_1` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE,
  CONSTRAINT `groups_comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `groups_comment` */

insert  into `groups_comment`(`id`,`groups_id`,`user_id`,`content`,`creat_time`,`types`) values (12,4,2,'6666666','2025-03-15 18:14:32',0),(13,4,2,'66666666','2025-03-15 18:26:18',0),(14,3,2,'66666','2025-03-15 18:30:35',0);

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
  `user_id` int(11) DEFAULT NULL COMMENT '发布者ID',
  `creat_time` datetime DEFAULT NULL COMMENT '时间',
  `img` varchar(255) DEFAULT NULL COMMENT '展示图',
  `read_count` int(11) DEFAULT '0' COMMENT '浏览量',
  `like_count` int(11) DEFAULT '0' COMMENT '点赞量',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `information_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`id`,`title`,`content`,`summary`,`user_id`,`creat_time`,`img`,`read_count`,`like_count`) values (1,'校园枪击案已造成11人死亡！瑞典首相发声','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144349-39967E683AD0.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','校园枪击案已造成11人死亡！瑞典首相发声',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144340-41DD3E9E1478.jpg',5,6),(2,'开学第一课 守护在校园','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144349-39967E683AD0.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','开学第一课 守护在校园',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144403-C03EAC652F99.jpg',1,1),(3,'瑞典校园枪击案造成约10人死亡','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144349-39967E683AD0.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','瑞典校园枪击案造成约10人死亡',6,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144417-BE4CB1F6D8CA.jpg',1,0),(4,'山东教师的寒假日记｜王焕涛：校园里的温暖与希望','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144349-39967E683AD0.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','山东教师的寒假日记｜王焕涛：校园里的温暖与希望',6,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144428-8A93E0D86658.jpg',1,0),(5,'市15中入选省级“校园体育实验班”','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144349-39967E683AD0.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','市15中入选省级“校园体育实验班”',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144441-88D6782B1B34.jpg',2,0),(6,'走进家门，打开学生“心门” 丨新春走基层','<p>总台记者当地时间2月4日获悉,瑞典警方称该国厄勒布鲁市一学校发生的枪击事件已造成约10人死亡。</p><p>据悉,这所学校是一个成人教育学校。死者均在校园内被发现,警方目前正在确认死者身份,目前尚未提供任何有关受害者的详细信息,且无法提供确切的死亡或受伤人数。</p><p>警方在当天的新闻发布会上证实,他们已经找到了枪击案嫌疑人,枪手是死者之一。警方表示肇事者很可能是单独行动,但是不排除有多人参与或情况可能发生变化。</p><p>瑞典首相:史上最严重的大规模枪击案</p><p>当天晚上,瑞典首相克里斯特松和司法大臣斯特勒默召开新闻发布会。</p><p>克里斯特松表示,这起校园枪击案是瑞典历史上最严重的大规模枪击案。他还呼吁公众给予警方调查和处理校园枪击案的空间。</p><p>斯特勒默也称这是“瑞典发生的最严重的大规模枪击事件”,并表示会定期收到警方的最新消息。(总台记者 郝晓丽)</p><p><img src=\"http://localhost:8088/images/20250206-144349-39967E683AD0.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>','走进家门，打开学生“心门” 丨新春走基层',2,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144453-7E62525C4F33.jpg',7,0);

/*Table structure for table `information_comment` */

DROP TABLE IF EXISTS `information_comment`;

CREATE TABLE `information_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态评论ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `information_id` int(11) DEFAULT NULL COMMENT '动态ID',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `creat_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `information_id` (`information_id`),
  CONSTRAINT `information_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `information_comment_ibfk_2` FOREIGN KEY (`information_id`) REFERENCES `information` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `information_comment` */

insert  into `information_comment`(`id`,`user_id`,`information_id`,`content`,`creat_time`) values (22,2,6,'66666','2025-03-15 18:24:27'),(23,2,2,'66666','2025-03-15 18:31:31');

/*Table structure for table `information_like` */

DROP TABLE IF EXISTS `information_like`;

CREATE TABLE `information_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态点赞ID',
  `information_id` int(11) DEFAULT NULL COMMENT '动态ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`),
  KEY `information_id` (`information_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `information_like_ibfk_1` FOREIGN KEY (`information_id`) REFERENCES `information` (`id`) ON DELETE CASCADE,
  CONSTRAINT `information_like_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `information_like` */

insert  into `information_like`(`id`,`information_id`,`user_id`) values (9,2,2);

/*Table structure for table `leaves` */

DROP TABLE IF EXISTS `leaves`;

CREATE TABLE `leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '私信ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `content` varchar(255) DEFAULT NULL COMMENT '私信内容',
  `creat_time` datetime DEFAULT NULL COMMENT '私信时间',
  `reply_con` varchar(255) DEFAULT NULL COMMENT '回复内容',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `staff_id` int(11) DEFAULT NULL COMMENT '私信对象ID',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `staff_id` (`staff_id`),
  CONSTRAINT `leaves_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `leaves_ibfk_2` FOREIGN KEY (`staff_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `leaves` */

insert  into `leaves`(`id`,`user_id`,`content`,`creat_time`,`reply_con`,`reply_time`,`staff_id`) values (2,2,'发送私信发送私信发送私信','2025-03-15 18:18:04','11111111','2025-03-15 18:26:12',2),(3,2,'发送私信发送私信发送私信发送私信','2025-03-15 18:30:57','信回复信回复信回复','2025-03-15 18:32:24',2),(4,2,'发送私信发送私信发送私信','2025-03-15 18:32:16',NULL,NULL,1);

/*Table structure for table `links` */

DROP TABLE IF EXISTS `links`;

CREATE TABLE `links` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '友情链接ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `links` varchar(255) DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `links` */

insert  into `links`(`id`,`name`,`links`) values (3,'百度','https://www.baidu.com/?tn=88093251_132_hao_pg'),(4,'知乎','https://www.zhihu.com/signin?next=%2F');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
  `user_id` int(11) DEFAULT NULL COMMENT '发布者ID',
  `creat_time` datetime DEFAULT NULL COMMENT '时间',
  `img` varchar(255) DEFAULT NULL COMMENT '展示图',
  `read_count` int(11) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`title`,`content`,`summary`,`user_id`,`creat_time`,`img`,`read_count`) values (1,'山西祁县：志愿服务进校园 安全知识记心间','<p>本报讯 （记者秦海峰）近日，山西省晋中市祁县市场监管局在祁县第一小学开展新时代文明实践志愿服务进校园活动，为学校师生普及电梯及大型游乐设施安全知识，以进一步提升广大师生的安全意识。</p><p>活动中，志愿者通过安全事故警示图片、视频等，详细讲解电梯乘坐安全知识、如何正确使用电梯以及电梯发生故障后的应急救援等基本常识。志愿者还讲述了在大型游乐场游玩时应如何保护自身安全。现场问答环节，孩子们踊跃回答问题，提升了电梯及大型游乐设施相关安全知识水平。</p><p>祁县市场监管局相关负责人表示，此次活动提高了学生们对电梯及大型游乐设施的安全防范意识和自我保护意识。该局将持续开展多角度的安全知识宣传活动，营造“人人讲安全、安全为人人”良好氛围，切实保障群众生命财产安全。</p><p><img src=\"http://localhost:8088/images/20250206-144251-E16F509276DB.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"50%\"/></p>','山西祁县：志愿服务进校园 安全知识记心间',1,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144242-7DF5ABA26085.jpg',1),(2,'南华大学开展校园安全检查工作','<p>本报讯 （记者秦海峰）近日，山西省晋中市祁县市场监管局在祁县第一小学开展新时代文明实践志愿服务进校园活动，为学校师生普及电梯及大型游乐设施安全知识，以进一步提升广大师生的安全意识。</p><p>活动中，志愿者通过安全事故警示图片、视频等，详细讲解电梯乘坐安全知识、如何正确使用电梯以及电梯发生故障后的应急救援等基本常识。志愿者还讲述了在大型游乐场游玩时应如何保护自身安全。现场问答环节，孩子们踊跃回答问题，提升了电梯及大型游乐设施相关安全知识水平。</p><p>祁县市场监管局相关负责人表示，此次活动提高了学生们对电梯及大型游乐设施的安全防范意识和自我保护意识。该局将持续开展多角度的安全知识宣传活动，营造“人人讲安全、安全为人人”良好氛围，切实保障群众生命财产安全。</p><p><img src=\"http://localhost:8088/images/20250206-144251-E16F509276DB.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"50%\"/></p>','南华大学开展校园安全检查工作',1,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144306-8BBCF17BBB2B.jpg',2),(3,'曲阳县开展“党校思政”进校园活动','<p>本报讯 （记者秦海峰）近日，山西省晋中市祁县市场监管局在祁县第一小学开展新时代文明实践志愿服务进校园活动，为学校师生普及电梯及大型游乐设施安全知识，以进一步提升广大师生的安全意识。</p><p>活动中，志愿者通过安全事故警示图片、视频等，详细讲解电梯乘坐安全知识、如何正确使用电梯以及电梯发生故障后的应急救援等基本常识。志愿者还讲述了在大型游乐场游玩时应如何保护自身安全。现场问答环节，孩子们踊跃回答问题，提升了电梯及大型游乐设施相关安全知识水平。</p><p>祁县市场监管局相关负责人表示，此次活动提高了学生们对电梯及大型游乐设施的安全防范意识和自我保护意识。该局将持续开展多角度的安全知识宣传活动，营造“人人讲安全、安全为人人”良好氛围，切实保障群众生命财产安全。</p><p><img src=\"http://localhost:8088/images/20250206-144251-E16F509276DB.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"50%\"/></p>','曲阳县开展“党校思政”进校园活动',1,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144315-4FAEA2EB31EB.jpg',0),(4,'瑞典警方称厄勒布鲁市校园枪击事件已造成约10人死亡','<p>本报讯 （记者秦海峰）近日，山西省晋中市祁县市场监管局在祁县第一小学开展新时代文明实践志愿服务进校园活动，为学校师生普及电梯及大型游乐设施安全知识，以进一步提升广大师生的安全意识。</p><p>活动中，志愿者通过安全事故警示图片、视频等，详细讲解电梯乘坐安全知识、如何正确使用电梯以及电梯发生故障后的应急救援等基本常识。志愿者还讲述了在大型游乐场游玩时应如何保护自身安全。现场问答环节，孩子们踊跃回答问题，提升了电梯及大型游乐设施相关安全知识水平。</p><p>祁县市场监管局相关负责人表示，此次活动提高了学生们对电梯及大型游乐设施的安全防范意识和自我保护意识。该局将持续开展多角度的安全知识宣传活动，营造“人人讲安全、安全为人人”良好氛围，切实保障群众生命财产安全。</p><p><img src=\"http://localhost:8088/images/20250206-144251-E16F509276DB.jpg\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"50%\"/></p>','瑞典警方称厄勒布鲁市校园枪击事件已造成约10人死亡',1,'2025-03-14 15:08:00','http://localhost:8088/images/20250206-144327-347A492E096A.jpg',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `cellphone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `role` int(2) DEFAULT '0' COMMENT '角色',
  `avatar` varchar(255) DEFAULT 'http://localhost:8080/images/avatar.jpg' COMMENT '头像',
  `token` varchar(255) DEFAULT NULL COMMENT '令牌',
  `identity` varchar(255) DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`sex`,`email`,`cellphone`,`address`,`name`,`register_time`,`role`,`avatar`,`token`,`identity`) values (1,'admin','1','男','54188@qq.com','13979899419','测试地址','admin','2025-03-14 15:08:00',5,'http://localhost:8088/images/20250206-105558-36E95896F928.jpg','eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiIxMzk3OTg5OTQxOSJ9.Q72m7-xMWd2Hdm9iJYUZDkeyd5XKwBhruZ3BnZ3bz60',NULL),(2,'1','1','男','31232@qq.com','13122224444','测试地址','李四','2025-03-14 15:08:00',0,'http://localhost:8088/images/20250206-105312-B073D92CEE45.jpg','eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiIxMzEyMjIyNDQ0NCJ9.E1fvBnFhknwmQV-ybJhDyu68hf7dx6M9Sr1ZmZASf9Y','360521199802020030'),(6,'2','2','男','3123@qq.com','13122224444','测试地址','李峰','2025-03-14 15:08:00',0,'http://localhost:8088/images/20250206-143608-2D042E8B16BE.jpg','eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiIyIn0.zDRWFqhf09I18e2cJY-uEMkesImnz_jPZYO1H5lscSk','36052113123213123212');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
