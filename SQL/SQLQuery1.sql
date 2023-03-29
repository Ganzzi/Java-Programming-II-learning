create database demo_java
go

use demo_java
go

create table books (
	id integer identity primary key,
	title nvarchar(250),
	price integer
)
go

insert books(title, price) values 
('How to drink water by mouth',200)
go

select * from books
go