INSERT INTO buyer (id, name) VALUES (1, 'Vasya');
INSERT INTO buyer (id, name) VALUES (2, 'Luba');

INSERT INTO product (id, title, price) VALUES (1, 'maslo', 125);
INSERT INTO product (id, title, price) VALUES (2, 'hleb', 56);
INSERT INTO product (id, title, price) VALUES (3, 'salo', 300);

INSERT INTO buyer_product (product_id, buyer_id) VALUES (1, 1);
INSERT INTO buyer_product (product_id, buyer_id) VALUES (2, 1);
INSERT INTO buyer_product (product_id, buyer_id) VALUES (2, 2);
INSERT INTO buyer_product (product_id, buyer_id) VALUES (3, 2);
