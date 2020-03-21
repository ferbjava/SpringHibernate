DROP DATABASE IF EXISTS `spring_security_demo_plain`;

CREATE DATABASE IF NOT EXISTS `spring_security_demo_plain`;
USE `spring_security_demo_plain`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users`
VALUES
('john','{noop}test123',1),
('mary','{noop}test1234',1),
('susan','{noop}test12345',1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
	`username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1`(`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY(`username`) REFERENCES `users`(`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');