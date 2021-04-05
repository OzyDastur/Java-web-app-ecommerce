/** ========== Create Schema ourstore ==============*/
CREATE SCHEMA IF NOT EXISTS `ourstore` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

/** ========== user Table ==============*/
CREATE TABLE `ourstore`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) NULL DEFAULT NULL,
  `firstName` VARCHAR(50) NULL DEFAULT NULL,
  `middleName` VARCHAR(50) NULL DEFAULT NULL,
  `lastName` VARCHAR(50) NULL DEFAULT NULL,
  `mobile` VARCHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(32) NOT NULL,
  `registeredAt` DATETIME NOT NULL,
  `profile` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uq_mobile` (`mobile` ASC),
  UNIQUE INDEX `uq_email` (`email` ASC) );
  

  /** ========== product Table ==============*/
  CREATE TABLE `ourstore`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(75) NOT NULL,
  `pictureId` VARCHAR(100) NULL,
  `sku` VARCHAR(100) NOT NULL,
  `price` FLOAT NOT NULL DEFAULT 0,
  `discount` FLOAT NOT NULL DEFAULT 0,
  `quantity` SMALLINT(6) NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
  );

/**  SET foreign_key_checks = 0; */
/**  SET foreign_key_checks = 1; */

/** ========== product_review Table ==============*/
CREATE TABLE `ourstore`.`product_review` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `productId` BIGINT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `rating` SMALLINT(6) NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `publishedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_review_product` (`productId` ASC),
  CONSTRAINT `fk_review_product`
    FOREIGN KEY (`productId`)
    REFERENCES `ourstore`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


    
 /** ========== cart Table ==============*/    
CREATE TABLE `ourstore`.`cart` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userId` BIGINT NULL DEFAULT NULL,
  `sessionId` VARCHAR(100) NOT NULL,
  `token` VARCHAR(100) NOT NULL,
  `status` SMALLINT(6) NOT NULL DEFAULT 0,
  `firstName` VARCHAR(50) NULL DEFAULT NULL,
  `middleName` VARCHAR(50) NULL DEFAULT NULL,
  `lastName` VARCHAR(50) NULL DEFAULT NULL,
  `mobile` VARCHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  `line1` VARCHAR(50) NULL DEFAULT NULL,
  `line2` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `province` VARCHAR(50) NULL DEFAULT NULL,
  `country` VARCHAR(50) NULL DEFAULT NULL,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_cart_user` (`userId` ASC),
  CONSTRAINT `fk_cart_user`
    FOREIGN KEY (`userId`)
    REFERENCES `ourstore`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
/** ========== cart item Table ==============*/     
CREATE TABLE `ourstore`.`cart_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `productId` BIGINT NOT NULL,
  `cartId` BIGINT NOT NULL,
  `sku` VARCHAR(100) NOT NULL,
  `price` FLOAT NOT NULL DEFAULT 0,
  `discount` FLOAT NOT NULL DEFAULT 0,
  `quantity` SMALLINT(6) NOT NULL DEFAULT 0,
  `active` TINYINT(1) NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_cart_item_product` (`productId` ASC),
  CONSTRAINT `fk_cart_item_product`
    FOREIGN KEY (`productId`)
    REFERENCES `ourstore`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `ourstore`.`cart_item` 
ADD INDEX `idx_cart_item_cart` (`cartId` ASC);
ALTER TABLE `ourstore`.`cart_item` 
ADD CONSTRAINT `fk_cart_item_cart`
  FOREIGN KEY (`cartId`)
  REFERENCES `ourstore`.`cart` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  /** ========== order Table ==============*/ 
CREATE TABLE `ourstore`.`orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userId` BIGINT NULL DEFAULT NULL,
  `sessionId` VARCHAR(100) NOT NULL,
  `token` VARCHAR(100) NOT NULL,
  `status` SMALLINT(6) NOT NULL DEFAULT 0,
  `subTotal` FLOAT NOT NULL DEFAULT 0,
  `itemDiscount` FLOAT NOT NULL DEFAULT 0,
  `tax` FLOAT NOT NULL DEFAULT 0,
  `shipping` FLOAT NOT NULL DEFAULT 0,
  `total` FLOAT NOT NULL DEFAULT 0,
  `promo` VARCHAR(50) NULL DEFAULT NULL,
  `discount` FLOAT NOT NULL DEFAULT 0,
  `grandTotal` FLOAT NOT NULL DEFAULT 0,
  `firstName` VARCHAR(50) NULL DEFAULT NULL,
  `middleName` VARCHAR(50) NULL DEFAULT NULL,
  `lastName` VARCHAR(50) NULL DEFAULT NULL,
  `mobile` VARCHAR(15) NULL,
  `email` VARCHAR(50) NULL,
  `line1` VARCHAR(50) NULL DEFAULT NULL,
  `line2` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(50) NULL DEFAULT NULL,
  `province` VARCHAR(50) NULL DEFAULT NULL,
  `country` VARCHAR(50) NULL DEFAULT NULL,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_orders_user` (`userId` ASC),
  CONSTRAINT `fk_orders_user`
    FOREIGN KEY (`userId`)
    REFERENCES `ourstore`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
/** ========== order_item Table ==============*/ 
CREATE TABLE `ourstore`.`order_item` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `productId` BIGINT NOT NULL,
  `orderId` BIGINT NOT NULL,
  `sku` VARCHAR(100) NOT NULL,
  `price` FLOAT NOT NULL DEFAULT 0,
  `discount` FLOAT NOT NULL DEFAULT 0,
  `quantity` SMALLINT(6) NOT NULL DEFAULT 0,
  `createdAt` DATETIME NOT NULL,
  `updatedAt` DATETIME NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_order_item_product` (`productId` ASC),
  CONSTRAINT `fk_order_item_product`
    FOREIGN KEY (`productId`)
    REFERENCES `ourstore`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `ourstore`.`order_item` 
ADD INDEX `idx_order_item_order` (`orderId` ASC);
ALTER TABLE `ourstore`.`order_item` 
ADD CONSTRAINT `fk_order_item_order`
  FOREIGN KEY (`orderId`)
  REFERENCES `ourstore`.`orders` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
/** ========== email Table ==============*/   
CREATE TABLE `ourstore`.`email` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `orderId` BIGINT NOT NULL,
  `sendEmailAddress` TEXT NULL DEFAULT NULL,
  `emailAddress` TEXT NULL DEFAULT NULL,
  `topic` TEXT NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `sendAt` DATETIME NOT NULL,
  `comments` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_email_order`
    FOREIGN KEY (`orderId`)
    REFERENCES `orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
/** ========== product picture Table ==============*/       
CREATE TABLE `ourstore`.`product_pic` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `productId` BIGINT NOT NULL,
  `key` VARCHAR(50) NOT NULL,
  `picURL` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_pic_product` (`productId` ASC),
  UNIQUE INDEX `uq_product_pic` (`productId` ASC, `key` ASC),
  CONSTRAINT `fk_pic_product`
    FOREIGN KEY (`productId`)
    REFERENCES `ourstore`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
