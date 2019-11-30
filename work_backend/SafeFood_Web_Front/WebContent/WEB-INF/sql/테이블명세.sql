create database safefood;

CREATE TABLE `food` (
  `code` int(11) NOT NULL COMMENT '코드',
  `name` varchar(45) NOT NULL COMMENT '이름',
  `supportpereat` double DEFAULT NULL COMMENT '일회제공량',
  `calory` double DEFAULT NULL COMMENT '칼로리',
  `carbo` double DEFAULT NULL COMMENT '탄수화물',
  `protein` double DEFAULT NULL COMMENT '단백질',
  `fat` double DEFAULT NULL COMMENT '지방',
  `sugar` double DEFAULT NULL COMMENT '당류',
  `natrium` double DEFAULT NULL COMMENT '나트륨',
  `chole` double DEFAULT NULL COMMENT '콜레스테롤',
  `fattyacid` double DEFAULT NULL COMMENT '포화지방산',
  `transfat` double DEFAULT NULL COMMENT '트렌스지방',
  `maker` varchar(45) DEFAULT NULL COMMENT '제조사',
  `material` varchar(500) DEFAULT NULL COMMENT '원료',
  `img` varchar(45) DEFAULT NULL COMMENT '이미지 경로',
  `hit` int(11) NOT NULL DEFAULT '0' COMMENT '조회수',
  PRIMARY KEY (`code`)
);

create table safeFoodMember(
   id varchar(30),
  pw varchar(30) not null,
  name varchar(30) not null,
  addr varchar(30),
  tel varchar(16),
  allergy text,
  primary key(id)
);

CREATE TABLE `boardmanager` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(30) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `document` varchar(500) DEFAULT NULL,
  `hit` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`num`)
);

create table searchlist(
	sname varchar(20),
    count int,
    primary key(sname)
);

CREATE TABLE `dibfood` (
  `id` char(30) NOT NULL,
  `code` int(11) NOT NULL,
  PRIMARY KEY (`id`,`code`),
  KEY `code` (`code`),
  CONSTRAINT `dibfood_ibfk_1` FOREIGN KEY (`id`) REFERENCES `safefoodmember` (`id`),
  CONSTRAINT `dibfood_ibfk_2` FOREIGN KEY (`code`) REFERENCES `food` (`code`)
);

CREATE TABLE `eatfood` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(30) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `cnt` int(11) DEFAULT NULL,
  `eatdate` datetime DEFAULT NULL,
  PRIMARY KEY (`num`),
  KEY `id` (`id`),
  KEY `code` (`code`),
  CONSTRAINT `eatfood_ibfk_1` FOREIGN KEY (`id`) REFERENCES `safefoodmember` (`id`),
  CONSTRAINT `eatfood_ibfk_2` FOREIGN KEY (`code`) REFERENCES `food` (`code`)
);

