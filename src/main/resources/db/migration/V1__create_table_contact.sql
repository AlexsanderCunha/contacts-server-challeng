CREATE TABLE contact
(
    id            bigint(20) NOT NULL AUTO_INCREMENT,
    name          varchar(100) DEFAULT NULL,
    email          varchar(200) DEFAULT NULL,
    phone          varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);