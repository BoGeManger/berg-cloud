CREATE TABLE `logging_event_exception` (
`event_id` bigint(20) NOT NULL COMMENT '日志事件的数据库 id',
`i` smallint(6) NOT NULL COMMENT '堆栈所在的行',
`trace_line` varchar(254) NOT NULL COMMENT '相对应的堆栈信息',
PRIMARY KEY (`event_id`,`i`),
CONSTRAINT `logging_event_exception_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;