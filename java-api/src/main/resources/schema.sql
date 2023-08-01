DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
    owner_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE dogs (
    dog_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL,
    owner_id INT NOT NULL,
    FOREIGN key (owner_id) REFERENCES owners (owner_id)
);
