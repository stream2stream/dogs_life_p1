CREATE TABLE Owners(
    id INT PRIMARY KEY,
    name VARCHAR(255)
   );

CREATE TABLE Dogs(
    id INT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES Owners(id)
   );