CREATE TABLE `logging_event_property` (
`event_id` bigint(20) NOT NULL COMMENT '日志事件的数据库 id',
`mapped_key` varchar(254) NOT NULL COMMENT 'MDC 属性的 key',
`mapped_value` text COMMENT 'MDC 属性的 value',
PRIMARY KEY (`event_id`,`mapped_key`),
CONSTRAINT `logging_event_property_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;