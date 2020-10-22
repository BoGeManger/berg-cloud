CREATE TABLE `operate_log_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统日志表id',
  `service` varchar(20) NOT NULL COMMENT '调用服务',
  `port` int(11) NOT NULL COMMENT '调用端口',
  `message` varchar(1000) DEFAULT NULL COMMENT '日志信息',
  `ext_field1` text COMMENT '详细日志信息',
  `ext_field2` text COMMENT '详细日志信息',
  `ext_field3` text COMMENT '详细日志信息',
  `operate_time` datetime NOT NULL COMMENT '操作时间',
  `operate_user` varchar(255) NOT NULL COMMENT '操作人',
  `type` varchar(10) NOT NULL COMMENT '日志类型(info error debug)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='系统日志表';