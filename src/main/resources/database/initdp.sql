CREATE TABLE IF NOT EXISTS groupAggregate
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nameGroup VARCHAR(50),
    imageUrl      VARCHAR(50),
    parentId      BIGINT
);
CREATE TABLE IF NOT EXISTS parentChildren
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    idParent   BIGINT,
    idChildren BIGINT
);