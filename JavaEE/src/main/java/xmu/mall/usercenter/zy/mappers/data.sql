/*
-- Query: SELECT * FROM JavaEE.142550_useraddress
LIMIT 0, 1000

-- Date: 2017-06-01 20:22
*/

INSERT INTO `142550_useraddress` (`address_id`,`user_id`,`consignee`,`zipcode`,`country`,`province`,`city`,`district`,`detail`,`is_default`,`telephone`) VALUES (1,1,'郑洋','361005',86,21,21,21,'厦门大学学生公寓',1,'13012345678');
INSERT INTO `142550_useraddress` (`address_id`,`user_id`,`consignee`,`zipcode`,`country`,`province`,`city`,`district`,`detail`,`is_default`,`telephone`) VALUES (9,1,'郑洋','361005',86,21,21,21,'厦大学生公寓',0,'15000000001');


INSERT INTO `142550_usercollection` (`rec_id`,`user_id`,`goods_id`,`add_time`) VALUES (164,1,120,'2017-05-31 04:10:52');
INSERT INTO `142550_usercollection` (`rec_id`,`user_id`,`goods_id`,`add_time`) VALUES (167,1,28,'2017-05-31 08:44:40');
INSERT INTO `142550_usercollection` (`rec_id`,`user_id`,`goods_id`,`add_time`) VALUES (168,1,55,'2017-05-31 08:44:43');


/*
-- Query: SELECT * FROM JavaEE.142550_user
LIMIT 0, 1000

-- Date: 2017-06-01 20:22
*/

INSERT INTO `142550_user` (`user_id`,`user_name`,`password`,`mobile_phone`,`imagepath`) VALUES (1,'新的','134789','13817583728',NULL);
INSERT INTO `142550_user` (`user_id`,`user_name`,`password`,`mobile_phone`,`imagepath`) VALUES (2,'Nick','189673','15673237555',NULL);
INSERT INTO `142550_user` (`user_id`,`user_name`,`password`,`mobile_phone`,`imagepath`) VALUES (3,'Ironman','987654','18688772345',NULL);
INSERT INTO `142550_user` (`user_id`,`user_name`,`password`,`mobile_phone`,`imagepath`) VALUES (552,'batsman','654321','17639248575',NULL);
INSERT INTO `142550_user` (`user_id`,`user_name`,`password`,`mobile_phone`,`imagepath`) VALUES (2550,'郑洋','123456','15000588578',NULL);
