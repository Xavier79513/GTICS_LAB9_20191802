USE lab9;
CREATE TABLE IF NOT EXISTS `lab9`.`cocteles` (
  `idDrink` INT NOT NULL,
  `strDrink` VARCHAR(50) NULL,
  `strDrinkThumb` VARCHAR(200) NULL,
  `strDrinkAlternate` VARCHAR(200) NULL,
  `strTags` VARCHAR(150) NULL,
  `strVideo` VARCHAR(150) NULL,
  `strCategory` VARCHAR(150) NULL,
  `strIBA` VARCHAR(150) NULL,
  `strAlcoholic` VARCHAR(45) NULL,
  `strGlass` VARCHAR(95) NULL,
  `strInstructions` TEXT NULL,
  `strInstructionsES` TEXT NULL,
  `strInstructionsDE` TEXT NULL,
  `strInstructionsFR` TEXT NULL,
  `strInstructionsIT` TEXT NULL,
  `strImageSource` VARCHAR(200) NULL,
  `strImageAttribution` VARCHAR(200) NULL,
  `strCreativeCommonsConfirmed` VARCHAR(3) NULL,
  `dateModified` DATETIME NULL,
  PRIMARY KEY (`idDrink`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `lab9`.`ingredientes` (
  `idIngrediente` INT NOT NULL AUTO_INCREMENT,
  `strIngredient` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idIngrediente`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `lab9`.`coctel_ingredientes` (
  `idDrink` INT NOT NULL,
  `idIngrediente` INT NOT NULL,
  `strMeasure` VARCHAR(60) NULL,
  `orden` INT NOT NULL,
  PRIMARY KEY (`idDrink`, `idIngrediente`),
  FOREIGN KEY (`idDrink`) REFERENCES `lab9`.`cocteles` (`idDrink`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`idIngrediente`) REFERENCES `lab9`.`ingredientes` (`idIngrediente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB;