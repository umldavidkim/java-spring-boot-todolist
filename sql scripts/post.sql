CREATE DATABASE  IF NOT EXISTS `post_directory`;
USE `post_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `priority` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `post`
--

INSERT INTO `post` VALUES 
	(1,'Wash the car','low'),
	(2,'Clean out the basement','low'),
	(3,'Buy groceries for the week','high'),
	(4,'Write a Springboot application','medium'),
	(5,'Go fishing and relax','high');

