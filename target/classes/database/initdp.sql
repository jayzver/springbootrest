CREATE TABLE IF NOT EXISTS group_aggregate
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_group VARCHAR(50),
    image_url      VARCHAR(50),
    parent_id      BIGINT,
    has_group INT,
    has_aggregate INT
);