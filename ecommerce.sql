show databases;
create database ecommerce;
show databases;

use ecommerce;
CREATE TABLE eproduct 
(ID bigint primary key auto_increment, name varchar(100), price decimal(10,2), date_added timestamp default 
now());

INSERT INTO eproduct(name,price) values('HP Laptop ABC', 12000);
INSERT INTO eproduct(name,price) values('DELL PC ABC', 19000);
INSERT INTO eproduct(name,price) values('Samsung Laptop PQR', 22000);

SELECT * from eproduct;
SELECT * from eproduct where price > 15000;

use ecommerce;

DELIMITER $$
CREATE PROCEDURE add_product(IN pname varchar(100), IN pprice decimal(10,2))
INSERT INTO eproduct (name, price) VALUES (pname, pprice)
$$
DELIMITER ;

CALL `ecommerce`.`add_product`("HP Gmaong Laptop", 10000);





-- hibernate 

use ecommerce;

CREATE TABLE `colors` (
`ID` bigint(20) NOT NULL AUTO_INCREMENT,
`color_name` varchar(40) DEFAULT NULL,
`idx` int(11) DEFAULT NULL,
`product_id` bigint(20) DEFAULT NULL,
PRIMARY KEY (`ID`)
);

INSERT INTO `colors` VALUES (1,'Red',0,1),(2,'Silver',1,1),(3,'Gray',0,2),(4,'White',1,2),(5,'Maroon',0,3);

use ecommerce;
CREATE TABLE `screensizes` (
`ID` bigint(20) NOT NULL AUTO_INCREMENT,
`size` varchar(10) DEFAULT NULL,
`product_id` bigint(20) DEFAULT NULL,
PRIMARY KEY (`ID`)
) ;

INSERT INTO `screensizes` VALUES (1,'12 in',1),(2,'14.5 in',2),(3,'14.9 in',2),(4,'15.5 in',3);

 
use ecommerce;
CREATE TABLE `os` (
`ID` bigint(20) NOT NULL AUTO_INCREMENT,
`name` varchar(30) DEFAULT NULL,
`product_id` bigint(20) DEFAULT NULL,
PRIMARY KEY (`ID`)
);

INSERT INTO `os` VALUES (1,'Windows 10',1),(2,'Windows 10',2), (3,'FreeDOS',2),(4,'RedHat Linux',2),(5,'Windows 10',3);

 
use ecommerce;
CREATE TABLE `finance` (
`ID` bigint(20) NOT NULL AUTO_INCREMENT,
`ftype` varchar(10) DEFAULT NULL,
`name` varchar(30) DEFAULT NULL,
`product_id` bigint(20) DEFAULT NULL,
PRIMARY KEY (`ID`)
) ;

INSERT INTO `finance` VALUES (1,'CREDITCARD','EMI on Citibank Card',1),(3,'BANK','40% finance from SBI',2), (4,'BANK','60% finance from ICICI',3), (5,'BANK','20% finance from ICICI',1);



use ecommerce;

DROP TABLE IF EXISTS `eproduct`;
CREATE TABLE `eproduct` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parts_hdd` varchar(10) DEFAULT NULL,
  `parts_cpu` varchar(10) DEFAULT NULL,
  `parts_ram` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

INSERT INTO `eproduct` VALUES (1,'HP Laptop ABC',21900.00,'2019-06-04 07:18:57','2 Gb HDD','AMD Phenom','4 Gb'),(2,'Acer Laptop ABC',23300.00,'2019-06-04 07:19:07','500 Gb HDD','Core-i7','4 Gb'),(3,'Lenovo Laptop ABC',33322.00,'2019-06-04 07:19:19','1 Tb HDD','Core-i7','8 Gb');

USE ecommerce;
 CREATE TABLE eproduct (ID bigint primary key auto_increment, name varchar(100), price decimal(10,2), date_added timestamp default now()) ;
 INSERT INTO eproduct(name,price) values('HP Laptop ABC', 12000);
 INSERT INTO eproduct(name,price)values('Acer Laptop ABC', 14000);
 INSERT INTO eproduct(name,price)values('Lenovo Laptop ABC', 12000) ;
















