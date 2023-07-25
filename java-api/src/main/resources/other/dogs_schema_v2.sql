CREATE TABLE owners(
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE dogs(
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    age int,
    owner_id int NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES Owners(id)
);