drop table if exists items;
create table items(
    id int primary key auto_increment,
    name varchar(100) not null,
    category_id int not null,
    counter int
);
drop table if exists categories;
create table categories(
    id int primary key auto_increment,
    name varchar(100) unique
);
drop table if exists votes;
create table votes(
    id int primary key auto_increment,
    item_id int not null,
    secret_code varchar(100) not null
);
alter table items add foreign key (category_id) references categories(id);
alter table votes add foreign key (item_id) references items(id);