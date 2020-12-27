CREATE TABLE IF NOT EXISTS group_aggregate
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_target      VARCHAR(50),
    img_url          VARCHAR(50),
    descript        VARCHAR(256),
    parent_id        BIGINT,
    type_of_children INT
);

CREATE TABLE IF NOT EXISTS additional_properties
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    aggregate_id BIGINT,
    name_properties VARCHAR(50),
    value_properties VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS provider
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_provider VARCHAR(50),
    internet_address VARCHAR(128),
    physical_address VARCHAR(128),
    email VARCHAR(50),
    phone VARCHAR(13),

)

CREATE TABLE IF NOT EXISTS  aggregate
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_target VARCHAR(50),
    img_url VARCHAR(50),
    descript VARCHAR(256),
    parent_id BIGINT,
    group_id BIGINT,
    quantity INT,
    serial_key VARCHAR(50)
);
