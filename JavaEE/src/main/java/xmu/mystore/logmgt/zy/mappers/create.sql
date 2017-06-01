CREATE TABLE `142550_log_info` (
  `log_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(30) NOT NULL DEFAULT '0',
  `op_time` bigint(30) NOT NULL,
  `op_object` varchar(45) NOT NULL,
  `op_method` varchar(45) NOT NULL,
  `op_content` varchar(45) NOT NULL,
  `result` tinyint(4) NOT NULL,
  `ip_address` varchar(45) DEFAULT 'unknown',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

