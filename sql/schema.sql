DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (

	id			BIGINT,
	name		VARCHAR	(255)	NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
)
ENGINE=INNODB;

CREATE TABLE `user` (

	id			BIGINT			AUTO_INCREMENT,
	guid		VARCHAR	(255)	NOT NULL UNIQUE,
	status		BIGINT,
	description VARCHAR (255),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`status`) REFERENCES `status`(`id`)
)
ENGINE=INNODB;