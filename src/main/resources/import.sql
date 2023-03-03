INSERT INTO users (username, password, first_name, last_name, birth_date, role) VALUES ("admin","$2a$10$NyaltQLE9xiwjHb9EdNFW.J8DvXrfr0wKKPXDwXzA4Cj6epBhBXou", "Vukasin", "Jovanovic", "1999-02-04", "ADMIN");
INSERT INTO users (username, password, first_name, last_name, birth_date, role) VALUES ("korisnik","$2a$10$NyaltQLE9xiwjHb9EdNFW.J8DvXrfr0wKKPXDwXzA4Cj6epBhBXou", "Ana", "Anic", "1999-08-25", "USER");

INSERT INTO products (name, category, price, availability, description, active) VALUES ("Flour T-400 1kg", "BAKING", 91.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Tortillas 320g", "BREAD_AND_BAKERY", 250.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Shampoo 250ml", "PERSONAL_CARE", 400.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Mineral water 500ml", "DRINKS", 44.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Dog food 3kg", "OTHER", 430.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Salted chips 90g", "SNACKS", 105.00, 1, "", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("White bread 500g", "BREAD_AND_BAKERY", 50.00, 1, "", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Chocolate ice cream 750ml", "FROZEN_FOODS", 410.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Apple juice 1L", "DRINKS", 178.00, 0, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Rice 500g", "PASTA_AND_RICE", 130.00, 1, "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Flour T-500 1kg", "BAKING", 90.00, 1, "", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Spaghetti 500g", "PASTA_AND_RICE", 150.00, 0, "", 1);
INSERT INTO products (name, category, price, availability, description, active) VALUES ("Chocolate bar 50g", "SNACKS", 60.00, 0, "", 1);

INSERT INTO orders (date_and_time, user_id) VALUES ('2022-10-10 14:30:00',2);
INSERT INTO orders (date_and_time, user_id) VALUES ('2022-10-11 13:00:00',2);

INSERT INTO accepted_orders (order_id,product_id) VALUES (1,1);
INSERT INTO accepted_orders (order_id,product_id) VALUES (1,2);
INSERT INTO accepted_orders (order_id,product_id) VALUES (2,3);