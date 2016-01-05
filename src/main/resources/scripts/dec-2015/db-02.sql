-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hackandslash
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hackandslash` ;

-- -----------------------------------------------------
-- Schema hackandslash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hackandslash` DEFAULT CHARACTER SET utf8 ;
USE `hackandslash` ;

-- -----------------------------------------------------
-- Table `hackandslash`.`GameCharacter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameCharacter` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `gender` INT(1) NOT NULL,
  `age` INT(2) NULL DEFAULT NULL,
  `race` INT(11) NOT NULL,
  `profession` INT(11) NOT NULL,
  `strength` INT(11) NULL DEFAULT NULL,
  `dexterity` INT(11) NULL DEFAULT NULL,
  `constitution` INT(11) NULL DEFAULT NULL,
  `intelligence` INT(11) NULL DEFAULT NULL,
  `charisma` INT(11) NULL DEFAULT NULL,
  `baseHP` INT(11) NOT NULL,
  `experience` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category` INT(11) NULL DEFAULT NULL,
  `twoHanded` INT(1) NULL DEFAULT 0,
  `wage` INT(11) NULL DEFAULT 1,
  `amount` INT(11) NULL DEFAULT 0,
  `attack` INT(11) NULL DEFAULT 0,
  `defend` INT(11) NULL DEFAULT 0,
  `magic` INT(11) NULL DEFAULT 0,
  `addHealth` INT(11) NULL DEFAULT 0,
  `addStrength` INT(11) NULL DEFAULT 0,
  `addDexterity` INT(11) NULL DEFAULT 0,
  `addConstitution` INT(11) NULL DEFAULT 0,
  `addIntelligence` INT(11) NULL DEFAULT 0,
  `addCharisma` INT(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Equipment` (
  `id` INT(11) NOT NULL,
  `Item_id` INT(11) NULL DEFAULT NULL,
  `GameCharacter_id` INT(11) NOT NULL,
  `inPlace` INT(1) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Equipment_GameCharacter1_idx` (`GameCharacter_id` ASC) ,
  INDEX `fk_Equipment_Item1_idx` (`Item_id` ASC) ,
  CONSTRAINT `fk_Equipment_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `hackandslash`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipment_Item1`
    FOREIGN KEY (`Item_id`)
    REFERENCES `hackandslash`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameRole` (
  `id` INT(11) NOT NULL,
  `rolename` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`GameUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`GameUser` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `age` INT(2) NULL DEFAULT NULL,
  `gender` INT(1) NULL DEFAULT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `activated` INT(1) NOT NULL,
  `GameRole_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_GameUser_GameRole1_idx` (`GameRole_id` ASC) ,
  CONSTRAINT `fk_GameUser_GameRole1`
    FOREIGN KEY (`GameRole_id`)
    REFERENCES `hackandslash`.`GameRole` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Place` (
  `id` INT(11) NOT NULL,
  `latitude` INT(11) NOT NULL,
  `longitude` INT(11) NOT NULL,
  `radius` INT(11) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Hero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Hero` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `activated` INT(1) NOT NULL,
  `Place_id` INT(11) NOT NULL,
  `GameUser_id` INT(11) NOT NULL,
  `GameCharacter_id` INT(11) NOT NULL,
  `money` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Hero_Place_idx` (`Place_id` ASC) ,
  INDEX `fk_Hero_GameUser1_idx` (`GameUser_id` ASC) ,
  INDEX `fk_Hero_GameCharacter1_idx` (`GameCharacter_id` ASC) ,
  CONSTRAINT `fk_Hero_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `hackandslash`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hero_GameUser1`
    FOREIGN KEY (`GameUser_id`)
    REFERENCES `hackandslash`.`GameUser` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hero_Place`
    FOREIGN KEY (`Place_id`)
    REFERENCES `hackandslash`.`Place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Quest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Quest` (
  `id` INT(11) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `target` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Journal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Journal` (
  `id` INT(11) NOT NULL,
  `Hero_id` INT(11) NOT NULL,
  `Quest_id` INT(11) NULL DEFAULT NULL,
  `startDate` DATETIME NULL DEFAULT now(),
  `passed` INT(1) NOT NULL,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hackandslash`.`Npc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackandslash`.`Npc` (
  `id` INT(11) NOT NULL,
  `behaviour` INT(1) NOT NULL,
  `GameCharacter_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_NPC_GameCharacter1_idx` (`GameCharacter_id` ASC) ,
  CONSTRAINT `fk_NPC_GameCharacter1`
    FOREIGN KEY (`GameCharacter_id`)
    REFERENCES `hackandslash`.`GameCharacter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `hackandslash`.`GameCharacter`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`GameCharacter` (`id`, `firstname`, `lastname`, `gender`, `age`, `race`, `profession`, `strength`, `dexterity`, `constitution`, `intelligence`, `charisma`, `baseHP`, `experience`) VALUES (1, 'Mariusz', 'Braveheart', 1, 27, 1, 3, 12, 16, 16, 12, 10, 10, 1);
INSERT INTO `hackandslash`.`GameCharacter` (`id`, `firstname`, `lastname`, `gender`, `age`, `race`, `profession`, `strength`, `dexterity`, `constitution`, `intelligence`, `charisma`, `baseHP`, `experience`) VALUES (2, 'Ork', 'Warrior', 1, NULL, 3, 2, 12, 10, 14, 2, 2, 8, 1);
INSERT INTO `hackandslash`.`GameCharacter` (`id`, `firstname`, `lastname`, `gender`, `age`, `race`, `profession`, `strength`, `dexterity`, `constitution`, `intelligence`, `charisma`, `baseHP`, `experience`) VALUES (3, 'Villager', NULL, 1, NULL, 1, 0, NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `hackandslash`.`GameCharacter` (`id`, `firstname`, `lastname`, `gender`, `age`, `race`, `profession`, `strength`, `dexterity`, `constitution`, `intelligence`, `charisma`, `baseHP`, `experience`) VALUES (4, 'Jacek', NULL, 1, 26, 1, 3, 14, 16, 15, 12, 10, 10, 1);
INSERT INTO `hackandslash`.`GameCharacter` (`id`, `firstname`, `lastname`, `gender`, `age`, `race`, `profession`, `strength`, `dexterity`, `constitution`, `intelligence`, `charisma`, `baseHP`, `experience`) VALUES (5, 'Jacek2', NULL, 1, 26, 1, 3, 14, 16, 15, 12, 10, 10, 1000);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Item`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Item` (`id`, `name`, `category`, `wage`, `attack`, `defend`, `magic`, `addHealth`, `addStrength`, `addDexterity`, `addConstitution`, `addIntelligence`, `addCharisma`, `amount`) VALUES (1, 'Long Sword', 2, 5, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10);
INSERT INTO `hackandslash`.`Item` (`id`, `name`, `category`, `twoHanded`, `wage`, `amount`, `attack`) VALUES (2, "Staff", 4, 1, 4, 0, 2);
INSERT INTO `hackandslash`.`Item` (`id`, `name`, `category`, `twoHanded`, `wage`, `amount`, `addHealth`) VALUES (3, "Potion of healing", 5, 0, 1, 112, 8);


COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Equipment`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Equipment` (`id`, `Item_id`, `GameCharacter_id`, `inPlace`) VALUES (1, 1, 1, 1);
INSERT INTO `hackandslash`.`Equipment` (`id`, `Item_id`, `GameCharacter_id`, `inPlace`) VALUES (2, 1, 2, 1);
INSERT INTO `hackandslash`.`Equipment` (`id`, `Item_id`, `GameCharacter_id`, `inPlace`) VALUES (3, 1, 4, 1);
INSERT INTO `hackandslash`.`Equipment` (`id`, `Item_id`, `GameCharacter_id`, `inPlace`) VALUES (4, 3, 4, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`GameRole`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`GameRole` (`id`, `rolename`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `hackandslash`.`GameRole` (`id`, `rolename`) VALUES (2, 'ROLE_USER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`GameUser`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`GameUser` (`id`, `firstname`, `lastname`, `age`, `gender`, `login`, `password`, `email`, `activated`, `GameRole_id`) VALUES (1, 'Mariusz', 'Czarny', 27, 1, 'mczarny', '123', 'mariusz.zlatan@gmail.com', 1, 1);
INSERT INTO `hackandslash`.`GameUser` (`id`, `firstname`, `lastname`, `age`, `gender`, `login`, `password`, `email`, `activated`, `GameRole_id`) VALUES (2, 'Jacek', 'Bednarczyk', 26, 1, 'jbednarczyk', '123', 'jacek@bednarczyk.pl', 1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Place`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Place` (`id`, `latitude`, `longitude`, `radius`) VALUES (1, 100, 200, 10);
INSERT INTO `hackandslash`.`Place` (`id`, `latitude`, `longitude`, `radius`) VALUES (2, 200, 250, 15);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Hero`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Hero` (`id`, `activated`, `Place_id`, `GameUser_id`, `GameCharacter_id`, `money`) VALUES (1, 1, 1, 1, 1, DEFAULT);
INSERT INTO `hackandslash`.`Hero` (`id`, `activated`, `Place_id`, `GameUser_id`, `GameCharacter_id`, `money`) VALUES (2, 1, 1, 2, 4, DEFAULT);
INSERT INTO `hackandslash`.`Hero` (`id`, `activated`, `Place_id`, `GameUser_id`, `GameCharacter_id`, `money`) VALUES (3, 1, 1, 2, 5, DEFAULT);
COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Quest`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Quest` (`id`, `description`, `target`) VALUES (1, 'Find and kill an Ork', 'Ork');

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Journal`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Journal` (`id`, `Hero_id`, `Quest_id`, `startDate`, `passed`) VALUES (1, 1, 1, '2015-10-11', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `hackandslash`.`Npc`
-- -----------------------------------------------------
START TRANSACTION;
USE `hackandslash`;
INSERT INTO `hackandslash`.`Npc` (`id`, `behaviour`, `GameCharacter_id`) VALUES (1, 1, 2);
INSERT INTO `hackandslash`.`Npc` (`id`, `behaviour`, `GameCharacter_id`) VALUES (2, 2, 3);

COMMIT;
