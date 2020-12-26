begin;
CREATE SCHEMA shop AUTHORIZATION postgres;

SET search_path TO shop;

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY,
						title varchar(255));
INSERT INTO customers (title) VALUES
('Denis'),
('John'),
('Anna'),
('Maria');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY,
					   title varchar(255),
					   price int);
INSERT INTO products (title, price) VALUES
('Phone', 100),
('TV', 500),
('Camera', 150),
('Monitor', 1250),
('PlayStation5', 4000);

DROP TABLE IF EXISTS purchases CASCADE;
CREATE TABLE purchases (id bigserial PRIMARY KEY, 
						customer_id bigint REFERENCES customers (id), 
						product_id bigint REFERENCES products (id),
						price int);
INSERT INTO purchases (customer_id, product_id, price) VALUES
(1,2,200),
(2,1,600),
(3,1,700),
(4,5,111),
(1,4,60),
(1,5,70),
(2,3,900),
(3,2,550),
(4,2,400),
(2,4,650),
(2,5,700),
(4,1,910),
(3,4,850),
(3,2,350);
						
CREATE TABLE products_customers (customer_id bigint REFERENCES customers (id),
								 product_id bigint REFERENCES products (id));
INSERT INTO products_customers (customer_id, product_id) VALUES
(1,2),
(2,1),
(3,1),
(4,5),
(1,4),
(1,5),
(2,3),
(3,2),
(4,2),
(2,4),
(2,5),
(4,1),
(3,4),
(3,2);

commit;