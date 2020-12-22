show databases;
create database projectsdb;
use projectsdb;
create table vendor(
id int PRIMARY KEY AUTO_INCREMENT,
code varchar(20),
name varchar(20),
type varchar(20),
email varchar(20),
phone varchar(20),
address varchar(20)
);
select * from vendor;
