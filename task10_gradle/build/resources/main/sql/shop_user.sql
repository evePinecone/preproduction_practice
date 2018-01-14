
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES (1,'qweqwe','qwe@qwe.qwe','+380996659205','qweQWE123'),(11,'inc','inc@inc.inc','+000000000000','qweQWE123'),(20,'asd','qwe@qwe.qwe','+222222222222','qweQWE123'),(21,'asd','qwe@qwe.qwe','+222222222223','qweQWE123');



-- Dump completed on 2018-01-12 17:22:08
