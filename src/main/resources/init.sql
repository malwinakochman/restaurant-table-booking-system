CREATE DATABASE IF NOT EXISTS bookingSystem;

USE bookingSystem;

CREATE TABLE IF NOT EXISTS Restaurant (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    postal_code CHAR(6) NOT NULL,
    city VARCHAR(50) NOT NULL,
    building_number CHAR(5) NOT NULL,
    tables INT NOT NULL,
    waiters INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Waiter (
    waiterId INT AUTO_INCREMENT PRIMARY KEY,
    waiterName VARCHAR(50) NOT NULL,
    waiterSurname VARCHAR(50) NOT NULL,
    servedTable INT NOT NULL,
    phone CHAR(9) NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer (
    customerId INT AUTO_INCREMENT PRIMARY KEY,
    customerSurname VARCHAR(50) NOT NULL,
    phone CHAR(9) NOT NULL
);

CREATE TABLE IF NOT EXISTS Dishes (
    dishId INT AUTO_INCREMENT PRIMARY KEY,
    dishName VARCHAR(50) NOT NULL,
    dishPrice DECIMAL(5, 2) NOT NULL,
    dishType VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Bill (
    billId INT AUTO_INCREMENT PRIMARY KEY,
    billPrice DECIMAL(6, 2) NOT NULL,
    isPayed BOOLEAN NOT NULL DEFAULT 0,
    listOfDishes VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Table` (
    tableId INT AUTO_INCREMENT PRIMARY KEY,
    steats INT NOT NULL,
    waiterId INT NOT NULL,
    FOREIGN KEY (waiterId) REFERENCES Waiter(waiterId)
);

CREATE TABLE IF NOT EXISTS Reservation (
    reservationId INT AUTO_INCREMENT PRIMARY KEY,
    hour INT NOT NULL,
    tableId INT NOT NULL,
    customerId INT NOT NULL,
    billId INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (tableId) REFERENCES `Table`(tableId),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (billId) REFERENCES Bill(billId),
    CHECK (hour > 8 AND hour < 23)
);

CREATE VIEW View_1 AS
SELECT `Table`.waiterId, Customer.customerId, Bill.billId, `Table`.tableId
FROM Reservation
INNER JOIN Customer ON Reservation.customerId = Customer.customerId
INNER JOIN Bill ON Reservation.billId = Bill.billId
INNER JOIN `Table` ON Reservation.tableId = `Table`.tableId
CROSS JOIN Dishes
CROSS JOIN Restaurant;
CREATE DATABASE IF NOT EXISTS bookingSystem;

USE bookingSystem;

CREATE TABLE IF NOT EXISTS Restaurant (
                                          restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    postal_code CHAR(6) NOT NULL,
    city VARCHAR(50) NOT NULL,
    building_number CHAR(5) NOT NULL,
    tables INT NOT NULL,
    waiters INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS Waiter (
                                      waiterId INT AUTO_INCREMENT PRIMARY KEY,
                                      waiterName VARCHAR(50) NOT NULL,
    waiterSurname VARCHAR(50) NOT NULL,
    servedTable INT NOT NULL,
    phone CHAR(9) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Customer (
                                        customerId INT AUTO_INCREMENT PRIMARY KEY,
                                        customerSurname VARCHAR(50) NOT NULL,
    phone CHAR(9) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Dishes (
                                      dishId INT AUTO_INCREMENT PRIMARY KEY,
                                      dishName VARCHAR(50) NOT NULL,
    dishPrice DECIMAL(5, 2) NOT NULL,
    dishType VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Bill (
                                    billId INT AUTO_INCREMENT PRIMARY KEY,
                                    billPrice DECIMAL(6, 2) NOT NULL,
    isPayed BOOLEAN NOT NULL DEFAULT 0,
    listOfDishes VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS `Table` (
                                       tableId INT AUTO_INCREMENT PRIMARY KEY,
                                       steats INT NOT NULL,
                                       waiterId INT NOT NULL,
                                       FOREIGN KEY (waiterId) REFERENCES Waiter(waiterId)
    );

CREATE TABLE IF NOT EXISTS Reservation (
                                           reservationId INT AUTO_INCREMENT PRIMARY KEY,
                                           hour INT NOT NULL,
                                           tableId INT NOT NULL,
                                           customerId INT NOT NULL,
                                           billId INT NOT NULL,
                                           date DATE NOT NULL,
                                           FOREIGN KEY (tableId) REFERENCES `Table`(tableId),
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (billId) REFERENCES Bill(billId),
    CHECK (hour > 8 AND hour < 23)
    );

CREATE VIEW View_1 AS
SELECT `Table`.waiterId, Customer.customerId, Bill.billId, `Table`.tableId
FROM Reservation
         INNER JOIN Customer ON Reservation.customerId = Customer.customerId
         INNER JOIN Bill ON Reservation.billId = Bill.billId
         INNER JOIN `Table` ON Reservation.tableId = `Table`.tableId
         CROSS JOIN Dishes
         CROSS JOIN Restaurant;

INSERT INTO Restaurant (name, street, postal_code, city, building_number, tables, waiters)
VALUES ('Nazwa Restauracji', 'Ulica', '00-000', 'Miasto', '1', 10, 5);
