CREATE DATABASE finchhamburgueria;

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `conta` double DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`));

DROP TABLE IF EXISTS `ingrediente`;

CREATE TABLE `ingrediente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `ingrediente` VALUES (1,'alface',0.4),(2,'bacon',2),(3,'carne',3),(4,'ovo',0.8),(5,'queijo',1.5);


DROP TABLE IF EXISTS `lanche`;

CREATE TABLE `lanche` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `lanche` VALUES (1,'xBacon',6.5),(2,'xBurguer',4.5),(3,'xEgg',5.3),(4,'xEggBacon',7.3);


DROP TABLE IF EXISTS `lanche_ingredientes`;

CREATE TABLE `lanche_ingredientes` (
  `lanche_id` int NOT NULL,
  `ingrediente_id` int NOT NULL,
  KEY `FK9ne1woex2e4q7ci06q9l4f6fv` (`ingrediente_id`),
  KEY `FK82gisnc8cn4hod4bxxwm7wiu8` (`lanche_id`),
  CONSTRAINT `FK82gisnc8cn4hod4bxxwm7wiu8` FOREIGN KEY (`lanche_id`) REFERENCES `lanche` (`id`),
  CONSTRAINT `FK9ne1woex2e4q7ci06q9l4f6fv` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingrediente` (`id`));

INSERT INTO `lanche_ingredientes` VALUES (1,2),(1,3),(1,5),(2,3),(2,5),(3,4),(3,3),(3,5),(4,4),(4,2),(4,3),(4,5);


DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `preco_pedido` double DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id`),
  CONSTRAINT `FK30s8j2ktpay6of18lbyqn3632` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`));


DROP TABLE IF EXISTS `pedido_lanches`;

CREATE TABLE `pedido_lanches` (
  `pedido_id` int NOT NULL,
  `lanche_id` int NOT NULL,
  KEY `FKtr1x3tmryupuyamg490n544hg` (`lanche_id`),
  KEY `FKd3tn36knwrenhbm98syh7xqos` (`pedido_id`),
  CONSTRAINT `FKd3tn36knwrenhbm98syh7xqos` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FKtr1x3tmryupuyamg490n544hg` FOREIGN KEY (`lanche_id`) REFERENCES `lanche` (`id`));