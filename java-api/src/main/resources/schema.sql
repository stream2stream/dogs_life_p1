create table owners(
 owner_id int  AUTO_INCREMENT PRIMARY KEY,
 name int not null
);

create table dogs(
 id int not null,
 name varchar(50) not null,
 age int not null,
 owner_id int,
 FOREIGN KEY(owner_id) REFERENCES owners(owner_id)
);