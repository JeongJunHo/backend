create database memberweb;

use memberweb;

create table WebProduct(
	code varchar(50),
    name varchar(30) not null,
    price int not null,
    stock int not null,
    memo text,
    reg_mb_id varchar(30) not null,
    reg_date datetime not null,
    up_mb_id varchar(30),
    up_date datetime,
	primary key(code)
);