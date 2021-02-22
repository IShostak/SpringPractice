DROP DATABASE  IF EXISTS `spring_security_demo_bcrypt`;

CREATE DATABASE  IF NOT EXISTS `spring_security_demo_bcrypt`;
USE `spring_security_demo_bcrypt`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$10$0VfTwgfYj/eZvFmVnsZ1n.ReKMhF9.cpcvm7sPJqGnWl1xm9R9AMS',1),
('mary','{bcrypt}$2a$10$QFJY3DJ.evigBeOwbFyAKOBkWwajFcR6I42818VNGGfsHDE.JQMse',1),
('susan','{bcrypt}$2a$10$OSGSvUpZfAFgEuGiVrdUmOMsMfSyZOMtS2BYrr6fF2V.fQM6n5Axy',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');


