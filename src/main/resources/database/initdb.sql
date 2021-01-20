# CREATE TABLE IF NOT EXISTS group_aggregate
# (
#     id               BIGINT AUTO_INCREMENT PRIMARY KEY,
#     name_target      VARCHAR(50),
#     img_url          VARCHAR(50),
#     descript         VARCHAR(256),
#     parent_id        BIGINT,
#     type_of_children INT
# );

CREATE TABLE IF NOT EXISTS provider
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_target    VARCHAR(50),
    descript         VARCHAR(256),
    internet_address VARCHAR(128),
    physical_address VARCHAR(128),
    email            VARCHAR(50),
    phone            VARCHAR(256),
    img_url          VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS aggregate
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_target VARCHAR(50),
    img_url     VARCHAR(50),
    descript    VARCHAR(256),
    parent_id   BIGINT,
    group_id    BIGINT,
    quantity    INT,
    serial_key  VARCHAR(50)

);

CREATE TABLE IF NOT EXISTS aggregate_provider
(
    aggregate_id BIGINT NOT NULL,
    provider_id  BIGINT NOT NULL,
    PRIMARY KEY (aggregate_id, provider_id),
    KEY provider_id (provider_id),
    CONSTRAINT aggregate_provider_fk_1 FOREIGN KEY (aggregate_id)REFERENCES aggregate (id),
    CONSTRAINT aggregate_provider_fk_2 FOREIGN KEY (provider_id) REFERENCES provider (id)
);

CREATE TABLE IF NOT EXISTS aggregate_img
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    aggregate_id BIGINT,
    img_url      VARCHAR(50),
    CONSTRAINT aggregate_img_fk1 FOREIGN KEY (aggregate_id) REFERENCES aggregate(id)
);

CREATE TABLE IF NOT EXISTS aggregate_file
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    aggregate_id BIGINT,
    file_url     VARCHAR(50),
    CONSTRAINT aggregate_file_fk1 FOREIGN KEY (aggregate_id) REFERENCES aggregate(id)
);

CREATE TABLE IF NOT EXISTS additional_properties
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    aggregate_id     BIGINT,
    prop_name  VARCHAR(50),
    prop_value VARCHAR(128),
    CONSTRAINT aggregate_properties_fk1 FOREIGN KEY (aggregate_id) REFERENCES aggregate(id)
);
