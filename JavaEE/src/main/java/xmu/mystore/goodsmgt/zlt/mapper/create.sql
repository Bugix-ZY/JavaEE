CREATE TABLE `142550_brand` (
  `id` bigint(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `website` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `type` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `142550_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `upper_category_id` bigint(20) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT '0',
  `type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `upperCategoryId` (`upper_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


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


CREATE TABLE `142550_stand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL,
  `mid_user_price` double DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `real_price` double DEFAULT NULL,
  `on_market_time` datetime DEFAULT '2017-01-01 00:00:00',
  `off_market_time` datetime DEFAULT '2017-01-01 00:00:00',
  `pre_sale_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;