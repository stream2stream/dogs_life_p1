CREATE TABLE owners
(
owners_id int primary key,
name int
);

CREATE TABLE dogs
(
id int,
name varchar(25),
age int,
owners_id int,
foreign key (owners_id) references owners(owners_id)
);