drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,		
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
     PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_customer_id` INT NOT NULL,
    `date` DATETIME DEFAULT NOW(),
	FOREIGN KEY (`fk_customer_id`) REFERENCES customers(`id`),
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(30) UNIQUE NOT NULL,
	`quantity` INT NOT NULL,
	`price` DEC(10,2) NOT NULL,
	PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orderline` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fk_order_id` INT NULL DEFAULT NULL,
	`fk_item_id` INT NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fk_order_id`) REFERENCES orders(`id`),
	FOREIGN KEY (`fk_item_id`) REFERENCES items(`id`)
);
