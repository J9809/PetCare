CREATE TABLE members (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL,
    pet ENUM('jindo', 'poodle', 'mixed') DEFAULT NULL,
    member_id VARCHAR(255) NOT NULL,
    nickname VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);
