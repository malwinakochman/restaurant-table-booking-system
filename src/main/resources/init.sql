CREATE DATABASE IF NOT EXISTS bookingSystem;

USE bookingSystem;

CREATE TABLE IF NOT EXISTS restaurant
(
    restaurant_id   INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(50) NOT NULL,
    street          VARCHAR(50) NOT NULL,
    postal_code     CHAR(6)     NOT NULL,
    city            VARCHAR(50) NOT NULL,
    building_number CHAR(5)     NOT NULL,
    tables          INT         NOT NULL,
    waiters         INT         NOT NULL
    );

CREATE TABLE IF NOT EXISTS waiter
(
    waiter_id      INT AUTO_INCREMENT PRIMARY KEY,
    waiter_name    VARCHAR(50) NOT NULL,
    waiter_surname VARCHAR(50) NOT NULL,
    served_table   INT         NOT NULL,
    phone          CHAR(9)     NOT NULL
    );

CREATE TABLE IF NOT EXISTS customer
(
    customer_id      INT AUTO_INCREMENT PRIMARY KEY,
    customer_surname VARCHAR(50) NOT NULL,
    phone            CHAR(9)     NOT NULL
    );

CREATE TABLE IF NOT EXISTS dishes
(
    dish_id    INT AUTO_INCREMENT PRIMARY KEY,
    dish_name  VARCHAR(50)   NOT NULL,
    dish_price DECIMAL(5, 2) NOT NULL,
    dish_type  VARCHAR(50)   NOT NULL
    );

CREATE TABLE IF NOT EXISTS reservation
(
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    hour           INT  NOT NULL,
    table_id       INT  NOT NULL,
    customer_id    INT  NOT NULL,
    date           DATE NOT NULL,
    FOREIGN KEY (table_id) REFERENCES restaurant_table (table_id),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    CHECK (hour > 8 AND hour < 23)
    );

CREATE TABLE IF NOT EXISTS bill
(
    bill_id        INT AUTO_INCREMENT PRIMARY KEY,
    bill_price     DECIMAL(6, 2) NOT NULL,
    is_payed       BOOLEAN       NOT NULL DEFAULT 0,
    list_of_dishes VARCHAR(50)   NOT NULL,
    reservation_id INT,
    date           DATE NOT NULL,
    waiter_id INT NOT NULL,
    FOREIGN KEY (reservation_id) REFERENCES reservation (reservation_id),
    FOREIGN KEY (date) REFERENCES reservation (date),
    FOREIGN KEY (waiter_id) REFERENCES waiter (waiter_id)

    );

CREATE TABLE IF NOT EXISTS restaurant_table
(
    table_id  INT AUTO_INCREMENT PRIMARY KEY,
    seats     INT NOT NULL,
    waiter_id INT NOT NULL,
    FOREIGN KEY (waiter_id) REFERENCES waiter (waiter_id)
    );

INSERT INTO restaurant (name, street, postal_code, city, building_number, tables, waiters) VALUES
                                                                                               ('Restaurant A', 'Street A', '123456', 'City A', '1A', 10, 5),
                                                                                               ('Restaurant B', 'Street B', '654321', 'City B', '2B', 15, 8);

INSERT INTO waiter (waiter_name, waiter_surname, served_table, phone) VALUES
                                                                          ('John', 'Doe', 1, '123456789'),
                                                                          ('Jane', 'Doe', 2, '987654321');

INSERT INTO customer (customer_surname, phone) VALUES
                                                   ('Smith', '111222333'),
                                                   ('Johnson', '444555666');

INSERT INTO dishes (dish_name, dish_price, dish_type) VALUES
                                                          ('Spaghetti', 9.99, 'MAIN_COURSE'),
                                                          ('Cheesecake', 5.50, 'DESSERT');

INSERT INTO reservation (hour, table_id, customer_id, date) VALUES
                                                                (12, 1, 1,'2023-01-01'),
                                                                (19, 2, 2,'2023-01-02');

INSERT INTO bill (bill_price, is_payed, list_of_dishes, date, waiter_id, reservation_id) VALUES
                                                                                             (15.49, FALSE, 'Spaghetti, Cheesecake','2023-01-01', 1, 1),
                                                                                             (20.99, TRUE, 'Spaghetti x2', '2023-01-02', 2,2);

INSERT INTO restaurant_table (seats, waiter_id) VALUES
                                                    (4, 1),
                                                    (2, 2);

