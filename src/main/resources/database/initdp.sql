CREATE TABLE IF NOT EXISTS group_aggregate
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_target      VARCHAR(50),
    img_url          VARCHAR(50),
    descript        VARCHAR(256),
    parent_id        BIGINT,
    type_of_children INT
);
