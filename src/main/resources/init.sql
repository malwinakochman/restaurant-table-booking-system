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

CREATE TABLE IF NOT EXISTS dishes
(
    dish_id    INT AUTO_INCREMENT PRIMARY KEY,
    dish_name  VARCHAR(50)   NOT NULL,
    dish_price DECIMAL(5, 2) NOT NULL,
    dish_type  VARCHAR(50)   NOT NULL
    );

CREATE TABLE IF NOT EXISTS restaurant_table
(
    table_id  INT AUTO_INCREMENT PRIMARY KEY,
    seats     INT NOT NULL,
    waiter_id INT NOT NULL,
    FOREIGN KEY (waiter_id) REFERENCES waiter (waiter_id)
    );

CREATE TABLE IF NOT EXISTS reservation
(
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    table_id       INT  NOT NULL,
    date           DATETIME NOT NULL,
    customer_surname VARCHAR(50),
    customer_phone VARCHAR(9) NOT NULL,
    FOREIGN KEY (table_id) REFERENCES restaurant_table (table_id),
    CHECK (HOUR(date) > 8 AND HOUR(date) < 23)
    );

CREATE TABLE IF NOT EXISTS bill
(
    bill_id        INT AUTO_INCREMENT PRIMARY KEY,
    bill_price     DECIMAL(6, 2) NOT NULL,
    is_payed       BOOLEAN       NOT NULL DEFAULT 0,
    list_of_dishes VARCHAR(500)   NOT NULL,
    reservation_id INT,
    date           DATETIME NOT NULL,
    waiter_id INT NOT NULL,
    FOREIGN KEY (reservation_id) REFERENCES reservation (reservation_id),
    FOREIGN KEY (waiter_id) REFERENCES waiter (waiter_id)

    );

INSERT INTO restaurant (name, street, postal_code, city, building_number, tables, waiters) VALUES
                                                                                               ('Restaurant A', 'Street A', '123456', 'City A', '1A', 10, 5),
                                                                                               ('Restaurant B', 'Street B', '654321', 'City B', '2B', 15, 8);

INSERT INTO waiter (waiter_name, waiter_surname, served_table, phone) VALUES
                                                                          ('Adam', 'Nowak', 1, '123456789'),
                                                                          ('Alicja', 'Kowalska', 2, '987654321'),
                                                                          ('Piotr', 'Wiśniewski', 3, '555111222'),
                                                                          ('Karolina', 'Jankowska', 4, '444555666'),
                                                                          ('Michał', 'Kowalczyk', 5, '777888999'),
                                                                          ('Anna', 'Lewandowska', 6, '111222333'),
                                                                          ('Mateusz', 'Wójcik', 7, '999888777'),
                                                                          ('Natalia', 'Zielińska', 8, '666555444'),
                                                                          ('Krzysztof', 'Kaczmarek', 9, '333444555'),
                                                                          ('Magdalena', 'Piotrowska', 10, '222333444');

INSERT INTO dishes (dish_name, dish_price, dish_type) VALUES
                                                          ('Sałatka Cezar', 15.99, 'STARTER'),
                                                          ('Caprese z Mozzarellą', 18.99, 'STARTER'),
                                                          ('Krewetki w Sosie Czosnkowym', 22.99, 'STARTER'),
                                                          ('Zupa Pomidorowa z Bazylią', 16.99, 'STARTER'),
                                                          ('Chleb Czosnkowy', 17.99, 'STARTER'),
                                                          ('Tosty z Awokado', 18.99, 'STARTER'),
                                                          ('Koktajl z Krewetkami', 19.99, 'STARTER'),
                                                          ('Kanapka Caprese', 21.99, 'STARTER'),
                                                          ('Kanapka z jajkiem', 23.99, 'STARTER'),
                                                            ('Sałatka z Grillowanym Kurczakiem', 20.99, 'STARTER'),

                                                            ('Spaghetti Bolognese', 29.99, 'MAIN_COURSE'),
                                                            ('Kurczak Grilowany', 36.99, 'MAIN_COURSE'),
                                                            ('Stek Wołowy', 39.99, 'MAIN_COURSE'),
                                                            ('Warzywa Smażone', 34.99, 'MAIN_COURSE'),
                                                            ('Wegetariański Stir-Fry', 33.99, 'MAIN_COURSE'),
                                                            ('Łosoś Grilowany', 38.99, 'MAIN_COURSE'),
                                                            ('Stek Z Roquefort', 37.99, 'MAIN_COURSE'),
                                                            ('Pasta Carbonara', 35.99, 'MAIN_COURSE'),
                                                            ('Kotlet Schabowy z Ziemniakami', 30.99, 'MAIN_COURSE'),
                                                            ('Ravioli z Ricottą i Szpinakiem', 31.99, 'MAIN_COURSE'),

                                                            ('Chipsy z Sosem Guacamole', 9.99, 'SIDE_DISH'),
                                                            ('Puree Ziemniaczane', 8.99, 'SIDE_DISH'),
                                                            ('Grillowane Warzywa', 10.99, 'SIDE_DISH'),
                                                            ('Frytki belgijskie', 12.99, 'SIDE_DISH'),
                                                            ('Frytki', 8.99, 'SIDE_DISH'),
                                                            ('Ryż Basmati', 7.99, 'SIDE_DISH'),
                                                            ('Sałatka Ziemniaczana', 9.99, 'SIDE_DISH'),
                                                            ('Kapusta Kiszona', 6.99, 'SIDE_DISH'),
                                                            ('Krokiety z Pieczarkami', 11.99, 'SIDE_DISH'),
                                                            ('Kasza Gryczana z Warzywami', 10.99, 'SIDE_DISH'),

                                                            ('Tiramisu', 16.99, 'DESSERT'),
                                                            ('Panna Cotta', 14.99, 'DESSERT'),
                                                            ('Szarlotka', 13.99, 'DESSERT'),
                                                            ('Truskawkowy Sernik', 17.99, 'DESSERT'),
                                                            ('Lody Waniliowe', 11.99, 'DESSERT'),
                                                            ('Lody Truskawkowe', 15.99, 'DESSERT'),
                                                            ('Tort Czekoladowy', 18.99, 'DESSERT'),
                                                            ('Mus Czekoladowy', 12.99, 'DESSERT'),
                                                            ('Sernik z Borówkami', 19.99, 'DESSERT'),
                                                            ('Deser Czekoladowy z Malinami', 21.99, 'DESSERT'),

                                                            ('Rosół', 15.99, 'SOUP_COURSE'),
                                                            ('Zupa Krem z Dyni', 14.99, 'SOUP_COURSE'),
                                                            ('Zupa Ogórkowa', 13.99, 'SOUP_COURSE'),
                                                            ('Chłodnik', 16.99, 'SOUP_COURSE'),
                                                            ('Zupa z Czerwonej Soczewicy', 17.99, 'SOUP_COURSE'),
                                                            ('Zupa Grzybowa', 18.99, 'SOUP_COURSE'),
                                                            ('Krem Brokułowy', 14.99, 'SOUP_COURSE'),
                                                            ('Zupa Pomidorowa', 13.99, 'SOUP_COURSE'),
                                                            ('Zupa Gulaszowa', 19.99, 'SOUP_COURSE'),
                                                            ('Zupa Paprykowa', 20.99, 'SOUP_COURSE'),

                                                            ('Herbata Mrożona', 15.99, 'DRINKS'),
                                                            ('Cappuccino', 15.99, 'DRINKS'),
                                                            ('Koktajl Bananowy', 17.99, 'DRINKS'),
                                                            ('Lemoniada', 15.99, 'DRINKS'),
                                                            ('Latte', 16.99, 'DRINKS'),
                                                            ('Smoothie Truskawkowe', 18.99, 'DRINKS'),
                                                            ('Woda Gazowana', 7.99, 'DRINKS'),
                                                            ('Espresso', 8.99, 'DRINKS'),
                                                            ('Sok Pomarańczowy', 9.99, 'DRINKS'),
                                                            ('Flat white', 10.99, 'DRINKS');
INSERT INTO restaurant_table (seats, waiter_id) VALUES
                                                    (4, 1),
                                                    (2, 2),
                                                    (6, 3),
                                                    (3, 4),
                                                    (5, 5),
                                                    (2, 6),
                                                    (4, 7),
                                                    (6, 8),
                                                    (3, 9),
                                                    (5, 10);

INSERT INTO reservation (table_id, date, customer_surname, customer_phone) VALUES
                                                                ( 1,'2023-01-01 12:00:00', 'Smith', '111222333'),
                                                                ( 2,'2023-01-01 19:00:00', 'Hudson', '123123123');

INSERT INTO bill (bill_price, is_payed, list_of_dishes, date, waiter_id, reservation_id) VALUES
                                                                                             (34.38, FALSE, 'Sałatka Cezar, Caprese z Mozzarellą','2023-01-01 12:00:00', 1, 1),
                                                                                             (12.99, TRUE, 'Frytki belgijskie', '2023-01-01 19:00:00', 2,2);



