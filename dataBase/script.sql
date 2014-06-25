SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dietProject` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `dietProject` ;

-- -----------------------------------------------------
-- Table `dietProject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `pass` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `birth` DATE NULL,
  `last_login` DATETIME NULL,
  `language` VARCHAR(5) NULL DEFAULT 'en',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`measure_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`measure_type` (
  `idmeasure_type` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `tip` TEXT NULL,
  PRIMARY KEY (`idmeasure_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`measure_historic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`measure_historic` (
  `measure_historic_id` INT NOT NULL AUTO_INCREMENT,
  `user_user_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `value` DECIMAL(20,3) NOT NULL,
  `measure_type_idmeasure_type` INT NOT NULL,
  PRIMARY KEY (`measure_historic_id`),
  INDEX `fk_measure_historic_user_idx` (`user_user_id` ASC),
  INDEX `fk_measure_historic_measure_type1_idx` (`measure_type_idmeasure_type` ASC),
  CONSTRAINT `fk_measure_historic_user`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `dietProject`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_measure_historic_measure_type1`
    FOREIGN KEY (`measure_type_idmeasure_type`)
    REFERENCES `dietProject`.`measure_type` (`idmeasure_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`food_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`food_type` (
  `food_type_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`food_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`food` (
  `food_id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NULL,
  `food_type_food_type_id` INT NOT NULL,
  PRIMARY KEY (`food_id`),
  INDEX `fk_food_food_type1_idx` (`food_type_food_type_id` ASC),
  CONSTRAINT `fk_food_food_type1`
    FOREIGN KEY (`food_type_food_type_id`)
    REFERENCES `dietProject`.`food_type` (`food_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`food_alias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`food_alias` (
  `food_alias_id` INT NOT NULL,
  `food_food_id` INT NOT NULL,
  `alias` VARCHAR(45) NULL,
  PRIMARY KEY (`food_alias_id`),
  INDEX `fk_food_alias_food1_idx` (`food_food_id` ASC),
  CONSTRAINT `fk_food_alias_food1`
    FOREIGN KEY (`food_food_id`)
    REFERENCES `dietProject`.`food` (`food_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`unity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`unity` (
  `unity_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`unity_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`nutrient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`nutrient` (
  `nutrient_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `unity_unity_id` INT NOT NULL,
  PRIMARY KEY (`nutrient_id`),
  INDEX `fk_nutrient_unity1_idx` (`unity_unity_id` ASC),
  CONSTRAINT `fk_nutrient_unity1`
    FOREIGN KEY (`unity_unity_id`)
    REFERENCES `dietProject`.`unity` (`unity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`food_nutrient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`food_nutrient` (
  `food_food_id` INT NOT NULL,
  `nutrient_nutrient_id` INT NOT NULL,
  `quantity` DECIMAL(25,5) NULL,
  PRIMARY KEY (`food_food_id`, `nutrient_nutrient_id`),
  INDEX `fk_food_nutrient_food1_idx` (`food_food_id` ASC),
  INDEX `fk_food_nutrient_nutrient1_idx` (`nutrient_nutrient_id` ASC),
  CONSTRAINT `fk_food_nutrient_food1`
    FOREIGN KEY (`food_food_id`)
    REFERENCES `dietProject`.`food` (`food_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_food_nutrient_nutrient1`
    FOREIGN KEY (`nutrient_nutrient_id`)
    REFERENCES `dietProject`.`nutrient` (`nutrient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`conversion_factor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`conversion_factor` (
  `conversion_factor_id` INT NOT NULL AUTO_INCREMENT,
  `unity_destiny` INT NOT NULL,
  `unity_origin` INT NOT NULL,
  `factor` DECIMAL(20,2) NOT NULL,
  PRIMARY KEY (`conversion_factor_id`),
  INDEX `fk_conversion_factor_unity1_idx` (`unity_origin` ASC),
  INDEX `fk_conversion_factor_unity2_idx` (`unity_destiny` ASC),
  CONSTRAINT `fk_conversion_factor_unity1`
    FOREIGN KEY (`unity_origin`)
    REFERENCES `dietProject`.`unity` (`unity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conversion_factor_unity2`
    FOREIGN KEY (`unity_destiny`)
    REFERENCES `dietProject`.`unity` (`unity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`user_diet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`user_diet` (
  `user_diet_id` INT NOT NULL AUTO_INCREMENT,
  `name` TINYTEXT NULL,
  `observation` TEXT NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`user_diet_id`),
  INDEX `fk_user_diet_user1_idx` (`user_user_id` ASC),
  CONSTRAINT `fk_user_diet_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `dietProject`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`meal` (
  `idmeal` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `hour` TIME NULL,
  `observation` TEXT NULL,
  `user_diet_user_diet_id` INT NOT NULL,
  PRIMARY KEY (`idmeal`),
  INDEX `fk_meal_user_diet1_idx` (`user_diet_user_diet_id` ASC),
  CONSTRAINT `fk_meal_user_diet1`
    FOREIGN KEY (`user_diet_user_diet_id`)
    REFERENCES `dietProject`.`user_diet` (`user_diet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`meal_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`meal_item` (
  `idmeal_item` INT NOT NULL AUTO_INCREMENT,
  `quantity` VARCHAR(45) NULL,
  `food_food_id` INT NOT NULL,
  `meal_idmeal` INT NULL,
  PRIMARY KEY (`idmeal_item`),
  INDEX `fk_meal_item_food1_idx` (`food_food_id` ASC),
  INDEX `fk_meal_item_meal1_idx` (`meal_idmeal` ASC),
  CONSTRAINT `fk_meal_item_food1`
    FOREIGN KEY (`food_food_id`)
    REFERENCES `dietProject`.`food` (`food_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_meal_item_meal1`
    FOREIGN KEY (`meal_idmeal`)
    REFERENCES `dietProject`.`meal` (`idmeal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`user_diet_has_meal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`user_diet_has_meal` (
  `user_diet_user_diet_id` INT NOT NULL,
  `meal_idmeal` INT NOT NULL,
  PRIMARY KEY (`user_diet_user_diet_id`, `meal_idmeal`),
  INDEX `fk_user_diet_has_meal_meal1_idx` (`meal_idmeal` ASC),
  INDEX `fk_user_diet_has_meal_user_diet1_idx` (`user_diet_user_diet_id` ASC),
  CONSTRAINT `fk_user_diet_has_meal_user_diet1`
    FOREIGN KEY (`user_diet_user_diet_id`)
    REFERENCES `dietProject`.`user_diet` (`user_diet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_diet_has_meal_meal1`
    FOREIGN KEY (`meal_idmeal`)
    REFERENCES `dietProject`.`meal` (`idmeal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dietProject`.`meal_item_hist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dietProject`.`meal_item_hist` (
  `idmeal_item_hist` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `meal_item_idmeal_item` INT NOT NULL,
  PRIMARY KEY (`idmeal_item_hist`),
  INDEX `fk_meal_item_hist_meal_item1_idx` (`meal_item_idmeal_item` ASC),
  CONSTRAINT `fk_meal_item_hist_meal_item1`
    FOREIGN KEY (`meal_item_idmeal_item`)
    REFERENCES `dietProject`.`meal_item` (`idmeal_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
