CREATE TABLE `request_api_log_tbl` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请求日志表id',
`service` varchar(20) NOT NULL COMMENT '服务',
`port` int(11) NOT NULL COMMENT '端口',
`controller` varchar(255) NOT NULL COMMENT '请求控制器',
`method` varchar(255) NOT NULL COMMENT '请求方法',
`code` varchar(10) NOT NULL COMMENT '返回编码(00：请求成功,99：系统异常，10：参数异常，11：未授权，66：业务友好提示)',
`input` text COMMENT '输入信息',
`output` text COMMENT '输出信息',
`description` varchar(255) DEFAULT NULL COMMENT '描述',
`operate_user` varchar(255) NOT NULL COMMENT '操作人',
`request_time` datetime NOT NULL COMMENT '请求时间',
`response_time` datetime NOT NULL COMMENT '响应时间',
`timeout` decimal(16,2) NOT NULL COMMENT '耗时(秒)',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='请求日志表';