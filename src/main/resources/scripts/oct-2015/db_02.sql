-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hackandslash
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hackandslash`;
-- -----------------------------------------------------
-- Schema hackandslash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hackandslash` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hackandslash` ;

-- -----------------------------------------------------
-- Table `hackandslash`.`Place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Place` (
  `id` INT NOT NULL,
  `latitude` INT NOT NULL,
  `longitude` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameRole` (
  `id` INT NOT NULL,
  `rolename` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameUser` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `age` INT(2) NULL,
  `gender` INT(1) NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `activated` INT(1) NOT NULL,
  `GameRole_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_GameUser_GameRole1_idx` (`GameRole_id` ASC),
  CONSTRAINT `fk_GameUser_GameRole1`
    FOREIGN KEY (`GameRole_id`)
    REFERENCES `hackandslash`.`GameRole` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Equipment` (
  `id` INT NOT NULL,
  `Item_id` INT NULL,
  `GameCharacter_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Equipment_GameCharacter1_idx` (`GameCharacter_id` ASC),
  INDEX `fk_Equipment_Item1_idx` (`Item_id` ASC),
  CONSTRAINT `fk_Equipment_Item1`
    FOREIGN KEY (`Item_id`)
    REFERENCES `hackandslash`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipment_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `hackandslash`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameCharacter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameCharacter` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `gender` INT(1) NOT NULL,
  `age` INT(2) NULL,
  `race` INT NOT NULL,
  `profession` INT NOT NULL,
  `strength` INT NULL,
  `dexterity` INT NULL,
  `constitution` INT NULL,
  `intelligence` INT NULL,
  `charisma` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Hero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Hero` (
  `id` INT NOT NULL,
  `activated` INT(1) NOT NULL,
  `Place_id` INT NOT NULL,
  `GameUser_id` INT NOT NULL,
  `GameCharacter_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Hero_Place_idx` (`Place_id` ASC) ,
  INDEX `fk_Hero_GameUser1_idx` (`GameUser_id` ASC) ,
  INDEX `fk_Hero_GameCharacter1_idx` (`GameCharacter_id` ASC) ,
  CONSTRAINT `fk_Hero_Place`
    FOREIGN KEY (`Place_id`)
    REFERENCES `hackandslash`.`Place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hero_GameUser1`
    FOREIGN KEY (`GameUser_id`)
    REFERENCES `hackandslash`.`GameUser` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hero_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `hackandslash`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Item` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `category` INT NULL,
  `wage` INT NULL,
  `attack` INT NULL,
  `defend` INT NULL,
  `magic` INT NULL,
  `addHealth` INT NULL,
  `addStrength` INT NULL,
  `addDexterity` INT NULL,
  `addConstitution` INT NULL,
  `addIntelligence` INT NULL,
  `addCharisma` INT NULL,
  `amount` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Quest` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `target` VARCHAR(45) NOT NULL,
  `startDate` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`NPC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Npc` (
  `id` INT NOT NULL,
  `behaviour` INT(1) NOT NULL,
  `GameCharacter_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_NPC_GameCharacter1_idx` (`GameCharacter_id` ASC) ,
  CONSTRAINT `fk_NPC_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `hackandslash`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Journal` 
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Journal` (
  `id` INT NOT NULL,
  `Hero_id` INT NOT NULL,
  `Quest_id` INT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Journal_Quest1_idx` (`Quest_id` ASC) ,
  INDEX `fk_Journal_Hero1_idx` (`Hero_id` ASC) ,
  CONSTRAINT `fk_Journal_Hero1`
    FOREIGN KEY (`Hero_id`)
    REFERENCES `hackandslash`.`Hero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Journal_Quest1`
    FOREIGN KEY (`Quest_id`)
    REFERENCES `hackandslash`.`Quest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

