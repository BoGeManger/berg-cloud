CREATE TABLE `logging_event` (
`timestmp` bigint(20) NOT NULL COMMENT '日志事件的创建时间',
`formatted_message` text NOT NULL COMMENT '经过org.slf4j.impl.MessageFormatter 格式化后的消息',
`logger_name` varchar(254) NOT NULL COMMENT '发出日志的 logger 名',
`level_string` varchar(254) NOT NULL COMMENT '日志事件的级别',
`thread_name` varchar(254) DEFAULT NULL,
`reference_flag` smallint(6) DEFAULT NULL COMMENT '用来表示是否是异常或者与 MDC 属性相关联。它的值通过 ch.qos.logback.classic.db.DBHelper 计算得到。日志时间包含 MDC 或者 Context 时，它的值为 1。包含异常时，它的值为 2。包含两者，则值为 3。',
`arg0` varchar(254) DEFAULT NULL,
`arg1` varchar(254) DEFAULT NULL,
`arg2` varchar(254) DEFAULT NULL,
`arg3` varchar(254) DEFAULT NULL,
`caller_filename` varchar(254) NOT NULL COMMENT '发出日志请求的文件名',
`caller_class` varchar(254) NOT NULL COMMENT '发出日志请求的类',
`caller_method` varchar(254) NOT NULL COMMENT '发出日志请求的方法',
`caller_line` char(4) NOT NULL COMMENT '发出日志请求所在的行',
`event_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志事件在数据库的 id',
PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1898 DEFAULT CHARSET=utf8mb4;