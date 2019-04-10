CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '名字',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` bit(1) DEFAULT NULL COMMENT '性别。1->男 0->女',
  `work_age` int(2) DEFAULT NULL COMMENT '工作年限',
  `last_login` timestamp(6) NULL DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';