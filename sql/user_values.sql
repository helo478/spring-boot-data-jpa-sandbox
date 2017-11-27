INSERT INTO `user` (`guid`, `status`) 
	SELECT 'rick', `status`.`id` FROM `status` WHERE `status`.`name` = 'enabled';
    
INSERT INTO `user` (`guid`, `status`) 
	(SELECT 'morty', `status`.`id` FROM `status` WHERE `status`.`name` = 'disabled');