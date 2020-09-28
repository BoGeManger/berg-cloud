CREATE TABLE `res_application_api_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求应用接口表id',
  `app_id` int(11) NOT NULL COMMENT '请求应用表id',
  `api_id` int(11) NOT NULL COMMENT '请求接口表id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '创建用户',
  `del_time` datetime DEFAULT NULL COMMENT '删除时间',
  `del_user` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '删除用户',
  `isdel` tinyint(5) unsigned zerofill NOT NULL COMMENT '是否删除(0 否,1 是)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='请求应用接口表';