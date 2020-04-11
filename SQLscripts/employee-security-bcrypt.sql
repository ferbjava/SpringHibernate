DROP DATABASE IF EXISTS `employee_security`;

CREATE DATABASE IF NOT EXISTS `employee_security`;
USE `employee_security`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(68) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users`
VALUES
('john','{bcrypt}$2y$10$YFLJR0wQbuoVfT13adI/XuhIxeh.hclCMcbasfb4qxVBAfoctFYPe',1),
('mary','{bcrypt}$2y$10$Wg4YLJ4LHoJvDIyX6lVSoOOnJDmlQQeaJXIkxdWfdT6QulX.PbOKa',1),
('susan','{bcrypt}$2y$10$qZ0f0nwgb6cKxq7/LdAJI.hvZcmXYgsZpEa0LMCBL0/C4fhRlto.W',1);

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