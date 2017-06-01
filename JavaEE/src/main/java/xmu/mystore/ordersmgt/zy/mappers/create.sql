
CREATE TABLE `142550_order_goods` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(32) NOT NULL,
  `goods_id` bigint(32) NOT NULL,
  `goods_name` varchar(45) NOT NULL,
  `goods_number` int(11) NOT NULL,
  `goods_price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;


CREATE TABLE `142550_order_info` (
  `order_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(45) NOT NULL,
  `user_id` bigint(32) NOT NULL,
  `order_status` int(11) NOT NULL,
  `consignee` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `zipcode` varchar(6) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `total_weight` double DEFAULT NULL,
  `sigature_characters` varchar(256) DEFAULT NULL,
  `add_time` bigint(32) DEFAULT '0',
  `pay_time` bigint(32) DEFAULT '0',
  `make_time` bigint(32) DEFAULT '0',
  `shipped_time` bigint(32) DEFAULT '0',
  `receive_time` bigint(32) DEFAULT '0',
  `cancel_time` bigint(32) DEFAULT NULL,
  `expressCode` varchar(45) DEFAULT NULL,
  `isUrgency` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_sn_UNIQUE` (`order_sn`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;


CREATE TABLE `142550_user` (
  `user_id` bigint(32) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobile_phone` varchar(15) NOT NULL,
  `imagepath` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `142550_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `serial_code` varchar(40) NOT NULL,
  `weight` double(12,0) unsigned zerofill DEFAULT NULL,
  `stock_count` int(11) unsigned zerofill DEFAULT '00000000000',
  `pre_sale_number` int(11) unsigned zerofill DEFAULT '00000000000',
  `store_id` varchar(40) DEFAULT NULL,
  `mid_user_price` double(12,0) unsigned zerofill DEFAULT '000000000000',
  `market_price` double(12,0) unsigned zerofill DEFAULT '000000000000',
  `real_price` double(12,0) unsigned zerofill DEFAULT '000000000000',
  `redeem_point` int(11) DEFAULT '0',
  `category_id` bigint(11) DEFAULT NULL,
  `brand_id` bigint(11) DEFAULT NULL,
  `stand_id` bigint(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `last_modified_time` datetime DEFAULT NULL,
  `description` longtext,
  `image_path` varchar(999) DEFAULT NULL,
  `is_dividable` tinyint(1) DEFAULT '0',
  `default_express` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serialCode` (`serial_code`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;
