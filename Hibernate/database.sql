BEGIN;

DROP TABLE IF EXISTS simple_items CASCADE;
CREATE TABLE simple_items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO simple_items (title, price) VALUES
('box', 10),
('sphere', 20),
('maul', 100),
('door', 50),
('camera', 500);

DROP TABLE IF EXISTS products_tbl CASCADE;
CREATE TABLE products_tbl (id_fld bigserial PRIMARY KEY, title_fld VARCHAR(255), price_fld int);
INSERT INTO products_tbl (title_fld, price_fld) VALUES
('TV', 800),
('vacuum cleaner', 150),
('fridge', 1200),
('play station', 400),
('camera', 500);

COMMIT;