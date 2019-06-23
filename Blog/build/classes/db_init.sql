-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: myblog
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.16.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_article`
--

DROP TABLE IF EXISTS `t_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) NOT NULL,
  `author` varchar(30) NOT NULL,
  `sort` varchar(30) NOT NULL,
  `time` datetime DEFAULT '2019-04-20 00:00:00',
  `star` int(11) DEFAULT '0',
  `visit` int(11) DEFAULT '0',
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_tag`
--

DROP TABLE IF EXISTS `t_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tag` (
  `id` int(11) DEFAULT NULL,
  `tag` varchar(30) DEFAULT NULL,
  KEY `id` (`id`),
  CONSTRAINT `t_tag_ibfk_1` FOREIGN KEY (`id`) REFERENCES `t_article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary_key',
  `user_name` varchar(20) NOT NULL COMMENT 'username',
  `user_password` varchar(20) NOT NULL COMMENT 'password',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_visitor`
--

DROP TABLE IF EXISTS `t_visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `web_ip` varchar(50) DEFAULT NULL,
  `host` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
