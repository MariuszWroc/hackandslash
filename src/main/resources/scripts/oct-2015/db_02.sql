-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hackandslash
-- -----------------------------------------------------

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
  `latitude` VARCHAR(45),
  `longitude` VARCHAR(45),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameRole` (
  `id` INT NOT NULL,
  `rolename` VARCHAR(45),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameUser` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45),
  `lastname` VARCHAR(45),
  `age` INT,
  `gender` INT,
  `login` VARCHAR(45),
  `password` VARCHAR(45),
  `activated` INT,
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
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameCharacter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameCharacter` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45),
  `lastname` VARCHAR(45),
  `gender` VARCHAR(45),
  `age` VARCHAR(45),
  `race` VARCHAR(45),
  `profession` VARCHAR(45),
  `strength` INT,
  `dexterity` INT,
  `constitution` INT,
  `intelligence` INT,
  `charisma` INT,
  `Equipment_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_GameCharacter_Equipment1_idx` (`Equipment_id` ASC) ,
  CONSTRAINT `fk_GameCharacter_Equipment1`
    FOREIGN KEY (`Equipment_id`)
    REFERENCES `hackandslash`.`Equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Hero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Hero` (
  `id` INT NOT NULL,
  `activated` VARCHAR(45),
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
  `name` VARCHAR(45),
  `type` INT,
  `wage` INT,
  `attack` INT,
  `defend` INT,
  `magic` INT,
  `addHealth` INT,
  `addStrength` INT,
  `addDexterity` INT,
  `addConstitution` INT,
  `addIntelligence` INT,
  `addCharisma` INT,
  `amount` INT,
  `Equipment_id` INT NOT,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Item_Equipment1_idx` (`Equipment_id` ASC) ,
  CONSTRAINT `fk_Item_Equipment1`
    FOREIGN KEY (`Equipment_id`)
    REFERENCES `hackandslash`.`Equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Quest` (
  `id` INT NOT NULL,
  `description` VARCHAR(45),
  `target` VARCHAR(45),
  `startDate` DATE,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`Journal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Journal` (
  `id` INT NOT NULL,
  `Hero_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Journal_Hero1_idx` (`Hero_id` ASC) ,
  CONSTRAINT `fk_Journal_Hero1`
    FOREIGN KEY (`Hero_id`)
    REFERENCES `hackandslash`.`Hero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hackandslash`.`NPC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`NPC` (
  `id` INT NOT NULL,
  `behaviour` VARCHAR(45),
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
-- Table `hackandslash`.`Journal_has_Quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Journal_has_Quest` (
  `Journal_id` INT NOT NULL,
  `Quest_id` INT NOT NULL,
  PRIMARY KEY (`Journal_id`, `Quest_id`) ,
  INDEX `fk_Journal_has_Quest_Quest1_idx` (`Quest_id` ASC) ,
  INDEX `fk_Journal_has_Quest_Journal1_idx` (`Journal_id` ASC) ,
  CONSTRAINT `fk_Journal_has_Quest_Journal1`
    FOREIGN KEY (`Journal_id`)
    REFERENCES `hackandslash`.`Journal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Journal_has_Quest_Quest1`
    FOREIGN KEY (`Quest_id`)
    REFERENCES `hackandslash`.`Quest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
