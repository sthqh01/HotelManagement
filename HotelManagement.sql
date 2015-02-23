/*Create table for Customer */
CREATE TABLE Customer
(
cID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
firstName VARCHAR(100),
lastName VARCHAR(100),
birthday DATE,
age INT(11),
gender VARCHAR(100),
phoneNumber VARCHAR(100),
email VARCHAR(100),
address VARCHAR(100),
city VARCHAR(100),
state VARCHAR(100),
zipcode VARCHAR(100),
country VARCHAR(100)
);
/* Create table for Service */
CREATE TABLE Service
(
sID INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
sName VARCHAR(100) NOT NULL,
category VARCHAR(100),
detail VARCHAR(100),
price DECIMAL(11, 2),
inventoryQuantity INT(11)
)