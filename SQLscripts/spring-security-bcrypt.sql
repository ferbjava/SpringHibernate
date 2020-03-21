DROP DATABASE IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE IF NOT EXISTS `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(68) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users`
VALUES
('john','{bcrypt}$2y$10$7AkVjgD4Fq4/QdjfhWle/uQy1BkZNabmfrpkbZkh7NKt95K.MNIZK',1),
('mary','{bcrypt}$2y$10$csdNunVFU9lqoA0hYyPhUuVhyCRkHdf6zY3awJHAvxOHf9WQ3bx5G',1),
('susan','{bcrypt}$2y$10$YkjFPhk.R8z97Gje2hUZMOgs6tomTsq4gu3FBPY3qhE.QcVkQMeGu',1);

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