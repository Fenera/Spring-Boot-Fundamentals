CREATE TABLE store.products
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    `description` TEXT   NOT NULL,
    price         DECIMAL(10, 2) NULL,
    category_id   TINYINT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE store.products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES store.categories (id);