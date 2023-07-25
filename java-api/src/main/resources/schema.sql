create table owners
(
    owner_id int AUTO_INCREMENT PRIMARY KEY,
    name varchar (50) not null
);

create table dogs
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar (50) not null,
    age int not null,
    owner_id int not null,
    FOREIGN key (owner_id) REFERENCES owners (owner_id)
);