CREATE TABLE `res_application_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求应用表id',
  `name` varchar(20) NOT NULL COMMENT '应用名称',
  `secret` varchar(120) NOT NULL COMMENT '密钥',
  `remark` varchar(255) DEFAULT NULL COMMENT '应用描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建用户',
  `modify_time` datetime NOT NULL COMMENT '更新时间',
  `modify_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '修改用户',
  `del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) unsigned zerofill NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='请求应用表';