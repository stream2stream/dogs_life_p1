DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS owners;

CREATE TABLE owners (
owner_id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL
);

CREATE TABLE dogs (
id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
age INT NOT NULL,
owner_id INT NOT NULL,
FOREIGN KEY(owner_id) REFERENCES owners(owner_id)
);

CREATE VIEW dogs_and_owners as
select a.name as dog_name, a.age as dog_age, a.owner_id as owner_id, b.name as owner_name
from
dogs a
LEFT JOIN
owners b
on a.owner_id=b.owner_id;