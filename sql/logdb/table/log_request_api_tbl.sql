CREATE TABLE `log_request_api_tbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求日志表id',
  `service` varchar(20) NOT NULL COMMENT '服务',
  `port` int(11) NOT NULL COMMENT '端口',
  `controller` varchar(255) NOT NULL COMMENT '请求控制器',
  `method` varchar(255) NOT NULL COMMENT '请求方法',
  `input` text COMMENT '输入信息',
  `output` text COMMENT '输出信息',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `operate_user` varchar(255) NOT NULL COMMENT '操作人',
  `operate_time` datetime NOT NULL COMMENT '操作时间',
  `code` varchar(10) NOT NULL COMMENT '返回编码(00：请求成功,99：系统异常，10：参数异常，11：未授权，66：业务友好提示)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='请求日志表';