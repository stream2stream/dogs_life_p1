create table owners
(
    owner_id int AUTO_INCREMENT primary key,
    name int not null

    );

create table dogs
(
     id int AUTO_INCREMENT primary key,
     name varchar(50) not null,
     age int not null,
     FOREIGN key (id) REFERENCES owners (owner_id)
     );