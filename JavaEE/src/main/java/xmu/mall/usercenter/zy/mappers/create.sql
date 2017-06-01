CREATE TABLE `142550_useraddress` (
  `address_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(32) NOT NULL,
  `consignee` varchar(45) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `country` int(11) NOT NULL,
  `province` int(11) NOT NULL,
  `city` int(11) NOT NULL,
  `district` int(11) NOT NULL,
  `detail` varchar(45) NOT NULL,
  `is_default` tinyint(4) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `142550_usercollection` (
  `rec_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(32) NOT NULL,
  `goods_id` bigint(32) NOT NULL,
  `add_time` varchar(45) NOT NULL,
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;


CREATE TABLE `142550_user` (
  `user_id` bigint(32) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobile_phone` varchar(15) NOT NULL,
  `imagepath` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
