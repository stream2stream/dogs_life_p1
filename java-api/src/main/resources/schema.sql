CREATE TABLE Dogs(
    id INT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    owner_id INT FOREIGN KEY REFERENCES Owners(id)
   );

CREATE TABLE Owners(
    id INT PRIMARY KEY,
    name VARCHAR(255)
   );