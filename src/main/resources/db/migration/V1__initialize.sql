CREATE TABLE prod_category (id bigserial primary key, title varchar(255));

INSERT INTO prod_category(title) values
('категория 1'),
('категория 2');

CREATE TABLE products (id bigserial primary key, title varchar(255), price int, category bigint);

insert into products (title, price, category) values
('Перчатки', 1200, 1),
('Куртка', 5500, 1),
('Шапка', 3000, 1),
('Худи', 4000, 1),
('Носки', 800, 1),
('Пояс', 1000, 1),
('Пиджак', 6800, 1),
('Шарф', 1400, 1),
('Рубашка', 1800, 1),
('Пальто', 19000, 1),
('Джинсы', 3100, 1),
('Майка', 1000, 2),
('Джемпер', 2500, 2),
('Жилет', 4400, 2),
('Свитер', 5300, 2),
('Юбка', 3000, 2),
('Галстук', 4500, 2),
('Шорты', 1200, 2),
('Жакет', 2300, 2),
('Бриджи', 1500, 2);

ALTER TABLE products ADD FOREIGN KEY (category) REFERENCES prod_category(id);
