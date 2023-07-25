DROP TABLE IF EXISTS owners;

 CREATE TABLE owners
 (
     owner_id int auto_increment PRIMARY KEY,
     name varchar(50) not null
 );

 DROP TABLE IF EXISTS dogs;

 CREATE TABLE dogs
 (
     dog_id int AUTO_INCREMENT PRIMARY KEY,
     name varchar (50) not null,
     age int not null,
     owner_id int not null,
     FOREIGN key (owner_id) REFERENCES owners (owner_id)
 );
