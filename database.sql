-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clientes` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `email_cliente` VARCHAR(45) NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tarjetas_creditos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tarjetas_creditos` (
  `id_tarjeta` INT NOT NULL,
  `cvv_tarjeta` INT NOT NULL,
  `tipo_tarjeta` VARCHAR(45) NOT NULL,
  `fecha_tarjeta` VARCHAR(45) NOT NULL,
  `clientes_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_tarjeta`),
  INDEX `fk_tarjetas_creditos_clientes_idx` (`clientes_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_tarjetas_creditos_clientes`
    FOREIGN KEY (`clientes_id_cliente`)
    REFERENCES `mydb`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pagos` (
  `id_pago` INT NOT NULL AUTO_INCREMENT,
  `valor_pago` INT NOT NULL,
  `time_stamp_pago` VARCHAR(45) NOT NULL,
  `tarjetas_creditos_id_tarjeta` INT NOT NULL,
  PRIMARY KEY (`id_pago`),
  INDEX `fk_pagos_tarjetas_creditos1_idx` (`tarjetas_creditos_id_tarjeta` ASC) VISIBLE,
  CONSTRAINT `fk_pagos_tarjetas_creditos1`
    FOREIGN KEY (`tarjetas_creditos_id_tarjeta`)
    REFERENCES `mydb`.`tarjetas_creditos` (`id_tarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
