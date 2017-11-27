DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `guid` varchar(255) NOT NULL,
  `status` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `status_id` (`status`),
  FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
