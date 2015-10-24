-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Place` (
  `id` INT NOT NULL COMMENT '',
  `latitude` VARCHAR(45) NULL COMMENT '',
  `longitude` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`GameRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`GameRole` (
  `id` INT NOT NULL COMMENT '',
  `rolename` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`GameUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`GameUser` (
  `id` INT NOT NULL COMMENT '',
  `firstname` VARCHAR(45) NULL COMMENT '',
  `lastname` VARCHAR(45) NULL COMMENT '',
  `age` INT NULL COMMENT '',
  `gender` INT NULL COMMENT '',
  `login` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `activated` INT NULL COMMENT '',
  `GameRole_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_GameUser_GameRole1_idx` (`GameRole_id` ASC)  COMMENT '',
  CONSTRAINT `fk_GameUser_GameRole1`
    FOREIGN KEY (`GameRole_id`)
    REFERENCES `mydb`.`GameRole` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Equipment` (
  `id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`GameCharacter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`GameCharacter` (
  `id` INT NOT NULL COMMENT '',
  `firstname` VARCHAR(45) NULL COMMENT '',
  `lastname` VARCHAR(45) NULL COMMENT '',
  `gender` VARCHAR(45) NULL COMMENT '',
  `age` VARCHAR(45) NULL COMMENT '',
  `race` VARCHAR(45) NULL COMMENT '',
  `profession` VARCHAR(45) NULL COMMENT '',
  `strength` INT NULL COMMENT '',
  `dexterity` INT NULL COMMENT '',
  `constitution` INT NULL COMMENT '',
  `intelligence` INT NULL COMMENT '',
  `charisma` INT NULL COMMENT '',
  `Equipment_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_GameCharacter_Equipment1_idx` (`Equipment_id` ASC)  COMMENT '',
  CONSTRAINT `fk_GameCharacter_Equipment1`
    FOREIGN KEY (`Equipment_id`)
    REFERENCES `mydb`.`Equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Hero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Hero` (
  `id` INT NOT NULL COMMENT '',
  `activated` VARCHAR(45) NULL COMMENT '',
  `Place_id` INT NOT NULL COMMENT '',
  `GameUser_id` INT NOT NULL COMMENT '',
  `GameCharacter_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Hero_Place_idx` (`Place_id` ASC)  COMMENT '',
  INDEX `fk_Hero_GameUser1_idx` (`GameUser_id` ASC)  COMMENT '',
  INDEX `fk_Hero_GameCharacter1_idx` (`GameCharacter_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Hero_Place`
    FOREIGN KEY (`Place_id`)
    REFERENCES `mydb`.`Place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hero_GameUser1`
    FOREIGN KEY (`GameUser_id`)
    REFERENCES `mydb`.`GameUser` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hero_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `mydb`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Item` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `type` INT NULL COMMENT '',
  `wage` INT NULL COMMENT '',
  `attack` INT NULL COMMENT '',
  `defend` INT NULL COMMENT '',
  `magic` INT NULL COMMENT '',
  `addHealth` INT NULL COMMENT '',
  `addStrength` INT NULL COMMENT '',
  `addDexterity` INT NULL COMMENT '',
  `addConstitution` INT NULL COMMENT '',
  `addIntelligence` INT NULL COMMENT '',
  `addCharisma` INT NULL COMMENT '',
  `amount` INT NULL COMMENT '',
  `Equipment_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Item_Equipment1_idx` (`Equipment_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Item_Equipment1`
    FOREIGN KEY (`Equipment_id`)
    REFERENCES `mydb`.`Equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Quest` (
  `id` INT NOT NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  `target` VARCHAR(45) NULL COMMENT '',
  `startDate` DATE NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Journal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Journal` (
  `id` INT NOT NULL COMMENT '',
  `Hero_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Journal_Hero1_idx` (`Hero_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Journal_Hero1`
    FOREIGN KEY (`Hero_id`)
    REFERENCES `mydb`.`Hero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NPC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NPC` (
  `id` INT NOT NULL COMMENT '',
  `behaviour` VARCHAR(45) NULL COMMENT '',
  `GameCharacter_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_NPC_GameCharacter1_idx` (`GameCharacter_id` ASC)  COMMENT '',
  CONSTRAINT `fk_NPC_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `mydb`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Journal_has_Quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Journal_has_Quest` (
  `Journal_id` INT NOT NULL COMMENT '',
  `Quest_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Journal_id`, `Quest_id`)  COMMENT '',
  INDEX `fk_Journal_has_Quest_Quest1_idx` (`Quest_id` ASC)  COMMENT '',
  INDEX `fk_Journal_has_Quest_Journal1_idx` (`Journal_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Journal_has_Quest_Journal1`
    FOREIGN KEY (`Journal_id`)
    REFERENCES `mydb`.`Journal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Journal_has_Quest_Quest1`
    FOREIGN KEY (`Quest_id`)
    REFERENCES `mydb`.`Quest` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
