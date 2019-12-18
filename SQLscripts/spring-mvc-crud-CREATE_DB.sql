CREATE DATABASE IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(48) DEFAULT NULL,
    `last_name` varchar(48) DEFAULT NULL,
    `email` varchar(48) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET = latin1;

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES
	(1, 'Adam', 'Nowak', 'a.nowak@gmail.com'),
	(2, 'Jan', 'Kowalski', 'j.kowalski@gmail.com'),
	(3, 'Krzysztof', 'Jarzyna', 'k.jarzyna@gmail.com'),
	(4, 'Roman', 'Giertych', 'r.giertych@gmail.com'),
	(5, 'Zdzislaw', 'Krecina', 'z.krecina@gmail.com');
    
UNLOCK TABLES;

